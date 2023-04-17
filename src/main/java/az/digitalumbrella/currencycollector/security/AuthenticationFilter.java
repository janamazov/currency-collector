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
        String authToken = request.getHeader("Authorization");
        if (authToken != null && authToken.substring(6).equals("YWRtaW5AY2F1Y2FzdXN0ZWNoLmF6OmkzWVJmaTB0TWdqUEcwelZxU0RqQ0M3RA==")) {
             Authentication authentication = new UsernamePasswordAuthenticationToken("admin", null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

}
