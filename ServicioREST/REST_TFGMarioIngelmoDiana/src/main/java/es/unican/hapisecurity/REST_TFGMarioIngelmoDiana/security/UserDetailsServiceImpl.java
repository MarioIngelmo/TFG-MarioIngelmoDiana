package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.security;

import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		var usuario = getById(username);

		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.withUsername(username).password(usuario.getPassword())
				.roles(usuario.getRoles().toArray(new String[0])).build();
	}

	public static Usuario getById(String username) {
		var password = "$2a$12$09rKnwiL5ZPtiXEB4j7W0.BtHEBdKTbDF9rTDgKwABQHOzqITf4U2";
		Usuario mario = new Usuario("mario", password, Set.of("ADMIN"));

		var usuarios = List.of(mario);

		return usuarios.stream().filter(e -> e.getUsername().equals(username)).findFirst().orElse(null);
	}
}
