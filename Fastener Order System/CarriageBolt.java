package FastenerHierarchy;

import java.io.Serializable;

public class CarriageBolt extends Bolt implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	public CarriageBolt(double length, String diameter, String material, String finish, double price, int numUnit) throws IllegalFastener{
		super(length, diameter, material, finish, price, numUnit); 
	}

	public String toString() {
		return "Carriage Bolt " + super.toString();
	}
}
