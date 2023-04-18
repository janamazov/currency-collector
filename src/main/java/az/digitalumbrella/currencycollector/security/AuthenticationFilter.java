package az.digitalumbrella.currencycollector.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws   IOException, ServletException {
        String authToken = request.getHeader("x-authorization-token");
        if (authToken != null && authToken.equals("rFcOirGU3v9n4643q4Xu952qyA5JZtZsR8ybPj6zuA")) {
             Authentication authentication = new UsernamePasswordAuthenticationToken("admin", null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

}
