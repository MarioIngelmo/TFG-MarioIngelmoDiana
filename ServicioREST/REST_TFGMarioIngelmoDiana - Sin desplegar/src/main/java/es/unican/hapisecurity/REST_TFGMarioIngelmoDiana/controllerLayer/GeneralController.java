package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.controllerLayer;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Caracteristica;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Categoria;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Dispositivo;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.ListaCaracteristicas;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.ListaDispositivos;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.TipoOrdenar;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.serviceLayer.GeneralService;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.security.*;

@RestController
@RequestMapping("REST_TFGMarioIngelmoDiana")
public class GeneralController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl usuarioDetailsService;

	@Autowired
	private GestionTokens gestion;

	@Autowired
	private GeneralService servicio;

	@PostMapping("/token")
	public ResponseEntity<String> getToken(@RequestBody Credenciales c) {
		if (c == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(c.getUsuario(), c.getClave()));
			usuarioDetailsService.loadUserByUsername(c.getUsuario());
			String token = gestion.generaToken(c.getUsuario(), c.getClave());
			if (token == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			} else {
				return ResponseEntity.ok(token);
			}
		}
	}

	@GetMapping("/dispositivos")
	public ResponseEntity<ListaDispositivos> getDispositivos(
			@RequestParam(value = "categoria", required = false) String categoria,
			@RequestParam(value = "seguridad", required = false) String seguridad,
			@RequestParam(value = "sostenibilidad", required = false) String sostenibilidad,
			@RequestParam(value = "ordenar", required = false) String ordenar) {
		List<Dispositivo> dispositivos = servicio.dispositivos();
		if (dispositivos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		if (categoria != null && !categoria.equals("Todas")) {
			dispositivos = dispositivos.stream().filter(d -> d.getCategoria() == Categoria.valueOf(categoria))
					.collect(Collectors.toList());
		}
		if (seguridad != null && Integer.valueOf(seguridad) >= 0 && Integer.valueOf(seguridad) <= 100) {
			dispositivos = dispositivos.stream().filter(d -> d.getSeguridad() >= Integer.valueOf(seguridad))
					.collect(Collectors.toList());
		}
		if (sostenibilidad != null) {
			dispositivos = dispositivos.stream()
					.filter(d -> d.getSostenibilidad().matches("[A-" + sostenibilidad.toUpperCase() + "]"))
					.collect(Collectors.toList());
		}
		if (ordenar != null && (ordenar.equals("Alfabetico") || ordenar.equals("Seguridad") || ordenar.equals("Sostenibilidad"))) {
			switch (TipoOrdenar.valueOf(ordenar)) {
			case Alfabetico:
				dispositivos = dispositivos.stream().sorted(Comparator.comparing(Dispositivo::getNombre, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList());
				break;
			case Seguridad:
				dispositivos = dispositivos.stream().sorted(Comparator.comparingInt(Dispositivo::getSeguridad).reversed()).collect(Collectors.toList());
				break;
			case Sostenibilidad:
				dispositivos = dispositivos.stream().sorted(Comparator.comparing(Dispositivo::getSostenibilidad)).collect(Collectors.toList());
				break;
			default:
				break;
			}
		}
		return ResponseEntity.ok(new ListaDispositivos(dispositivos));
	}

	@GetMapping("/dispositivos/{id}")
	public ResponseEntity<Dispositivo> getDispositivo(@PathVariable String id) {
		Dispositivo d = servicio.dispositivoPorId(id);
		if (d == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(d);
	}

	@PutMapping("/dispositivos/{id}")
	public ResponseEntity<Dispositivo> creaOReemplazaDispositivo(@PathVariable String id, @RequestBody Dispositivo d) {
		if (!d.getId().equals(id))
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		if (servicio.dispositivoPorId(id) == null) {
			Dispositivo creado = servicio.creaDispositivo(d);
			if (creado == null)
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
			return ResponseEntity.created(location).body(creado);
		}
		Dispositivo actualizado = servicio.actualizaDispositivo(d);
		if (actualizado == null)
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).body(actualizado);
	}

	@GetMapping("/caracteristicas")
	public ResponseEntity<ListaCaracteristicas> getCaracteristicas() {
		List<Caracteristica> caracteristicas = servicio.caracteristicas();
		if (caracteristicas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new ListaCaracteristicas(caracteristicas));
	}

	@GetMapping("/caracteristicas/{id}")
	public ResponseEntity<Caracteristica> getCaracteristica(@PathVariable String id) {
		Caracteristica c = servicio.caracteristicaPorId(Long.valueOf(id));
		if (c == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(c);
	}

	@PostMapping("/caracteristicas")
	public ResponseEntity<Caracteristica> creaCaracteristica(@RequestBody Caracteristica c) {
		Caracteristica creado = servicio.creaCaracteristica(c);
		if (creado == null)
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).body(creado);
	}

}
