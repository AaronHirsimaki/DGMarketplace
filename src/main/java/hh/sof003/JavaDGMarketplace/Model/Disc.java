package hh.sof003.JavaDGMarketplace.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class Disc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int discId;
	
	@NotBlank(message="Name Required")
	private String name;
	
	
	@Column(name="manufacturer", nullable=false)
	@NotNull(message="Manufacturer Required")
	@NotBlank(message="Manufacturer Required")
	private String manufacturer;
	
	
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message="Disc Type Required")
    @JoinColumn(name = "discType", nullable=false)
	private DiscType discType;
	
   @NotBlank(message="Colour Required") 
	private String colour;
    
   @NotNull(message="Speed Number Required")
	private int speed;
    
   @NotNull(message="Glide Number Required")
	private int glide;
    
   @NotNull(message="Turn Number Required")
	private int turn;
    
   @NotNull(message="Fade Number Required")
	private int fade;

	//To String method for disc
	@Override
	public String toString() {
		return "Disc [discId=" + discId + ", name=" + name + ", manufacturer=" + manufacturer + ", discType=" + discType
				+ ", colour=" + colour + ", speed=" + speed + ", glide=" + glide + ", turn=" + turn + ", fade=" + fade
				+ "]";
	}

	//Empty constructor for disc
	public Disc() {
		super();
	}

	//Constructor for disc
	public Disc(String name, String manufacturer, DiscType discType, String colour, int speed, int glide, int turn,
			int fade) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.discType = discType;
		this.colour = colour;
		this.speed = speed;
		this.glide = glide;
		this.turn = turn;
		this.fade = fade;
	}

	//Gets and sets for disc
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public DiscType getDiscType() {
		return discType;
	}


	public void setDiscType(DiscType discType) {
		this.discType = discType;
	}


	public String getColour() {
		return colour;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getGlide() {
		return glide;
	}


	public void setGlide(int glide) {
		this.glide = glide;
	}


	public int getTurn() {
		return turn;
	}


	public void setTurn(int turn) {
		this.turn = turn;
	}


	public int getFade() {
		return fade;
	}


	public void setFade(int fade) {
		this.fade = fade;
	}


	public void setDiscId(int discId) {
		this.discId = discId;
	}
	
	public int getDiscId() {
		return this.discId;
	}
}