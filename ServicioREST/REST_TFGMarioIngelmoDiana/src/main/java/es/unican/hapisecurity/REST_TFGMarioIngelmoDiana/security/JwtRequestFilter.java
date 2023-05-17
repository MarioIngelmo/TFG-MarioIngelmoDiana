package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.HttpMethod;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private GestionTokens gestionTokens;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		final String authorizationHeader = request.getHeader("Authorization");

		String jwt = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
		}

		if (request.getMethod().equals(HttpMethod.GET.toString())) {
			// Si el método HTTP es GET, se permite el acceso sin autenticación
			chain.doFilter(request, response);
			return;
		}

		if (request.getMethod().equals("POST") && request.getRequestURI().equals("/REST_TFGMarioIngelmoDiana/token")) {
			// Si el método HTTP es el POST para conseguir el token, se permite el acceso
			// sin autenticación
			chain.doFilter(request, response);
			return;
		}

		if (jwt == null) {
			return;
		}

		if (SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.userDetailsService.loadUserByUsername("mario");

			if (gestionTokens.validaToken(jwt)) {

				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			} else {
				return;
			}
		}
		chain.doFilter(request, response);
	}

}
