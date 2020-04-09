package hh20swd.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PalveluRepository extends CrudRepository<Palvelu, Long> { 
	List<Palvelu> findByName(String name);
}
