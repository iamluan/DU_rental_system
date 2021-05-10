package car_rental;

import enum_type.Status;
import java.util.HashSet;
import java.util.List;

import enum_type.GearType;

import java.util.ArrayList;
import java.util.Collection;
import java.lang.Exception;
import java.time.LocalDateTime;

public class DURentSystem {
	public List<RentalGroup> rentalGroupList;
	public HashSet<Model> allModels;
	public List<Branch> allBranches;
	public List<Car> allCars;
	public List<Customer> allCustomers;
	private List<Rental> rentalList;
	
	public DURentSystem() {
		rentalGroupList = new ArrayList<>();
		allModels = new HashSet<>();
		allBranches = new ArrayList<>();
		allCars = new ArrayList<>();
		allCustomers = new ArrayList<>();
		rentalList = new ArrayList<>();
	}
	
	public void makeNeighbor( String bNr1, String bNr2) 
			throws Exception {
		Branch b1 = search( allBranches, bNr1);
		Branch b2 = search( allBranches, bNr2);
		if(b1 != null && b2 != null) {
			b1.neighborList.add(b2);
			b2.neighborList.add(b1);
		} else {
			throw new Exception(
					"One or both of two branches doesn't exist");
		}
	}
	public void addBranch(String branchNr, 
				String phone, 
				String address) throws Exception {
		Branch b = search( allBranches, branchNr);
		if( b != null) {
			throw new Exception("This branch already exists !");
		} else {
			Branch nb = new Branch(branchNr, phone, address);
			allBranches.add(nb);
		}
	}
	public void addRentalGroup( String code, String description, double dailyRentalRate) 
			throws Exception {
		RentalGroup rg = search( rentalGroupList, code);
		if( rg != null) {
			throw new Exception("This group already exists !");
		}
		RentalGroup nrg = new RentalGroup(code, description, dailyRentalRate);
		rentalGroupList.add(nrg);
	}
	public void addModel( String modelNr, 
						String description,
						GearType gearType,
						double petrolConsumtion,
						String groupCode) throws Exception{
		RentalGroup rentalGroup = search( rentalGroupList, groupCode);
		Model m = search( allModels, modelNr);
		if( rentalGroup == null || m != null) {
			throw new Exception("add model error");
		}
		Model nm = new Model(modelNr, description, 
				gearType, petrolConsumtion, rentalGroup);
		allModels.add(nm);
	}
	// ADD A CAR
	public void addCar( String regNr, 
				String modelNr,
				String branchNr) throws Exception{
		Car c = search( allCars, regNr);
		Model m = search( allModels, modelNr);
		Branch b = search( allBranches, branchNr);
		if( c != null) {
			throw new Exception("Add a Car: This car already exists !");
		} else if( m == null) {
			throw new Exception("Add a Car: This model does not exists !");
		} else if( b == null) {
			throw new Exception("Add a Car: This branch does not exists !");
		}
		Car nc = new Car(regNr, search(allModels, modelNr), 
					search( allBranches, branchNr));
		allCars.add(nc);
	}
	// ADD A CUSTOMER
	public void addCustomer(String driverLicenseNr, String name, 
			String phone, boolean inBlackList, boolean inDiscountList)
		throws Exception{
		Customer c = search( allCustomers, driverLicenseNr);
		if( c != null) {
			throw new Exception(
					"Add a Customer: This customer alread exists!");
		}
		Customer nc = new Customer( driverLicenseNr, name, phone,
				inBlackList, inDiscountList);
		allCustomers.add(nc);
	}
	// List cars of a branch
	public void printCarList(String branchNr) throws Exception{
		List<Car> carList = new ArrayList<>();
		carList = (ArrayList<Car>) getCarList( branchNr);
		for( Car c : carList) {
			c.toString();
		}
	}
	// List all cars of neighbour branches of a branch
	public void printNeighborCars(String branchNr) throws Exception{
		Branch b = search( allBranches, branchNr);
		if( b == null) {
			throw new Exception( "This branch does not exist"); 
		}
		for(Branch nb : b.neighborList) {
			printCarList( nb.branchNr);
		}
	}
	public List<Car> getNeighborCars(String branchNr) throws Exception{
		Branch b = search( allBranches, branchNr);
		if( b == null) {
			throw new Exception( "This branch does not exist"); 
		}
		List<Car> neighborCars = new ArrayList<>();
		for(Branch nb : b.neighborList) {
			neighborCars.addAll(nb.carList);
		}
		return neighborCars;
	}
	
	public List<Car> getCarList( String branchNr) 
			throws Exception{
		Branch b = search( allBranches, branchNr);
		if( b == null) {
			throw new Exception( "This branch does not exist"); 
		}
		return b.carList;
	}
	// record a returned car
	public void recordReturnedCar( String rentalNr, double endMileage, 
			String actualReturnBranchNr, LocalDateTime actualReturnDateTime) 
		throws Exception{
		Rental r = search( rentalList, rentalNr);
		Branch b = search( allBranches, actualReturnBranchNr);
		if( r == null || b == null) {
			throw new Exception("record a return branch error");
		}
		else if( r.startMileage > endMileage){
			throw new Exception("record a return branch error:"
					+ "startMileage must less than endMileage");
		}
		r.setEndMileage(endMileage);
		r.setActualReturnBranch(b);
		r.setActualReturnDateTime(actualReturnDateTime);
		r.setStatus(Status.RETURNED);
		Car car = r.getCar();
		car.setStatus( Status.RETURNED);
	}
	// Enter a walk in rental
	public void enterWalkInRental( String rentalNr, 
			String driverLicenseNr,
			LocalDateTime expectedReturnDateTime, 
			double fullCost,
			String notes,
			String carRegNr,
			String pickUpBranchNr,
			String expectedReturnBranchNr,
			String actualReturnBranchNr,
			Status status,
			double startMileage,
			double endMileage,
			LocalDateTime actualReturnDateTime) 
				throws Exception{
		Rental r = search( rentalList, rentalNr);
		Customer cus = search( allCustomers, driverLicenseNr);
		Car car = search( allCars, carRegNr);
		Branch pkb = search( allBranches, pickUpBranchNr);
		Branch erb = search( allBranches, expectedReturnBranchNr);
		Branch arb = search( allBranches, actualReturnBranchNr);
		if( r != null || cus == null || car == null ||
				pkb == null || erb == null || arb == null) {
			throw new Exception("Input walk in rental error");
		}
		if(cus.inBlackList == true) {
			System.out.println("Walk in rental: this customer is in blacklist");			
		}
		WalkInRental wr = new WalkInRental( rentalNr,
				cus, expectedReturnDateTime, fullCost, notes, car, pkb, erb, arb, status, 
				startMileage, endMileage, actualReturnDateTime);
		rentalList.add( wr);
	}
	// search an object
	public static <E extends SimpleKey> 
		E search( Collection<E> collection, String key) {
			for( E e : collection) {
				if( e.getKey().equals(key)) {
					return e;
				}
			}
			return null;
		}
}
