package FastenerHierarchy;

import java.io.Serializable;

public class OuterThreaded extends Threaded implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private double length; 
	
	public OuterThreaded(double length, String diameter, String material, String finish, double price, int numUnit)
			throws IllegalFastener {
		super(diameter, material, finish, price, numUnit);
		setLength(length); 
	}
	
	public void setLength(double length) throws IllegalFastener{
		boolean fastenerLength = false;
		for(double i = 0.5; i <= 6; i+=0.25) {
			if(i == length)
				fastenerLength = true;
		}
		for(double i = 6; i <= 11; i+=0.5) {
			if(i == length)
				fastenerLength = true;
		}
		for(double i = 11; i <= 20; i++) {
			if(i == length)
				fastenerLength = true;
		}
		if(!fastenerLength)
			throw new IllegalFastener("Illegal length");
		else
			this.length = length; 
	}
	
	public String toString() { 
		return String.valueOf(length) + "\" long" + super.toString(); 
	}

}
