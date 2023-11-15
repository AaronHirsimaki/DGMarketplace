package hh.sof003.JavaDGMarketplace.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Bag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@NotBlank(message="Name Required")
	private String name;
	
	@NotBlank(message="Manufacturer Required")
	private String manufacturer;
	
	@NotBlank(message="Size Required")
	private String size;
	
	public Bag(String name, String manufacturer, String size) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.size = size;
	}

	public Bag() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Bag [Id=" + Id + ", name=" + name + ", manufacturer=" + manufacturer + ", size=" + size + "]";
	}
	
	
}
