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
	
	@NotEmpty(message="{NotEmpty.vehicledata}")
	private String make;
	
	@NotNull(message="{number.makeyear}")
	private int makeyear;
	
	@NotEmpty(message="{NotEmpty.vehicledata}")	
	private String model;
	
	@NotEmpty(message="{NotEmpty.vehicledata}")	
	private String plateNumber;		
	
	@Min(value=1,message="{number.minvalue}")
	private int numberOfSeats;
	
	@Min(value=1,message="{number.minvalue}")
	private double dailyRate;
	
	@Min(value=0,message="{number.minvalue}")
	private double dailyFine;
	
	private boolean isAvailable;

	
	
	
	public long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getMakeyear() {
		return makeyear;
	}

	public void setMakeyear(int makeyear) {
		this.makeyear = makeyear;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	public double getDailyFine() {
		return dailyFine;
	}

	public void setDailyFine(double dailyFine) {
		this.dailyFine = dailyFine;
	}

	

	
	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", make=" + make + ", makeyear=" + makeyear + ", model=" + model
				+ ", plateNumber=" + plateNumber + ", numberOfSeats=" + numberOfSeats + ", dailyRate=" + dailyRate
				+ ", dailyFine=" + dailyFine + ", isAvailable=" + isAvailable + "]";
	}

	
	

}
