package cs544.carrental.domain;

 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;  

@Entity
public class Location { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long Id;
	
	@Column(unique=true)
	@Size(min=4, max=15)
	@NotEmpty(message="Please correct Location")
	private String location;
	
	private String city;
	private String zipcode;
	private String phone;
		
//	@OneToMany(mappedBy = "location",cascade=CascadeType.PERSIST)
//	private Set<Vehicle> vehicles;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//	public Set<Vehicle> getVehicles() {
//		return vehicles;
//	}
//
//	public void setVehicles(Set<Vehicle> vehicles) {
//		this.vehicles = vehicles;
//	}

	@Override
	public String toString() {
		return "Location [Id=" + Id + ", location=" + location + ", city=" + city + ", zipcode=" + zipcode + ", phone="
				+ phone + ",]";
	}
	
	
	

}
