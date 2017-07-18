package cs544.carrental.domain;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class VehicleType {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
    
    String name;
    String description;
    
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable ( name="VehicleType_Vehicle", joinColumns={@JoinColumn(name="VehicleType_Id")},  
    inverseJoinColumns={ @JoinColumn(name="Vehicle_Id")} )  
    Set<Vehicle> vehicles = new HashSet<Vehicle>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setProducts(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

 	public void addProduct(Vehicle vehicle) {
		this.vehicles.add(vehicle);
//		product.getCategories().add(this);
	}

}
