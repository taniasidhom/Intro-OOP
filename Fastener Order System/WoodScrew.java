package FastenerHierarchy;

import java.io.Serializable;

public class WoodScrew extends Screw implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String point; 
	
	public WoodScrew(double length, String diameter, String material, String finish, String head, String drive, String point, double price, int numUnit) throws IllegalFastener {
		super(length, diameter, material, finish, head, drive, price, numUnit); 
		setPoint(point); 
	}
	
	public void setPoint(String point) throws IllegalFastener {
		if (point == null)
			throw new IllegalFastener("Not a String.");
		if ((point != "Double Cut")&&(point != "Sharp")&&(point != "Type 17"))
			throw new IllegalFastener("Not an Option."); 
	}
	
	public String toString() {
		return "Wood Screw, " + point + " point, " + super.toString();
	}

}
