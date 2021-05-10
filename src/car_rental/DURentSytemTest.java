package car_rental;

import java.util.List;

import enum_type.GearType;

public class DURentSytemTest {
	public static void main( String[] args) {
		DURentSystem durs = new DURentSystem();
		try {
			int testCount = 1;
			String test;
			// add branch
			test = "add branches";
			durs.addBranch("B1", "0147", "Thu Duc");
			durs.addBranch("B2", "0258", "Binh Tan");
			durs.addBranch("B3", "6548", "Tan Binh");
			System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + durs);
			//make neighbour
			test = "make neighbour";
			durs.makeNeighbor("B1", "B2");
			System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + durs);
			// add rental groups
			test = "add rental groups";
			durs.addRentalGroup("A", "compact", 100);
			durs.addRentalGroup("B", "full zise", 200);
			System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + durs);
			// add car models
			test = "add car models";
			durs.addModel( "M1", "first model", GearType.AUTOMATIC, 4.8, "A");
			durs.addModel( "M2", "second model", GearType.AUTOMATIC, 5.0, "B");
			System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + durs);
			// add cars
			test = "add cars";
			durs.addCar("CAR1", "M1", "B1");
			durs.addCar("CAR2", "M1", "B2");
			durs.addCar("CAR3", "M2", "B1");
			System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + durs);
			// add customers
			test = "add customers";
			durs.addCustomer("CUST1", "Luan", "4321", false, true);
			durs.addCustomer("CUST2", "Conan", "1234", false, false);
			System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + durs);
			// list all cars of "compact" type at B1
			test = "list all cars of \"compact\" type at B1";
			List<Car> b1CarList = durs.getCarList("B1");
			for(Car c : b1CarList) {
				if( c.model.rentalGroup.description == "compact")
					System.out.println(c.regNr);
			}
			System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + durs);
			// list all cars of "compact" at neighbours of B1
			test = "list all cars of \"compact\" at neighbours of B1";
			List<Car> b1NeighborCarList = durs.getNeighborCars("B1");
			for(Car c : b1NeighborCarList) {
				if( c.model.rentalGroup.description == "compact")
					System.out.println(c.regNr);
			}
			System.out.println("\nTEST " + (testCount ++) + ": " + test + "\n" + durs);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
