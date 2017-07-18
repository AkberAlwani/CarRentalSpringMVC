package cs544.carrental.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private long vehicleId;	
	
	@NotEmpty(message="{NotEmpty.make}")
	private String make;
	
	@NotNull(message="{number.makeyear}")
	private int makeyear;
	
	@NotEmpty(message="{NotEmpty.model}")	
	private String model;
	
	@NotEmpty(message="{NotEmpty.plateNumber}")	
	private String plateNumber;		
	
	@Min(value=1,message="{number.numberOfSeats}")
	private int numberOfSeats;
	
	@Min(value=0,message="{number.dailyPrice}")
	private double dailyPrice;
	
	private boolean isAvailable;

	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getBrand() {
		return make;
	}

	public void setBrand(String brand) {
		this.make = brand;
	}

	public String getType() {
		return model;
	}

	public void setType(String type) {
		this.model = type;
	}

	public int getModel() {
		return makeyear;
	}

	public void setModel(int model) {
		this.makeyear = model;
	}

	public String getVehiclePlateNumber() {
		return plateNumber;
	}

	public void setVehiclePlateNumber(String vehiclePlateNumber) {
		this.plateNumber = vehiclePlateNumber;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public void setDailyPrice(double dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", brand=" + make + ", type=" + model + ", vehiclePlateNumber="
				+ plateNumber + ", model=" + makeyear + ", numberOfSeats=" + numberOfSeats + ", dailyPrice="
				+ dailyPrice + ", isAvailable=" + isAvailable + "]";
	}

}
