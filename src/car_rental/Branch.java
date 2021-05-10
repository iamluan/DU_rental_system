package car_rental;

import java.util.ArrayList;

public class Branch implements SimpleKey{
	public String branchNr;
	public String phone;
	public String address;
	public ArrayList<Car> carList;
	public ArrayList<Branch> neighborList;
	
	public Branch( 	String branchNr,
					String phone,
					String address) {
		this.branchNr = branchNr;
		this.phone = phone;
		this.address = address;
		this.carList = new ArrayList<>();
		this.neighborList = new ArrayList<>();
	}

	@Override
	public String getKey() {
		return branchNr;
	}
}
