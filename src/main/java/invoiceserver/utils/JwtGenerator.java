package invoiceserver.utils;

import java.util.Date;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtGenerator {
    UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken("adminn", "pass");
    private static String secret = "secret";
    // System.out.println(authReq);
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	public static String generateJWT(Map<String, Object> claims, String subject) {
		try {
			return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
					.signWith(SignatureAlgorithm.HS512, secret).compact();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
	}
}
