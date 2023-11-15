package hh.sof003.JavaDGMarketplace.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class DiscType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int discId;
	private String discType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "discType")
	private List<Disc> discs;

	public int getDiscId() {
		return discId;
	}

	public void setDiscId(int id) {
		this.discId = id;
	}

	public String getDiscType() {
		return discType;
	}

	public void setDiscType(String type) {
		this.discType = type;
	}

	public List<Disc> getDiscs() {
		return discs;
	}

	public void setDiscs(List<Disc> discs) {
		this.discs = discs;
	}

	@Override
	public String toString() {
		return "DiscType [id=" + discId + ", type=" + discType + ", discs=" + "]";
	}

	public DiscType(String type, List<Disc> discs) {
		super();
		this.discType = type;
		this.discs = discs;
	}

	public DiscType() {
		super();
	}
	
	

}
