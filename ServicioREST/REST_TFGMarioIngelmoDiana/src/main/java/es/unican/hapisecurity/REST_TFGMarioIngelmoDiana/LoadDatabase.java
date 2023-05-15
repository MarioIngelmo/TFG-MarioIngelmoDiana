package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Caracteristica;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.CaracteristicaRepository;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Categoria;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.Dispositivo;
import es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.repositoryLayer.DispositivoRepository;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(DispositivoRepository repositoryDispositivos,
			CaracteristicaRepository repositoryCaracteristicas) {

		return args -> {
			Caracteristica caractBuenaSeguridad = new Caracteristica();
			caractBuenaSeguridad.setTexto(
					"Autenticación fuerte de usuario: Requerir una autenticación sólida, como la autenticación de dos factores, para acceder al dispositivo.");
			Caracteristica caractBuenaSeguridad2 = new Caracteristica();
			caractBuenaSeguridad2.setTexto(
					"Cifrado de datos: La encriptación de datos transmitidos y almacenados, lo que dificulta su acceso no autorizado.");
			Caracteristica caractBuenaSeguridad3 = new Caracteristica();
			caractBuenaSeguridad3.setTexto(
					"Control de acceso basado en roles: Un sistema de control de acceso que limita la capacidad de cada usuario para acceder y controlar el dispositivo.");
			Caracteristica caractBuenaSeguridad4 = new Caracteristica();
			caractBuenaSeguridad4.setTexto(
					"Notificaciones de seguridad en tiempo real: Alertas en tiempo real de cualquier actividad sospechosa o comportamiento anormal del dispositivo.");
			Caracteristica caractBuenaSeguridad5 = new Caracteristica();
			caractBuenaSeguridad5.setTexto(
					"Monitoreo de integridad del sistema: Supervisión continua de la salud y el rendimiento del sistema para detectar y solucionar problemas de seguridad.");
			Caracteristica caractBuenaSeguridad6 = new Caracteristica();
			caractBuenaSeguridad6.setTexto(
					"Detección de intrusiones: La capacidad de detectar y responder a intentos de intrusión y ataques maliciosos.");
			Caracteristica caractBuenaSeguridad7 = new Caracteristica();
			caractBuenaSeguridad7.setTexto(
					"Compatibilidad con protocolos de seguridad estándar: Soporte de protocolos de seguridad estándar, como SSL/TLS y AES, para proteger la comunicación de red.");
			Caracteristica caractBuenaSeguridad8 = new Caracteristica();
			caractBuenaSeguridad8.setTexto(
					"Desactivación de funciones innecesarias: Desactivar todas las funciones que no sean necesarias para minimizar el riesgo de ataques a través de estas funciones.");
			Caracteristica caractBuenaSeguridad9 = new Caracteristica();
			caractBuenaSeguridad9.setTexto(
					"Registro de auditoría: Mantener un registro detallado de las actividades del dispositivo para ayudar a detectar y solucionar problemas de seguridad.");
			repositoryCaracteristicas.save(caractBuenaSeguridad);
			repositoryCaracteristicas.save(caractBuenaSeguridad2);
			repositoryCaracteristicas.save(caractBuenaSeguridad3);
			repositoryCaracteristicas.save(caractBuenaSeguridad4);
			repositoryCaracteristicas.save(caractBuenaSeguridad5);
			repositoryCaracteristicas.save(caractBuenaSeguridad6);
			repositoryCaracteristicas.save(caractBuenaSeguridad7);
			repositoryCaracteristicas.save(caractBuenaSeguridad8);
			repositoryCaracteristicas.save(caractBuenaSeguridad9);

			Caracteristica caractMalaSeguridad = new Caracteristica();
			caractMalaSeguridad.setTexto(
					"Contraseñas predeterminadas débiles: Contraseñas que son fáciles de adivinar o que no se pueden cambiar fácilmente.");
			Caracteristica caractMalaSeguridad2 = new Caracteristica();
			caractMalaSeguridad2.setTexto(
					"Comunicaciones no cifradas: La falta de encriptación de los datos transmitidos entre el dispositivo y otros dispositivos o servidores.");
			Caracteristica caractMalaSeguridad3 = new Caracteristica();
			caractMalaSeguridad3.setTexto(
					"Vulnerabilidades conocidas no corregidas: No solucionar vulnerabilidades de seguridad conocidas en el firmware del dispositivo.");
			Caracteristica caractMalaSeguridad4 = new Caracteristica();
			caractMalaSeguridad4.setTexto(
					"Permisos de usuario inadecuados: No tener un control de acceso adecuado que limite el acceso y control del dispositivo según el rol del usuario.");
			Caracteristica caractMalaSeguridad5 = new Caracteristica();
			caractMalaSeguridad5.setTexto(
					"Falta de actualizaciones de seguridad: No proporcionar actualizaciones regulares para corregir vulnerabilidades de seguridad y problemas conocidos.");
			Caracteristica caractMalaSeguridad6 = new Caracteristica();
			caractMalaSeguridad6.setTexto(
					"Exposición de información personal del usuario: La falta de protección de los datos personales del usuario almacenados en el dispositivo o transmitidos a través de él.");
			Caracteristica caractMalaSeguridad7 = new Caracteristica();
			caractMalaSeguridad7.setTexto(
					"Puntos de entrada no seguros: Puntos de entrada al sistema que son vulnerables a ataques maliciosos, como puertos abiertos o interfaces web mal protegidas.");
			Caracteristica caractMalaSeguridad8 = new Caracteristica();
			caractMalaSeguridad8.setTexto(
					"Falta de autenticación de usuario: Permitir que cualquier persona pueda acceder y controlar el dispositivo sin autenticación adecuada.");
			Caracteristica caractMalaSeguridad9 = new Caracteristica();
			caractMalaSeguridad9.setTexto(
					"Aplicaciones de terceros inseguras: La falta de seguridad en las aplicaciones de terceros que se utilizan en conjunción con el dispositivo.");
			Caracteristica caractMalaSeguridad10 = new Caracteristica();
			caractMalaSeguridad10.setTexto(
					"Configuraciones inseguras: La configuración incorrecta del dispositivo o de su software, que puede exponerlo a vulnerabilidades y ataques maliciosos.");
			repositoryCaracteristicas.save(caractMalaSeguridad);
			repositoryCaracteristicas.save(caractMalaSeguridad2);
			repositoryCaracteristicas.save(caractMalaSeguridad3);
			repositoryCaracteristicas.save(caractMalaSeguridad4);
			repositoryCaracteristicas.save(caractMalaSeguridad5);
			repositoryCaracteristicas.save(caractMalaSeguridad6);
			repositoryCaracteristicas.save(caractMalaSeguridad7);
			repositoryCaracteristicas.save(caractMalaSeguridad8);
			repositoryCaracteristicas.save(caractMalaSeguridad9);
			repositoryCaracteristicas.save(caractMalaSeguridad10);

			Caracteristica caractBuenaSostenibilidad = new Caracteristica();
			caractBuenaSostenibilidad.setTexto(
					"Eficiencia energética: Los dispositivos IoT que son energéticamente eficientes pueden ayudar a reducir el consumo de energía y, por lo tanto, reducir la huella de carbono.");
			Caracteristica caractBuenaSostenibilidad2 = new Caracteristica();
			caractBuenaSostenibilidad2.setTexto(
					"Diseño modular: Los dispositivos IoT que están diseñados con módulos intercambiables y actualizables pueden extender su vida útil y reducir la cantidad de residuos electrónicos.");
			Caracteristica caractBuenaSostenibilidad3 = new Caracteristica();
			caractBuenaSostenibilidad3.setTexto(
					"Reciclabilidad: Los dispositivos IoT que son reciclables o están diseñados para su desmontaje y reciclaje pueden ayudar a reducir la cantidad de residuos electrónicos.");
			Caracteristica caractBuenaSostenibilidad4 = new Caracteristica();
			caractBuenaSostenibilidad4.setTexto(
					"Uso de materiales sostenibles: Los dispositivos IoT que utilizan materiales sostenibles, como plásticos reciclados o materiales de origen biológico, pueden reducir su impacto ambiental.");
			Caracteristica caractBuenaSostenibilidad5 = new Caracteristica();
			caractBuenaSostenibilidad5.setTexto(
					"Monitoreo ambiental: Los dispositivos IoT que monitorean el medio ambiente pueden ayudar a identificar y abordar problemas ambientales.");
			Caracteristica caractBuenaSostenibilidad6 = new Caracteristica();
			caractBuenaSostenibilidad6.setTexto(
					"Tecnologías de bajo consumo: Las tecnologías de bajo consumo, como Bluetooth de baja energía (BLE) o Zigbee, pueden ayudar a reducir el consumo de energía de los dispositivos IoT.");
			Caracteristica caractBuenaSostenibilidad7 = new Caracteristica();
			caractBuenaSostenibilidad7.setTexto(
					"Compatibilidad con energías renovables: Los dispositivos IoT que pueden funcionar con energías renovables, como la energía solar o eólica, pueden ayudar a reducir la huella de carbono.");
			Caracteristica caractBuenaSostenibilidad8 = new Caracteristica();
			caractBuenaSostenibilidad8.setTexto(
					"Ciclo de vida prolongado: Los dispositivos IoT que están diseñados para durar más tiempo pueden reducir la cantidad de residuos electrónicos y la necesidad de fabricar nuevos dispositivos con frecuencia.");
			repositoryCaracteristicas.save(caractBuenaSostenibilidad);
			repositoryCaracteristicas.save(caractBuenaSostenibilidad2);
			repositoryCaracteristicas.save(caractBuenaSostenibilidad3);
			repositoryCaracteristicas.save(caractBuenaSostenibilidad4);
			repositoryCaracteristicas.save(caractBuenaSostenibilidad5);
			repositoryCaracteristicas.save(caractBuenaSostenibilidad6);
			repositoryCaracteristicas.save(caractBuenaSostenibilidad7);
			repositoryCaracteristicas.save(caractBuenaSostenibilidad8);

			Caracteristica caractMalaSostenibilidad = new Caracteristica();
			caractMalaSostenibilidad.setTexto(
					"Uso de materiales tóxicos: Los dispositivos IoT que utilizan materiales tóxicos, como mercurio o plomo, pueden causar daños ambientales y de salud.");
			Caracteristica caractMalaSostenibilidad2 = new Caracteristica();
			caractMalaSostenibilidad2.setTexto(
					"Consumo energético elevado: Los dispositivos IoT que consumen mucha energía pueden contribuir a un mayor uso de combustibles fósiles y, por lo tanto, aumentar la huella de carbono.");
			Caracteristica caractMalaSostenibilidad3 = new Caracteristica();
			caractMalaSostenibilidad3.setTexto(
					"Desperdicio de energía: Los dispositivos IoT que no tienen un modo de suspensión o que no pueden apagarse pueden desperdiciar energía innecesariamente.");
			Caracteristica caractMalaSostenibilidad4 = new Caracteristica();
			caractMalaSostenibilidad4.setTexto(
					"Vida útil corta: Los dispositivos IoT que están diseñados para durar poco tiempo pueden aumentar la cantidad de residuos electrónicos.");
			Caracteristica caractMalaSostenibilidad5 = new Caracteristica();
			caractMalaSostenibilidad5.setTexto(
					"Materiales no reciclables: Los dispositivos IoT que utilizan materiales no reciclables pueden contribuir a la acumulación de residuos electrónicos.");
			Caracteristica caractMalaSostenibilidad6 = new Caracteristica();
			caractMalaSostenibilidad6.setTexto(
					"Monitoreo invasivo: Los dispositivos IoT que monitorean la privacidad del usuario o recopilan datos innecesarios pueden ser perjudiciales para la privacidad y la seguridad del usuario.");
			Caracteristica caractMalaSostenibilidad7 = new Caracteristica();
			caractMalaSostenibilidad7.setTexto(
					"Compatibilidad limitada con energías renovables: Los dispositivos IoT que solo pueden funcionar con energías no renovables pueden ser perjudiciales para el medio ambiente.");
			Caracteristica caractMalaSostenibilidad8 = new Caracteristica();
			caractMalaSostenibilidad8.setTexto(
					"Falta de transparencia en la cadena de suministro: La falta de transparencia en la cadena de suministro puede dificultar la evaluación de la sostenibilidad de los dispositivos IoT.");
			repositoryCaracteristicas.save(caractMalaSostenibilidad);
			repositoryCaracteristicas.save(caractMalaSostenibilidad2);
			repositoryCaracteristicas.save(caractMalaSostenibilidad3);
			repositoryCaracteristicas.save(caractMalaSostenibilidad4);
			repositoryCaracteristicas.save(caractMalaSostenibilidad5);
			repositoryCaracteristicas.save(caractMalaSostenibilidad6);
			repositoryCaracteristicas.save(caractMalaSostenibilidad7);
			repositoryCaracteristicas.save(caractMalaSostenibilidad8);

			List<Caracteristica> buenasSeguridad = new LinkedList<Caracteristica>();
			List<Caracteristica> malasSeguridad = new LinkedList<Caracteristica>();
			List<Caracteristica> buenasSostenibilidad = new LinkedList<Caracteristica>();
			List<Caracteristica> malasSostenibilidad = new LinkedList<Caracteristica>();

			buenasSeguridad.add(caractBuenaSeguridad);
			buenasSeguridad.add(caractBuenaSeguridad2);
			buenasSeguridad.add(caractBuenaSeguridad4);
			buenasSeguridad.add(caractBuenaSeguridad6);
			buenasSeguridad.add(caractBuenaSeguridad7);
			malasSeguridad.add(caractMalaSeguridad3);
			malasSeguridad.add(caractMalaSeguridad5);
			malasSeguridad.add(caractMalaSeguridad8);
			malasSeguridad.add(caractMalaSeguridad9);
			malasSeguridad.add(caractMalaSeguridad10);
			buenasSostenibilidad.add(caractBuenaSostenibilidad);
			buenasSostenibilidad.add(caractBuenaSostenibilidad2);
			buenasSostenibilidad.add(caractBuenaSostenibilidad4);
			buenasSostenibilidad.add(caractBuenaSostenibilidad6);
			buenasSostenibilidad.add(caractBuenaSostenibilidad8);
			malasSostenibilidad.add(caractMalaSostenibilidad3);
			malasSostenibilidad.add(caractMalaSostenibilidad5);
			malasSostenibilidad.add(caractMalaSostenibilidad7);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("1",
					"https://drive.google.com/file/d/1Po1Ca_TG_WsFNxzbELwi4V4idS9yoPTF/view?usp=share_link",
					"Amazon Echo", "Amazon",
					"El Echo Dot es un altavoz inteligente que se controla con la voz y que usa el Alexa Voice Service. Gracias a su diseño, es ideal para cualquier habitación. Simplemente pídele música, las noticias o información. También puedes llamar a cualquiera que tenga un dispositivo Echo, la app Alexa o Skype, así como controlar dispositivos de Hogar digital con la voz.",
					Categoria.Asistente_Virtual, "30", 70, "B", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("3",
					"https://drive.google.com/file/d/1AwOYpUUjf25uXBXTywRg617JQbNIHpdB/view?usp=share_link",
					"Google Home", "Google",
					"Google Home es un dispositivo de asistencia digital y altavoz inteligente desarrollado por Google, que forma parte del ecosistema de domótica y tecnología de la compañía. Este dispositivo utiliza el Asistente de Google, un potente sistema de inteligencia artificial (IA), para interactuar con los usuarios mediante comandos de voz y realizar tareas específicas.",
					Categoria.Asistente_Virtual, "70", 75, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("6",
					"https://drive.google.com/file/d/1ymzov4PwhMfuZI9N2DLWBHMZD1j-dAHX/view?usp=share_link",
					"Apple HomePod", "Apple",
					"El HomePod es un altavoz revolucio­nario, capaz de adaptarse al lugar donde lo pongas para ofrecer siempre un sonido de alta fidelidad. Junto con Apple Music y Siri, te trae una nueva forma de descubrir y escuchar música en casa. Además, te ayuda con las tareas cotidianas y te permite controlar la domótica del hogar solo con la voz.",
					Categoria.Asistente_Virtual, "350", 80, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			buenasSeguridad.clear();
			buenasSeguridad.add(caractBuenaSeguridad);
			buenasSeguridad.add(caractBuenaSeguridad2);
			buenasSeguridad.add(caractBuenaSeguridad4);
			buenasSeguridad.add(caractBuenaSeguridad5);
			buenasSeguridad.add(caractBuenaSeguridad7);
			buenasSeguridad.add(caractBuenaSeguridad9);
			malasSeguridad.clear();
			malasSeguridad.add(caractMalaSeguridad3);
			malasSeguridad.add(caractMalaSeguridad6);
			malasSeguridad.add(caractMalaSeguridad8);
			buenasSostenibilidad.clear();
			buenasSostenibilidad.add(caractBuenaSostenibilidad);
			buenasSostenibilidad.add(caractBuenaSostenibilidad2);
			buenasSostenibilidad.add(caractBuenaSostenibilidad4);
			buenasSostenibilidad.add(caractBuenaSostenibilidad6);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("2",
					"https://drive.google.com/file/d/1g2GKy9JGDtnqApoJJa0N4bLpkZXiOMwA/view?usp=share_link",
					"Amazon Echo 4", "Amazon",
					"Un dispositivo redondo. El Echo combina sonido de alta calidad, un controlador de Hogar digital Zigbee integrado y un sensor de temperatura. Los potentes altavoces ofrecen agudos claros, medios dinámicos y graves profundos, lo que genera un sonido intenso y rico en detalles que se adapta a cualquier estancia. Simplemente pídele a Alexa que ponga música, responda a preguntas, haga llamadas, narre las noticias, relate los resultados deportivos, te informe de la previsión del tiempo y más.",
					Categoria.Asistente_Virtual, "70", 80, "C", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			buenasSeguridad.remove(caractBuenaSeguridad9);
			malasSeguridad.add(caractMalaSeguridad9);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("4",
					"https://drive.google.com/file/d/1FPsAEyftK3H3iKWRD7YLld-riLx7D_JJ/view?usp=share_link",
					"Google Nest Mini", "Google",
					"2ª generación de Nest Mini, el altavoz que puedes controlar con tu voz. Solo tienes que decir \"Ok Google\" para reproducir tu música preferida de Spotify, YouTube Music y otras plataformas. La música suena más nítida, con mayor calidad y con más potencia que antes. Pídele ayuda a tu Asistente de Google y pregúntale por el tiempo, las noticias y por casi todo lo que se te ocurra: lo mejor de Google está a tu alcance. Puedes escuchar tu agenda personalizada, información sobre tus desplazamientos habituales y tus recordatorios. También puedes configurar temporizadores y alarmas, e incluso encender las luces.",
					Categoria.Asistente_Virtual, "25", 70, "B", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));
			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("5",
					"https://drive.google.com/file/d/11WW1Lht3brvfr7lfokjyKqip9xxGExOp/view?usp=share_link",
					"Google Nest Hub Max", "Google",
					"Con Asistente de Google, el Google Nest Hub Max ayuda a que tu familia se mantenga en contacto y concentrada en sus tareas. Deja mensajes de video y realiza videollamadas. Monitorea tu casa cuando no estés en ella con la Nest Cam integrada. Comparte recordatorios y tareas pendientes. Cada usuario puede ver su propio calendario, sus viajes diarios y mucho más con solo un vistazo. Además, disfruta de Google Fotos, YouTube TV, videos y música en la pantalla HD de 10\" con bocinas estéreo.",
					Categoria.Asistente_Virtual, "75", 55, "D", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));
			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("7",
					"https://drive.google.com/file/d/1HIs9-rovcwOBRUG711iH7rZRZzQKlf4N/view?usp=share_link",
					"Apple HomePod Mini", "Apple",
					"Si te impresiona la domótica y te gustaría llevar tu casa a otro nivel más tecnológico, no dudes en hacerte con este producto. Consigue un sonido mejorado de alta fidelidad en casa a la vez que recibes ayuda con las tareas cotidianas y controlas la domótica de tu hogar solo con la voz gracias al altavoz inteligente Apple HomePod mini en color gris espacial. Con conectividad Wi-Fi y Bluetooth, no habrá nada que se le resista.",
					Categoria.Asistente_Virtual, "110", 60, "C", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			buenasSeguridad.clear();
			buenasSeguridad.add(caractBuenaSeguridad);
			buenasSeguridad.add(caractBuenaSeguridad2);
			buenasSeguridad.add(caractBuenaSeguridad4);
			buenasSeguridad.add(caractBuenaSeguridad5);
			malasSeguridad.clear();
			malasSeguridad.add(caractMalaSeguridad3);
			malasSeguridad.add(caractMalaSeguridad6);
			malasSeguridad.add(caractMalaSeguridad7);
			malasSeguridad.add(caractMalaSeguridad8);
			malasSeguridad.add(caractMalaSeguridad9);
			malasSeguridad.add(caractMalaSeguridad10);
			buenasSostenibilidad.clear();
			buenasSostenibilidad.add(caractBuenaSostenibilidad2);
			buenasSostenibilidad.add(caractBuenaSostenibilidad4);
			buenasSostenibilidad.add(caractBuenaSostenibilidad5);
			malasSostenibilidad.clear();
			malasSostenibilidad.add(caractMalaSostenibilidad);
			malasSostenibilidad.add(caractMalaSostenibilidad3);
			malasSostenibilidad.add(caractMalaSostenibilidad6);
			malasSostenibilidad.add(caractMalaSostenibilidad7);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("8",
					"https://drive.google.com/file/d/1HoQ-e5ZUYIgSUbZE_xImGOhzjvAXGrAj/view?usp=share_link", "LG WK7",
					"LG",
					"El Altavoz LG WK7 con tecnología Meridian es un gran salto adelante. Una auténtica experiencia de sonido excepcional combinada con la inteligencia artificial para mejorar tu experiencia acústica. Utiliza tu voz para gestionar sin esfuerzo tu día a día con el asistente personal de Google. Controla a través de él otros dispositivos que conecten con el asistente como luces, lavadoras, enchufes inteligentes y mucho más.",
					Categoria.Asistente_Virtual, "150", 40, "F", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			malasSeguridad.remove(caractMalaSeguridad10);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("9",
					"https://drive.google.com/file/d/1f4DANLNVkjzL1SPPj1KGJpVWvQqBewyn/view?usp=share_link",
					"Lenovo Smart Clock", "Lenovo",
					"El Lenovo Smart Clock con el Asistente de Google hace mucho más que decirte la hora y despertarte. Está diseñado para reducir el tiempo que dedicas a consultar la pantalla de tu teléfono por la noche, lo que te ayudará a relajarte y dormir mejor. También puede gestionar los dispositivos inteligentes de tu hogar, reproducir tu música favorita en toda la casa, organizar tu agenda y mucho más. Todo sin usar las manos, rápida y fácilmente. Solo tienes que decir « Ok Google» para empezar.",
					Categoria.Asistente_Virtual, "150", 40, "F", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			buenasSeguridad.clear();
			buenasSeguridad.add(caractBuenaSeguridad);
			buenasSeguridad.add(caractBuenaSeguridad2);
			buenasSeguridad.add(caractBuenaSeguridad4);
			buenasSeguridad.add(caractBuenaSeguridad6);
			buenasSeguridad.add(caractBuenaSeguridad8);
			malasSeguridad.clear();
			malasSeguridad.add(caractMalaSeguridad3);
			malasSeguridad.add(caractMalaSeguridad5);
			malasSeguridad.add(caractMalaSeguridad7);
			malasSeguridad.add(caractMalaSeguridad9);
			malasSeguridad.add(caractMalaSeguridad10);
			buenasSostenibilidad.clear();
			buenasSostenibilidad.add(caractBuenaSostenibilidad);
			buenasSostenibilidad.add(caractBuenaSostenibilidad2);
			buenasSostenibilidad.add(caractBuenaSostenibilidad4);
			buenasSostenibilidad.add(caractBuenaSostenibilidad6);
			buenasSostenibilidad.add(caractBuenaSostenibilidad8);
			malasSostenibilidad.clear();
			malasSostenibilidad.add(caractMalaSostenibilidad3);
			malasSostenibilidad.add(caractMalaSostenibilidad5);
			malasSostenibilidad.add(caractMalaSostenibilidad7);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("10",
					"https://drive.google.com/file/d/1tYlItgzD9-skkn7LZLdQgGmq2naJGhLq/view?usp=share_link",
					"Philips Hue", "Philips",
					"Experimenta la iluminación inteligente con solo presionar un botón con las luces Bluetooth de Philips Hue y crea el ambiente perfecto para tu hogar en muy poco tiempo. Controla la luz en una habitación a través de la aplicación Hue Bluetooth y elige entre 16 millones de colores y varios tonos blancos.",
					Categoria.Iluminacion, "72", 80, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("12",
					"https://drive.google.com/file/d/1Zfprp3kAyomPnjSB2n-YCUNlmxFLScVh/view?usp=share_link",
					"LIFX Color", "LIFX",
					"1100 lúmenes: ¡Ultra brillante! Pero también regulable a través de voz o aplicación.Color completo: 550 mil millones de pasos de color posibles. LED RGBW para colores más ricos y enorme gama blanca de 1500-9000 K.Diseño industrial icónico: la forma única mantiene la distribución de la luz de toda la habitación y se ve genial en colgantes y accesorios expuestos.",
					Categoria.Iluminacion, "40", 75, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			buenasSeguridad.clear();
			buenasSeguridad.add(caractBuenaSeguridad);
			buenasSeguridad.add(caractBuenaSeguridad2);
			buenasSeguridad.add(caractBuenaSeguridad4);
			buenasSeguridad.add(caractBuenaSeguridad5);
			buenasSeguridad.add(caractBuenaSeguridad6);
			buenasSeguridad.add(caractBuenaSeguridad7);
			malasSeguridad.clear();
			malasSeguridad.add(caractMalaSeguridad3);
			malasSeguridad.add(caractMalaSeguridad8);
			malasSeguridad.add(caractMalaSeguridad9);
			buenasSostenibilidad.remove(caractBuenaSostenibilidad8);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("11",
					"https://drive.google.com/file/d/1xAfGg6HV3oWyeJHBfhssuCHXI992wUfG/view?usp=share_link",
					"Philips Hue Starter Kit", "Philips",
					"Añade color ambiental a cualquier habitación con el kit de inicio E27 de Philips Hue White and Color Ambiance. Conecta con el Hue Bridge que se incluye para aprovechar la interminable lista de funcionalidades. Contrólalo mediante la aplicación, la voz o los interruptores incluidos.",
					Categoria.Iluminacion, "150", 85, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("13",
					"https://drive.google.com/file/d/1k1zP-lRFo27gFKjCfNzQSC0LBFT9gPz-/view?usp=share_link",
					"LIFX Mini White", "LIFX",
					"LIFX Mini White es una luz blanca compacta diseñada para ser la luz perfecta de todos los días. Esta luz inteligente básica moderniza la experiencia de iluminación de su hogar mediante su conectividad con la aplicación LIFX. Ya sea encendiendo una sola luz o regulando toda una red, cada una de las luces integra tecnología Wi-Fi para conseguir conexiones uniformes y sin complicaciones con las principales plataformas y dispositivos de casas inteligentes.",
					Categoria.Iluminacion, "27", 70, "C", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			buenasSeguridad.remove(caractBuenaSeguridad7);
			malasSeguridad.clear();
			malasSeguridad.add(caractMalaSeguridad3);
			malasSeguridad.add(caractMalaSeguridad7);
			malasSeguridad.add(caractMalaSeguridad8);
			malasSeguridad.add(caractMalaSeguridad9);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("14",
					"https://drive.google.com/file/d/17hWuqC9inWRo0pAoNJXMTFbQf1VfuMqy/view?usp=share_link",
					"Yeelight Smart LED Bulb", "Yeelight",
					"La bombilla inteligente Yeelight 1S funciona con sus plataformas domésticas inteligentes favoritas como Amazon Alexa, Google Assistant, Apple Homekit. Yeelight 1S con 16 millones de colores y 1700-6500K regulable, establece el ambiente adecuado para cualquier momento ajustando la temperatura del color de blanco cálido a luz diurna.",
					Categoria.Iluminacion, "33", 55, "D", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			buenasSeguridad.clear();
			buenasSeguridad.add(caractBuenaSeguridad);
			buenasSeguridad.add(caractBuenaSeguridad2);
			buenasSeguridad.add(caractBuenaSeguridad4);
			buenasSeguridad.add(caractBuenaSeguridad6);
			buenasSeguridad.add(caractBuenaSeguridad7);
			malasSeguridad.clear();
			malasSeguridad.add(caractMalaSeguridad3);
			malasSeguridad.add(caractMalaSeguridad5);
			malasSeguridad.add(caractMalaSeguridad8);
			malasSeguridad.add(caractMalaSeguridad9);
			malasSeguridad.add(caractMalaSeguridad10);
			buenasSostenibilidad.clear();
			buenasSostenibilidad.add(caractBuenaSostenibilidad);
			buenasSostenibilidad.add(caractBuenaSostenibilidad2);
			buenasSostenibilidad.add(caractBuenaSostenibilidad4);
			buenasSostenibilidad.add(caractBuenaSostenibilidad6);
			buenasSostenibilidad.add(caractBuenaSostenibilidad8);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("15",
					"https://drive.google.com/file/d/1mGPXKTUaz0gbiJS9jVIecNorfYY31TZl/view?usp=share_link",
					"Nest Thermostat", "Google",
					"Todo es sencillo con Nest Thermostat E. Es fácil de usar: no hace falta programar nada. Puedes subir o bajar la temperatura desde cualquier lugar con la aplicación Nest. Ahorrar energía es fácil. Además, se instala fácilmente sin ayuda.",
					Categoria.Climatizacion, "170", 80, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("17",
					"https://drive.google.com/file/d/1_a7sY9_j4QUK4RN9RJTpA79UxgPzOnSS/view?usp=share_link",
					"Ecobbe SmartThermostat", "Ecobee",
					"El nuevo termostato inteligente mejorado de ecobee te ofrece ahorro de energía automático y se adapta a tu estilo de vida ajustando la temperatura según la ocupación, sugiriendo cambios de horario y optimizando tu ahorro de energía. Eco+ viene con características que reducen automáticamente las temperaturas cuando estás fuera o dormido. Funciona con tu dispositivo inteligente o Apple Watch y se conecta a tu sistema de hogar inteligente como Apple HomeKit, Amazon Alexa, Google Assistant, SmartThings e IFTTT.",
					Categoria.Climatizacion, "220", 75, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("18",
					"https://drive.google.com/file/d/1izAdCNwpUBMX-WCO8ewDBwY2OeOo2-Lt/view?usp=share_link",
					"Samsung Family Hub Refrigerator", "Samsung",
					"Transforma tu vida con el nuevo frigorífico inteligente de Samsung. El frigorífico americano Family Hub RS6HA8880S9 te ayudará a hacer la compra y a que no se te caduque los alimentos, podrás escuchar música mientras cocinas o ver tu serie favorita en su pantalla táctil, tener el horario de toda la familia a mano y dejarles mensajes.",
					Categoria.Electrodomesticos_Inteligentes, "1500", 75, "A", buenasSeguridad, malasSeguridad,
					buenasSostenibilidad, malasSostenibilidad)));

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("19",
					"https://drive.google.com/file/d/1lGHHmr2SRMk5S9KNzeKGhSi5naPRqISo/view?usp=share_link",
					"LG InstaView ThinQ Range", "LG",
					"Controla tu frigorífico estés donde estés y con sistema de autodiagnóstico. Con LG ThinQ® puedes controlar de forma remota todas las funciones principales del frigorífico. Enciende 'Express Freeze' con solo tocar un botón. Compatible con Asistente de Google. Haz toc toc en su puerta de cristal para ver el interior. Conserva los alimentos frescos durante más tiempo. LINEARCooling reduce las fluctuaciones de temperatura, conservando tus alimentos frescos pasados 7 días.",
					Categoria.Electrodomesticos_Inteligentes, "2000", 70, "B", buenasSeguridad, malasSeguridad,
					buenasSostenibilidad, malasSostenibilidad)));

			buenasSeguridad.clear();
			buenasSeguridad.add(caractBuenaSeguridad);
			buenasSeguridad.add(caractBuenaSeguridad2);
			buenasSeguridad.add(caractBuenaSeguridad4);
			buenasSeguridad.add(caractBuenaSeguridad5);
			buenasSeguridad.add(caractBuenaSeguridad6);
			buenasSeguridad.add(caractBuenaSeguridad7);
			malasSeguridad.clear();
			malasSeguridad.add(caractMalaSeguridad3);
			malasSeguridad.add(caractMalaSeguridad8);
			malasSeguridad.add(caractMalaSeguridad9);
			buenasSostenibilidad.clear();
			buenasSostenibilidad.add(caractBuenaSostenibilidad);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("16",
					"https://drive.google.com/file/d/1QNxX0mmK-Ev8HruheRk99EZYBy3NLuvQ/view?usp=share_link",
					"Nest Learning Thermostat", "Google",
					"Se programa solo. Ahorra energía. Descubre el Nest Learning Thermostat de 3.ª generación. Tiene aros nuevos y una pantalla grande y nítida. Y puede controlar el agua caliente. El termostato Nest se adapta automáticamente a los cambios de tu vida. Solo tienes que usarlo durante una semana y se programará automáticamente.",
					Categoria.Climatizacion, "230", 90, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			buenasSeguridad.clear();
			buenasSeguridad.add(caractBuenaSeguridad);
			buenasSeguridad.add(caractBuenaSeguridad2);
			buenasSeguridad.add(caractBuenaSeguridad4);
			buenasSeguridad.add(caractBuenaSeguridad6);
			buenasSeguridad.add(caractBuenaSeguridad8);
			malasSeguridad.clear();
			malasSeguridad.add(caractMalaSeguridad3);
			malasSeguridad.add(caractMalaSeguridad5);
			malasSeguridad.add(caractMalaSeguridad7);
			malasSeguridad.add(caractMalaSeguridad9);
			malasSeguridad.add(caractMalaSeguridad10);
			buenasSostenibilidad.clear();
			buenasSostenibilidad.add(caractBuenaSostenibilidad);

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("20",
					"https://drive.google.com/file/d/1bP7XD8mkb-nqCHKKc5PHVpF_iNDIr4Ly/view?usp=share_link",
					"iRobot Roomba i7+", "iRobot",
					"Roomba® i7+ ofrece una aspiración de alta potencia 10 veces superior y una inteligencia única que le permite aprende de tu hogar y tus rutinas de limpieza para proporcionarte el máximo control. Incluso podrás iniciar la limpieza con una simple orden a tu asistente de voz. Además, tu robot vacía automáticamente su depósito para que te olvides de la suciedad o el polvo durante meses.",
					Categoria.Limpieza, "600", 85, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

			log.info("Preloading " + repositoryDispositivos.save(new Dispositivo("21",
					"https://drive.google.com/file/d/1ToVmszzi_bAKvWj8V1EjDRIQxGmldDHI/view?usp=share_link",
					"Neato Botvac D7", "Neato",
					"El aspirador Neato Botvac D7 ha sido diseñado para eliminar el polvo, el pelo, el pelo de mascotas y los agentes alérgenos de tu suelo. Para ello, cuenta con la tecnología LaserSmart que mapea y memoriza tu hogar. De esta manera, navega por el suelo sin problemas y es 2 veces más rápido, incluso en la oscuridad. Este robot aspirador Neato también dispone de la tecnología CornerClever y una forma en D que lo hacen más potente para aspirar. Con su autonomía de 120 minutos, el aspirador D703 puede limpiar superficies muy grandes. Es capaz de darle la vuelta solo a su base si necesita ser recargado, antes de volver a colocarlo donde se dejó parado.",
					Categoria.Limpieza, "450", 85, "A", buenasSeguridad, malasSeguridad, buenasSostenibilidad,
					malasSostenibilidad)));

		};
	}
}