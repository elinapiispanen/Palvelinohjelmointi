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
public class Status {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long statusid;
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
	// @JsonBackReference
	private List<Sarja> sarjat;
	
	public Status() {}
	
	public Status(String title) {
		super();
		this.title = title;
	}

	public Long getStatusid() {
		return statusid;
	}

	public void setStatusid(Long statusid) {
		this.statusid = statusid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Sarja> getSarjat() {
		return sarjat;
	}

	public void setSarjat(List<Sarja> sarjat) {
		this.sarjat = sarjat;
	}

	@Override
	public String toString() {
		return "Status [statusid=" + statusid + ", title=" + title + "]";
	}
	
	
}
