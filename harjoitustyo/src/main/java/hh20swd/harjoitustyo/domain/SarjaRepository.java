package hh20swd.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface SarjaRepository extends CrudRepository<Sarja, Long> { 
	List<Sarja> findByTitle(String title);
}
