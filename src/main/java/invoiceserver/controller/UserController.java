package invoiceserver.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import invoiceserver.model.LoginBody;
import invoiceserver.model.Users;
import invoiceserver.repository.UserRepository;
import invoiceserver.response.ErrorResponse;
import invoiceserver.response.Response;
import invoiceserver.utils.JwtGenerator;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping
	public Iterable<Users> findAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public Object findUserById(@PathVariable int id)  {

		Optional<Users> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return ErrorResponse.setResponse(HttpStatus.NO_CONTENT ,"No Data" , 204);
			
		}
	}
//	@RequestMapping("/login")
//	@PostMapping 
//	public Object adadUser(@RequestBody LoginBody loginBody) {
//		try {
////			userRepository.save(user);
//			System.out.println(loginBody);
//			return Response.setResponse(HttpStatus.OK, "User Added Succesfully", 200);
//		} catch (IllegalArgumentException  e) {			
//			e.printStackTrace();
//			return ErrorResponse.setResponse(HttpStatus.BAD_REQUEST, "Argument Invalid", 400);
//		}
//	}
	@PostMapping 
	public Object addUser(@RequestBody Users user) {
		try {
//			userRepository.save(user);
			return Response.setResponse(HttpStatus.OK, "User Added Succesfully", 200);
		} catch (IllegalArgumentException  e) {			
			e.printStackTrace();
			return ErrorResponse.setResponse(HttpStatus.BAD_REQUEST, "Argument Invalid", 400);
		}
	}

	@PutMapping
	public Object updateUser(@RequestBody Users user) {
		try {
//			userRepository.save(user);
			return Response.setResponse(HttpStatus.OK, "User Added Succesfully", 200);
		} catch (IllegalArgumentException e) {			
			e.printStackTrace();
			return ErrorResponse.setResponse(HttpStatus.BAD_REQUEST, "No Sufficent Params", 400);
		}
	}

	@DeleteMapping
	public Object deleteUser(@RequestParam int id) {
		try {
//			userRepository.deleteById(id);
			return Response.setResponse(HttpStatus.OK, "User Deleted Succesfully", 200);
		} catch (IllegalArgumentException e) {			
			e.printStackTrace();
			return ErrorResponse.setResponse(HttpStatus.BAD_REQUEST, "Illegal Argument", 400);
		}
	}

	
}
