package car_rental;

import java.util.HashSet;

public class RentalGroup implements SimpleKey{
	public String code;
	public String description;
	public double dailyRentalRate;
	public HashSet<Model> modelList;
	public RentalGroup( String code, 
						String description,
						double dailyRentalRate) {
		this.code = code;
		this.description = description;
		this.dailyRentalRate = dailyRentalRate;
	}
	public void addNewModel( Model m) {
		modelList.add(m);
	}
	public Model getModel(Model m) {
		for(Model md : modelList) {
			if( m == md)
				return md;
		}
		return null;
	}
	@Override
	public String getKey() {
		return code;
	}
	
}
