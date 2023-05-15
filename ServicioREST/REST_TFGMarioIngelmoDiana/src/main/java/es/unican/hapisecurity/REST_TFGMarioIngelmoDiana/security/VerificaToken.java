package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.security;

import java.io.IOException;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
@Seguridad
public class VerificaToken implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("holaaaaa");
		String tokenSinCortar = requestContext.getHeaderString("Authorization");
		if (tokenSinCortar == null) {
			requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
		} else {
			String token = tokenSinCortar.substring(7);
			if (!GestionTokens.validaToken(token)) {
				requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
			}
		}
	}

}