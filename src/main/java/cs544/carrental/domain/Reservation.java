package cs544.carrental.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private long reservationId;
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date reservationDateTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pickUpDateTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDateTime;

	private int mileageIn;
	private int mileageOut;
	private double dailyRate;
	private double pricePerDay;
	private double finePerDay;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Vehicle vehicle;
	
	@OneToOne
	private Customer customer;

	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public Date getReservationDateTime() {
		return reservationDateTime;
	}

	public void setReservationDateTime(Date reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}

	public Date getPickUpDateTime() {
		return pickUpDateTime;
	}

	public void setPickUpDateTime(Date pickUpDateTime) {
		this.pickUpDateTime = pickUpDateTime;
	}

	public Date getReturnDateTime() {
		return returnDateTime;
	}

	public void setReturnDateTime(Date returnDateTime) {
		this.returnDateTime = returnDateTime;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer= customer;
	}

	public int getMileageIn() {
		return mileageIn;
	}

	public void setMileageIn(int mileageIn) {
		this.mileageIn = mileageIn;
	}

	public int getMileageOut() {
		return mileageOut;
	}

	public void setMileageOut(int mileageOut) {
		this.mileageOut = mileageOut;
	}

	public double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public double getFinePerDay() {
		return finePerDay;
	}

	public void setFinePerDay(double finePerDay) {
		this.finePerDay = finePerDay;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		str += "{Id:" + this.getReservationId() + ",ReservationDateTime:" + this.getReservationDateTime()
				+ ",PickupDateTime:" + this.getPickUpDateTime() + ",ReturnDateTime:" + this.getReturnDateTime()
				+ ",Person:" + this.getCustomer() + ",Vehicle" + this.getVehicle() + "}";
		return str;
	}

}
