package car_rental;

import java.time.LocalDateTime;

import enum_type.Status;

public class Rental implements SimpleKey{
	public String rentalNr;
	public Customer customer;
	public LocalDateTime createDateTime;
	public LocalDateTime expectedReturnDateTime;
	public double fullCost;
	public double actualCost;
	public String notes;
	public Car car;
	public Branch pickupBranch;
	public Branch expectedReturnBranch;
	public Branch actualReturnBranch;
	public Status status;
	public double startMileage;
	public double endMileage;
	public LocalDateTime actualReturnDateTime;
	
	public Rental( 	String renNr,
					Customer cus,
					LocalDateTime expecRetuDateTime,
					double fullCost,
					String notes,
					Car car,
					Branch pickup,
					Branch expectedReturn,
					Branch actualReturnBranch,
					Status status,
					double startMileage,
					double endMileage,
					LocalDateTime actualReturnDateTime) {
		rentalNr = renNr;
		customer = cus;
		createDateTime = LocalDateTime.now();
		expectedReturnDateTime = expecRetuDateTime;
		this.fullCost = fullCost;
		actualCost = getActualCost();
		this.notes = notes;
		this.car = car;
		this.pickupBranch = pickup;
		this.expectedReturnBranch = expectedReturn;
		this.actualReturnBranch = actualReturnBranch;
		this.status = status;
		this.startMileage = startMileage;
		this.endMileage = endMileage;
		this.actualReturnDateTime = actualReturnDateTime;
	}
	public double getActualCost() {
		if(customer.checkDiscountList() == true) {
			return fullCost - fullCost*0.1;
		}
		return fullCost;
	}
	public Branch getActualReturnBranch() {
		return actualReturnBranch;
	}
	public void setActualReturnBranch(Branch actualReturnBranch) {
		this.actualReturnBranch = actualReturnBranch;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getEndMileage() {
		return endMileage;
	}
	public void setEndMileage(double endMileage) {
		this.endMileage = endMileage;
	}
	public LocalDateTime getActualReturnDateTime() {
		return actualReturnDateTime;
	}
	public void setActualReturnDateTime(LocalDateTime actualReturnDateTime) {
		this.actualReturnDateTime = actualReturnDateTime;
	}
	public void setActualCost(double actualCost) {
		this.actualCost = actualCost;
	}
	public Car getCar() {
		return car;
	}
	public String getKey() {
		return rentalNr;
	}
}
