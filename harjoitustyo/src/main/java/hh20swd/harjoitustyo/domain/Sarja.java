package hh20swd.harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Sarja {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		private String title;
		private int seasons;
		private int yearstart;
		private int yearend;
		
		@ManyToOne
		@JsonManagedReference
	    @JoinColumn(name = "palveluid")
		private Palvelu palvelu;
		
		@ManyToOne
		@JsonManagedReference
	    @JoinColumn(name = "statusid")
		private Status status;
	
		public Sarja(Long id, String title, int seasons, int yearstart, int yearend) {
			super();
			this.id = id;
			this.title = title;
			this.seasons = seasons;
			this.yearstart = yearstart;
			this.yearend = yearend;
		
		}
		
		public Sarja() {
			super();
		}
		public Sarja(String title, int seasons, int yearstart, int yearend, Palvelu palvelu, Status status) {
			super();
			this.title = title;
			this.seasons = seasons;
			this.yearstart = yearstart;
			this.yearend = yearend;
			this.palvelu = palvelu;
			this.status = status;
		}
		public int getSeasons() {
			return seasons;
		}

		public void setSeasons(int seasons) {
			this.seasons = seasons;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getYearstart() {
			return yearstart;
		}
		public void setYearstart(int yearstart) {
			this.yearstart = yearstart;
		}
		public int getYearend() {
			return yearend;
		}
		public void setYearend(int yearend) {
			this.yearend = yearend;
		}
		
		public Palvelu getPalvelu() {
			return palvelu;
		}
		public void setPalvelu(Palvelu palvelu) {
			this.palvelu = palvelu;
		}
		
		
		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		@Override
		public String toString() {
			
			if (this.palvelu != null && this.status !=null)
				return "Sarja [id=" + id + ", title=" + title + ", seasons=" + seasons + ", yearstart=" + yearstart + ", yearend=" + yearend
						+ ", palvelu=" + this.getPalvelu() + ", status= " + this.getStatus() + "]"; 
				else
			return "Sarja [id=" + id + ", title=" + title + ", seasons=" + seasons + ", yearstart=" + yearstart + ", yearend=" + yearend
					+ "]";
		}
		
		
}
