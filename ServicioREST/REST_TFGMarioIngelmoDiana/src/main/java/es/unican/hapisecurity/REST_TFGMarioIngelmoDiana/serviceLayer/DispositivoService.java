package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.serviceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Dispositivo;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.DispositivoRepository;

public class DispositivoService {
	
	@Autowired
	private DispositivoRepository repositorio;
	
	public Dispositivo dispositivoPorId(String id) {
		Optional<Dispositivo> dispositivoOptional = repositorio.findById(id);
		if (dispositivoOptional.isEmpty()) {
			return null;
		}
		return dispositivoOptional.get();
	}
	
	public Dispositivo creaDispositivo(Dispositivo d) {
		Optional<Dispositivo> optional = repositorio.findById(d.getId());
		if (!optional.isEmpty())
			return null;
		return repositorio.saveAndFlush(d);
	}
	
	public Dispositivo actualizaDispositivo(Dispositivo d) {
		Optional<Dispositivo> optional = repositorio.findById(d.getId());
		if (optional.isEmpty())
			return null;
		repositorio.delete(optional.get());
		return repositorio.saveAndFlush(d);
	}
	
	public List<Dispositivo> dispositivos() {
		return repositorio.findAll();
	}

}
