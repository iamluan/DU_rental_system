package car_rental;

import enum_type.Status;

public class Car implements SimpleKey{
	String regNr;
	Model model;
	Branch branch;
	Status status;
	
	public Car( String regNr,
				Model model,
				Branch branch) {
		this.regNr = regNr;
		this.model = model;
		this.branch = branch;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String getKey() {
		return regNr;
	}
}
