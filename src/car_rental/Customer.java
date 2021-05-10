package car_rental;

public class Customer implements SimpleKey{
	String driverLicenseNr;
	String name;
	String phone;
	boolean inBlackList;
	boolean inDiscountList;
	
	public Customer (	String driLiNr,
						String name,
						String phone,
						boolean inBlackList,
						boolean inDiscountList) {
	
		driverLicenseNr = driLiNr;
		this.name = name;
		this.phone = phone;
		this.inBlackList = inBlackList;
		this.inDiscountList = inDiscountList;
	}
	
	boolean checkBlackList() {return inBlackList;}
	boolean checkDiscountList() {return inDiscountList;}

	@Override
	public String getKey() {
		return driverLicenseNr;
	}
}
