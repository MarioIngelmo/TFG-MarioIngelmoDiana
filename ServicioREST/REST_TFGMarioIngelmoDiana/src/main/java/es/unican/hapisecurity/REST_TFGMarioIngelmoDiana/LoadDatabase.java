package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.CaracteristicaRepository;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.DispositivoRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(DispositivoRepository repositoryDispositivos, CaracteristicaRepository repositoryCaracteristicas) {

		return args -> {
			CuentaAhorro cuenta = new CuentaAhorro();
			cuenta.setFechaApertura(LocalDate.now());
			cuenta.setNumero("1");
			cuenta.setSaldo(15);
			cuenta.setTipoCuenta(TipoCuenta.Oro);
			List<ProductoBancario> prod = new LinkedList<ProductoBancario>();
			prod.add(cuenta);
			prodBancarioRepository.save(cuenta);
			log.info("Preloading " + repository.save(new Cliente("11111111A", "Pepe", "Pepon Pepin", prod)));
			log.info("Preloading " + repository.save(new Cliente("22222222B", "Juan", "Juanon Juanin", null)));
		};
	}
}