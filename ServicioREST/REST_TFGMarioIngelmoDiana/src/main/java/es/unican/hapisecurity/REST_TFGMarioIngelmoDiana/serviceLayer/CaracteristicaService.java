package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.serviceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Caracteristica;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.CaracteristicaRepository;

public class CaracteristicaService {
	
	@Autowired
	private CaracteristicaRepository repositorio;
	
	public Caracteristica caracteristicaPorId(Long id) {
		Optional<Caracteristica> carcateristicaOptional = repositorio.findById(id);
		if (carcateristicaOptional.isEmpty()) {
			return null;
		}
		return carcateristicaOptional.get();
	}
	
	public Caracteristica creaCaracteristica(Caracteristica d) {
		Optional<Caracteristica> optional = repositorio.findById(d.getId());
		if (!optional.isEmpty())
			return null;
		return repositorio.saveAndFlush(d);
	}
	
	public List<Caracteristica> caracteristicas() {
		return repositorio.findAll();
	}

}
