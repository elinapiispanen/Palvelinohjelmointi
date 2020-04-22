package hh20swd.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Palvelu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long palveluid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	// @JsonBackReference
	private List<Sarja> sarjat;
	
	public Palvelu() {}
	
	public Palvelu(String name) {
		super();
		this.name = name;
	}

	public Long getPalveluid() {
		return palveluid;
	}

	public void setId(Long palveluid) {
		this.palveluid = palveluid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Sarja> getSarjat() {
		return sarjat;
	}

	public void setSarjat(List<Sarja> sarjat) {
		this.sarjat = sarjat;
	}

	@Override
	public String toString() {
		return "Palvelu [palveluid=" + palveluid + ", name=" + name + "]";
	}
	
}

