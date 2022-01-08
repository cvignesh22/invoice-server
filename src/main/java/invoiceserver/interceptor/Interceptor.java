package invoiceserver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import invoiceserver.response.ErrorResponse;

@Component
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(("Request intercepted: " + request.getHeader("Authorization") ) + request.getRequestURI());
        ErrorResponse.setResponse(HttpStatus.BAD_REQUEST, "Argument Invalid", 400);
        return true;
    }

}
