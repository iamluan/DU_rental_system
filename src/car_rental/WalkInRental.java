package car_rental;

import java.time.LocalDateTime;

import enum_type.Status;

public class WalkInRental extends Rental {
	public Payment payment;
	
	public WalkInRental(String renNr, Customer cus, LocalDateTime expecRetuDateTime, 
			double fullCost, String notes, Car car, Branch pickup, Branch expectedReturn, 
			Branch actualReturnBranch, Status status, double startMileage, 
			double endMileage, LocalDateTime actualReturnDateTime) {
		super(renNr, cus, expecRetuDateTime, fullCost, notes, car, 
				pickup, expectedReturn, actualReturnBranch, status,
				startMileage, endMileage, actualReturnDateTime);
	}
	public void setPayment( Payment payment) {
		this.payment = payment;
	}
}
