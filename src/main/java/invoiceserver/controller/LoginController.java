package invoiceserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import invoiceserver.model.LoginBody;
import invoiceserver.model.UserDetails;
import invoiceserver.model.Users;
import invoiceserver.repository.UserRepository;
import invoiceserver.response.ErrorResponse;
import invoiceserver.response.Response;
import invoiceserver.utils.JwtGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public Object adadUser(@RequestBody LoginBody loginBody) {
		try {
			List<Users> userList = userRepository.tryLogin(loginBody.getUserName(), loginBody.getPassword());
			var user = new Users();
			var userDetails = new UserDetails();
			if (userList.size() == 1) {
				for (Users userItem : userList) {
					user = userItem;
				}
				Claims claims = Jwts.claims().setSubject(user.getUserName());
				String jwt = Jwts.builder().setClaims(claims).compact();
				String token = JwtGenerator.generateJWT(claims, jwt);
				return userDetails.setUserBody(user, token);
			} else {
				return ErrorResponse.setResponse(HttpStatus.UNAUTHORIZED, "Usename or password is incorrect ", 401);
			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return ErrorResponse.setResponse(HttpStatus.BAD_REQUEST, "Argument Invalid", 400);
		}
	}
}
