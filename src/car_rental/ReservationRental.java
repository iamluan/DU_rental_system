package car_rental;

import java.util.HashSet;

import enum_type.Status;

import java.time.LocalDateTime;
public class ReservationRental extends Rental {
	public LocalDateTime expectedPickUpDateTime;
	public LocalDateTime actualPickUpDateTime;
	public double depositAmount;
	public double costLessDepositAmount;
	public HashSet<Payment> payment;
	
	public ReservationRental(String renNr, Customer cus, LocalDateTime expecRetuDateTime, double fullCost, String notes,
			Car car, Branch pickup, Branch expectedReturn, Branch actualReturnBranch, Status status,
			double startMileage, double endMileage, LocalDateTime actualReturnDateTime,
			LocalDateTime expectedPickUpDateTime,
			LocalDateTime actualPickUpDateTime,
			double depositAmount,
			double costLessDepositAmount) {
		super(renNr, cus, expecRetuDateTime, fullCost, notes, car, pickup, expectedReturn, actualReturnBranch, status,
				startMileage, endMileage, actualReturnDateTime);
		this.expectedPickUpDateTime = expectedPickUpDateTime;
		this.actualPickUpDateTime = actualPickUpDateTime;
		this.depositAmount = depositAmount;
		this.costLessDepositAmount = costLessDepositAmount;
		this.payment = new HashSet<>();
	}
	
}
