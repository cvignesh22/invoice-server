package invoiceserver.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse {
	public static  ResponseEntity<Object> setResponse( HttpStatus status ,String msg , int code) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.clear();
		response.put("message", msg );
		response.put("responseCode", code);
		return new ResponseEntity<Object>( response , status);
	}
	
}
 