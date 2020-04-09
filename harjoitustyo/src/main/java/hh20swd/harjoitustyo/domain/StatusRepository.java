package hh20swd.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> { 
	List<Status> findByTitle(String status);

}
