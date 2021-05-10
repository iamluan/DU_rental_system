package car_rental;

import enum_type.GearType;

public class Model implements SimpleKey{
	public String modelNr;
	public String description;
	public GearType gearType;
	public double petrolConsumtion;
	public RentalGroup rentalGroup;
	
	public Model( 	String modelNr,
					String description,
					GearType gearType,
					double petrolConsumtion,
					RentalGroup rentalGroup) {
		this.modelNr = modelNr;
		this.description = description;
		this.gearType = gearType;
		this.petrolConsumtion = petrolConsumtion;
		this.rentalGroup = rentalGroup;
	}

	@Override
	public String getKey() {
		return modelNr;
	}
}
