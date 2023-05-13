package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.controllerLayer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Caracteristica;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Dispositivo;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.serviceLayer.CaracteristicaService;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.serviceLayer.DispositivoService;

@RestController
@RequestMapping("/REST_TFG_MarioIngelmoDiana")
public class GeneralController {
	
	@Autowired
	private DispositivoService servicioDispositivos;
	
	@Autowired
	private CaracteristicaService servicioCaracteristicas;
	
	@GetMapping("/dispositivos")
	public ResponseEntity<List<Dispositivo>> getDispositivos() {
		List<Dispositivo> dispositivos = servicioDispositivos.dispositivos();
		if (dispositivos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(dispositivos);
	}
	
	@GetMapping("/caracteristicas")
	public ResponseEntity<List<Caracteristica>> getCaracteristicas() {
		List<Caracteristica> caracteristicas = servicioCaracteristicas.caracteristicas();
		if (caracteristicas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(caracteristicas);
	}
	
	@PutMapping("/dispositivos/{id}")
	public ResponseEntity<Dispositivo> creaDispositivo(@PathVariable String id, @RequestBody Dispositivo d) {
		if (!d.getId().equals(id))
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		Dispositivo creado = servicioDispositivos.creaDispositivo(d);
		if (creado == null)
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).body(creado);
	}
	
	@GetMapping("/dispositivos/{id}")
	public ResponseEntity<Dispositivo> getDispositivo(@PathVariable String id) {
		Dispositivo d = servicioDispositivos.dispositivoPorId(id);
		if (d == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(d);
	}
	
	@PostMapping("/caracteristicas")
	public ResponseEntity<Caracteristica> creaCaracteristica(@RequestBody Caracteristica c) {
		Caracteristica creado = servicioCaracteristicas.creaCaracteristica(c);
		if (creado == null)
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(location).body(creado);
	}
	
	@GetMapping("/caracteristicas/{id}")
	public ResponseEntity<Caracteristica> getCaracteristica(@PathVariable String id) {
		Caracteristica c = servicioCaracteristicas.caracteristicaPorId(Long.valueOf(id));
		if (c == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(c);
	}

}
