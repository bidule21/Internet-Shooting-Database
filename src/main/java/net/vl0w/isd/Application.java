package net.vl0w.isd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

	// @Autowired
	// private ShooterRepository shooterRepository;
	// @Autowired
	// private EventRepository eventRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// // SHOOTERS
	// Shooter wick = new Shooter("Patrick", "Wick");
	// Shooter hansen = new Shooter("Jonas", "Hansen");
	// Shooter harlacher = new Shooter("Renato", "Harlacher");
	// Shooter ebnoether = new Shooter("Stefan", "Ebnöther");
	// Shooter arnold = new Shooter("Christof", "Arnold");
	// Shooter haller = new Shooter("Sonja", "Haller");
	// Shooter niederberger = new Shooter("Dominic", "Niederberger");
	// Shooter salvisberg = new Shooter("Mario", "Salvisberg");
	// Shooter vetsch = new Shooter("Marco", "Vetsch");
	// Shooter steiner = new Shooter("Samuel", "Steiner");
	// Shooter marti = new Shooter("Erich", "Marti");
	// Shooter frey = new Shooter("Andy", "Frey");
	// Shooter schulthess = new Shooter("Renato", "Schulthess");
	// Shooter zellweger = new Shooter("Ernst", "Zellweger");
	// Shooter nyffenegger = new Shooter("Pascal", "Nyffeneger");
	// Shooter marbach = new Shooter("Kari", "Marbach");
	// Shooter berger = new Shooter("Andreas", "Berger");
	// Shooter haag = new Shooter("Stefan", "Haag");
	// Shooter naegeli = new Shooter("Stefan", "Nägeli");
	// Shooter carigiet = new Shooter("Christof", "Carigiet");
	// Shooter naef = new Shooter("Peter", "Näf");
	// Shooter waser = new Shooter("André", "Waser");
	// Shooter wittwer = new Shooter("Beat", "Wittwer");
	//
	// List<Shooter> shooters = Arrays.asList(wick, hansen, harlacher,
	// ebnoether, arnold, haller, niederberger, salvisberg, vetsch,
	// steiner, marti, frey, schulthess, zellweger, nyffenegger,
	// marbach, berger, haag, naegeli, carigiet, naef, waser, wittwer);
	//
	// shooterRepository.save(shooters);
	//
	// // Event
	// Event event = new Event("EASV SM 2013 30m");
	//
	// // Standing: Qualification
	// event.result(wick, "Standing").addSeries(93, 91, 96);
	// event.result(hansen, "Standing").addSeries(96, 92, 92);
	// event.result(harlacher, "Standing").addSeries(88, 92, 92);
	// event.result(ebnoether, "Standing").addSeries(86, 95, 91);
	// event.result(arnold, "Standing").addSeries(92, 90, 90);
	// event.result(haller, "Standing").addSeries(95, 90, 87);
	// event.result(niederberger, "Standing").addSeries(92, 96, 83);
	// event.result(salvisberg, "Standing").addSeries(91, 86, 92);
	// event.result(vetsch, "Standing").addSeries(88, 86, 92);
	// event.result(steiner, "Standing").addSeries(92, 84, 90);
	// event.result(marti, "Standing").addSeries(87, 93, 84);
	// event.result(frey, "Standing").addSeries(88, 86, 87);
	//
	// // Kneeling: Qualification
	// event.result(hansen, "Kneeling").addSeries(96, 99, 98);
	// event.result(harlacher, "Kneeling").addSeries(96, 96, 96);
	// event.result(wick, "Kneeling").addSeries(97, 96, 95);
	// event.result(arnold, "Kneeling").addSeries(98, 95, 95);
	// event.result(schulthess, "Kneeling").addSeries(97, 98, 93);
	// event.result(haller, "Kneeling").addSeries(94, 97, 96);
	// event.result(ebnoether, "Kneeling").addSeries(96, 95, 95);
	// event.result(marti, "Kneeling").addSeries(93, 96, 96);
	// event.result(zellweger, "Kneeling").addSeries(97, 95, 93);
	// event.result(steiner, "Kneeling").addSeries(91, 96, 97);
	// event.result(nyffenegger, "Kneeling").addSeries(96, 94, 94);
	// event.result(marbach, "Kneeling").addSeries(89, 96, 97);
	// event.result(berger, "Kneeling").addSeries(91, 95, 96);
	// event.result(haag, "Kneeling").addSeries(94, 96, 92);
	// event.result(naegeli, "Kneeling").addSeries(92, 92, 97);
	// event.result(carigiet, "Kneeling").addSeries(94, 94, 93);
	// event.result(vetsch, "Kneeling").addSeries(93, 91, 96);
	// event.result(naef, "Kneeling").addSeries(94, 87, 96);
	// event.result(waser, "Kneeling").addSeries(91, 93, 92);
	// event.result(wittwer, "Kneeling").addSeries(90, 90, 94);
	//
	// eventRepository.save(event);
	// }
}
