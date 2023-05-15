package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.serviceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Caracteristica;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.CaracteristicaRepository;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Dispositivo;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.DispositivoRepository;

@Service
public class GeneralService {

	@Autowired
	private DispositivoRepository repositorioDispositivos;

	@Autowired
	private CaracteristicaRepository repositorioCaracteristicas;

	public List<Dispositivo> dispositivos() {
		return repositorioDispositivos.findAll();
	}

	public Dispositivo dispositivoPorId(String id) {
		Optional<Dispositivo> dispositivoOptional = repositorioDispositivos.findById(id);
		if (dispositivoOptional.isEmpty()) {
			return null;
		}
		return dispositivoOptional.get();
	}

	public Dispositivo creaDispositivo(Dispositivo d) {
		Optional<Dispositivo> optional = repositorioDispositivos.findById(d.getId());
		if (!optional.isEmpty())
			return null;
		return repositorioDispositivos.saveAndFlush(d);
	}

	public Dispositivo actualizaDispositivo(Dispositivo d) {
		Optional<Dispositivo> optional = repositorioDispositivos.findById(d.getId());
		if (optional.isEmpty())
			return null;
		return repositorioDispositivos.saveAndFlush(d);
	}

	public List<Caracteristica> caracteristicas() {
		return repositorioCaracteristicas.findAll();
	}

	public Caracteristica caracteristicaPorId(Long id) {
		Optional<Caracteristica> carcateristicaOptional = repositorioCaracteristicas.findById(id);
		if (carcateristicaOptional.isEmpty()) {
			return null;
		}
		return carcateristicaOptional.get();
	}

	public Caracteristica creaCaracteristica(Caracteristica d) {
		Optional<Caracteristica> optional = repositorioCaracteristicas.findById(d.getId());
		if (!optional.isEmpty())
			return null;
		return repositorioCaracteristicas.saveAndFlush(d);
	}

}
