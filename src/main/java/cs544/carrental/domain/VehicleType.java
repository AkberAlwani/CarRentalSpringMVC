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
import javax.persistence.OneToOne;


@Entity
public class VehicleType {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;
    
    private String name;
    private String description;
    
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable ( name="VehicleType_Vehicle", joinColumns={@JoinColumn(name="VehicleType_Id")},  
//    inverseJoinColumns={ @JoinColumn(name="Vehicle_Id")} )  
//    Set<Vehicle> vehicles = new HashSet<Vehicle>();
      private Vehicle vehicle;

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


	
// 	public void addProduct(Vehicle vehicle) {
//		this.vehicles.add(vehicle);
////		product.getCategories().add(this);
//	}

}
