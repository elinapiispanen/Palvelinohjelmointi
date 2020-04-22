package hh20swd.harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh20swd.harjoitustyo.domain.User;
import hh20swd.harjoitustyo.domain.UserRepository;
import hh20swd.harjoitustyo.domain.Palvelu;
import hh20swd.harjoitustyo.domain.PalveluRepository;
import hh20swd.harjoitustyo.domain.Sarja;
import hh20swd.harjoitustyo.domain.SarjaRepository;
import hh20swd.harjoitustyo.domain.Status;
import hh20swd.harjoitustyo.domain.StatusRepository;


@SpringBootApplication
public class HarjoitustyoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	@Bean
	public CommandLineRunner harjoitustyoDemo(SarjaRepository sarjaRepository, 
			PalveluRepository palveluRepository, StatusRepository statusRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("tallennetaan sarjat ja palvelut");
			palveluRepository.save(new Palvelu("Netflix"));
			palveluRepository.save(new Palvelu("HBO"));
			palveluRepository.save(new Palvelu("Yle Areena"));
			
			statusRepository.save(new Status("Aloitettu"));
			statusRepository.save(new Status("Katsottu"));
			statusRepository.save(new Status("Ei aloitettu"));
			
		
			sarjaRepository.save(new Sarja("HIMYM", 9, 2005, 2014, palveluRepository.findByName("Netflix").get(0), statusRepository.findByTitle("Katsottu").get(0)));
			sarjaRepository.save(new Sarja("Modernit miehet", 2, 2019, 2020, palveluRepository.findByName("Yle Areena").get(0), statusRepository.findByTitle("Katsottu").get(0)));
			sarjaRepository.save(new Sarja("Tiger King", 1, 2020, 2020, palveluRepository.findByName("Netflix").get(0), statusRepository.findByTitle("Katsottu").get(0)));
			sarjaRepository.save(new Sarja("Dark", 2, 2017, 2019, palveluRepository.findByName("Netflix").get(0), statusRepository.findByTitle("Aloitettu").get(0)));
			sarjaRepository.save(new Sarja("Chernobyl", 1, 2019, 2019, palveluRepository.findByName("HBO").get(0), statusRepository.findByTitle("Aloitettu").get(0)));
			sarjaRepository.save(new Sarja("Paratiisi", 1, 2019, 2019, palveluRepository.findByName("Yle Areena").get(0), statusRepository.findByTitle("Katsottu").get(0)));

			
			//salasana: password
			userRepository.save(new User("user", "$2a$10$7RtUmxxp1YWC1SGdoYyltudyUhNbDEWuadgaKZAXQwm7bpJrXcSe.", "USER"));
			userRepository.save(new User("admin", "$2a$10$7RtUmxxp1YWC1SGdoYyltudyUhNbDEWuadgaKZAXQwm7bpJrXcSe.", "ADMIN"));
		
			
			log.info("fetch all series");
			for (Sarja sarja : sarjaRepository.findAll()) {
				log.info(sarja.toString());
			}

		};
	}

}
