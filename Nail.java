package FastenerHierarchy;

import java.io.Serializable;

public class Nail extends Fastener implements Serializable{

	private static final long serialVersionUID = 1L;

	private String size; 
	private double length; 
	private double gauge;
	
	public Nail(String size, double length, double gauge, String finish, double price, int numUnit) throws IllegalFastener {
		super("Steel", finish, price, numUnit); 
		if ((finish.equalsIgnoreCase("Black Phosphate"))||(finish.equalsIgnoreCase("ACQ 1000 Hour"))||(finish.equalsIgnoreCase("Lubricated")))
			throw new IllegalFastener("Not an Option");
		setSize(size);
		setLength(length); 
		setGauge(gauge);
	}
	
	public void setSize(String size) throws IllegalFastener {
		if (size == null)
			throw new IllegalFastener("Not a String.");
		if ((size.equals("6D"))&&(size.equals("8D"))&&(size.equals("10D"))
				&&(size.equals("10D"))&&(size.equals("16D"))&&(size.equals("60D")))
			throw new IllegalFastener("Not an option.");
	}
	
	public void setLength(double length) throws IllegalFastener {
		
		double [] lengths = {2.0, 2.5, 3.0, 3.25, 3.5, 6.0};
		if(!validDouble(length, lengths))
			throw new IllegalFastener("Not an option");
		else
			this.length = length; 
	}
	
	public void setGauge(double gauge) throws IllegalFastener {
		
		double [] gauges = {2.0, 8.0, 9.0, 10.25, 11.5};
		if(!validDouble(gauge, gauges))
			throw new IllegalFastener("Not an option");
		else
			this.gauge = gauge; 
	}
	
	public String toString() {
		return size + " size, " + String.valueOf(length) + "\" long, " + gauge + " gauge, " + super.toString();
	}

}
