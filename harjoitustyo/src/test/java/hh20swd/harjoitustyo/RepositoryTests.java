package hh20swd.harjoitustyo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import hh20swd.harjoitustyo.domain.Palvelu;
import hh20swd.harjoitustyo.domain.PalveluRepository;
import hh20swd.harjoitustyo.domain.Sarja;
import hh20swd.harjoitustyo.domain.SarjaRepository;
import hh20swd.harjoitustyo.domain.Status;
import hh20swd.harjoitustyo.domain.StatusRepository;
import hh20swd.harjoitustyo.domain.UserRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTests {

	@Autowired
	  private TestEntityManager entityManager;
	
	@Autowired 
	private SarjaRepository sarjaRepository;
	@Autowired 
	private PalveluRepository palveluRepository;
	@Autowired 
	private StatusRepository statusRepository;
	@Autowired 
	private UserRepository userRepository;
	
	//Sarjarepotestit
	 @Test
	  public void tallennaSarja() {
		 //luodaan sarja
	    Sarja sarja = new Sarja("Testi", 1, 2000, 2010, palveluRepository.findByName("Netflix").get(0), statusRepository.findByTitle("Katsottu").get(0));
	    entityManager.persistAndFlush(sarja);
	    
	    //onko id null
	    assertThat(sarja.getId()).isNotNull();
	  }
	 @Test
	  public void poistaSarjoja() {
	    entityManager.persistAndFlush(new Sarja("Testi", 1, 2000, 2010, palveluRepository.findByName("Netflix").get(0), statusRepository.findByTitle("Katsottu").get(0)));
	    entityManager.persistAndFlush(new Sarja("Testi", 3, 2003, 2013, palveluRepository.findByName("HBO").get(0), statusRepository.findByTitle("Aloitettu").get(0)));
	    
	    //poistetaan luodut sarjat
	    sarjaRepository.deleteAll();
	    //onko tyhjä
	    assertThat(sarjaRepository.findAll()).isEmpty();
	  } 
	 
	 @Test
	 public void findByTitleReturnSeasons() {
	 List<Sarja> sarjat = sarjaRepository.findByTitle("HIMYM");
	 assertThat(sarjat).hasSize(1);
	 assertThat(sarjat.get(0).getSeasons()).isEqualTo(9);
	 }
	 
	 //palvelurepotestit
	 @Test
	  public void tallennaPalvelu() {
		 //luodaan palvelu
	    Palvelu palvelu = new Palvelu("Testi");
	    entityManager.persistAndFlush(palvelu);
	    
	    //onko id null
	    assertThat(palvelu.getPalveluid()).isNotNull();
	  }
	 /*
	 @Test
	  public void poistaPalveluja() {
	    entityManager.persistAndFlush(new Palvelu("Testipalvelu1"));
	    entityManager.persistAndFlush(new Palvelu("Testipalvelu2"));
	    
	    //poistetaan luodut palvelut
	    palveluRepository.deleteAll();
	    //onko tyhjä
	    assertThat(palveluRepository.findAll()).isEmpty();
	  } 
	
	 */
	 @Test
	 public void findByNameReturnId() {
	 List<Palvelu> palvelut = palveluRepository.findByName("Netflix");
	 assertThat(palvelut).hasSize(1);
	 assertThat(palvelut.get(0).getPalveluid()).isEqualTo(1);
	 }
	 
	 //statusrepotestit
	 @Test
	  public void tallennaStatus() {
		 //luodaan status
	    Status status = new Status("Testistatus");
	    entityManager.persistAndFlush(status);
	    
	    //onko id null
	    assertThat(status.getStatusid()).isNotNull();
	  }
	
	 @Test
	  public void poistaStatuses() {
	    entityManager.persistAndFlush(new Status("Testistatus1"));
	    entityManager.persistAndFlush(new Status("Testistatus2"));
	    
	    //poistetaan luodut statukset
	    statusRepository.deleteAll();
	    //onko tyhjä
	    assertThat(statusRepository.findAll()).isEmpty();
	  } 

	 
	 @Test
	 public void findByStatusReturnId() {
	 List<Status> statuses = statusRepository.findByTitle("Aloitettu");
	 assertThat(statuses).hasSize(1);
	 assertThat(statuses.get(0).getStatusid()).isEqualTo(4);
	 }

}
