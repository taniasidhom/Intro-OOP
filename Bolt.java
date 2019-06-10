package FastenerHierarchy;

import java.io.Serializable;

public class Bolt extends OuterThreaded implements Serializable{

	
	private static final long serialVersionUID = 1L;

	public Bolt(double length, String diameter, String material, String finish, double price, int numUnit) throws IllegalFastener {
		super(length, diameter, material, finish, price, numUnit);
		
		if ((finish.equalsIgnoreCase("Bright"))||(finish.equalsIgnoreCase("Black Phosphate"))||(finish.equalsIgnoreCase("ACQ 1000 Hour"))||(finish.equalsIgnoreCase("Lubricated")))
			throw new IllegalFastener("Not an option.");
	}
	
}
