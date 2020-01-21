/**
 * Tania Sidhom
 * Ned ID: 16ttas
 * Student number: 20061390 
 */

package PizzaOrderSystem; 
import java.io.Serializable;


public class Pizza implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public enum Size{SMALL, MEDIUM, LARGE};
public enum Cheese{SINGLE, DOUBLE, TRIPLE};
public enum Topping{NONE, SINGLE};

public Size size; 
public Cheese cheese;
public Topping pineapple; 
public Topping greenPepper; 
public Topping ham; 

	
	/**
	 * main constructor with attribute restrictions 
	 * @param size
	 * @param cheese
	 * @param ham
	 * @param pineapple
	 * @param greenPepper
	 * @throws IllegalPizza
	 */
	public Pizza(Size size, Cheese cheese, Topping ham, Topping pineapple, Topping greenPepper) throws IllegalPizza{
		
		if(size == null) {
			throw new IllegalPizza("Illegal input");
		}
		this.size = size; 
		
		if(cheese == null) {
			throw new IllegalPizza("Illegal input");
		}
		this.cheese = cheese; 
		
		if(ham == null) {
			throw new IllegalPizza("Illegal input");
		}
		this.ham = ham; 
		
		if(pineapple == null) {
			throw new IllegalPizza("Illegal input");
		}
		while (ham == Topping.SINGLE && pineapple == Topping.NONE) {
			throw new IllegalPizza("Cannot have pineapple without ham!");
		}
		this.pineapple = pineapple; 
		
		if(greenPepper == null) {
			throw new IllegalPizza("Illegal input");
		}
		while (ham == Topping.NONE && greenPepper == Topping.SINGLE) {
			throw new IllegalPizza("Cannot have green pepper without ham!");
		}
		this.greenPepper = greenPepper; 
		
		
		
	}
	
	/**
	 * default constructor for small pizza with single cheese and ham 
	 * @throws IllegalPizza
	 */
	public Pizza() throws IllegalPizza{
		size = Size.SMALL;
		cheese = Cheese.SINGLE; 
		ham = Topping.SINGLE; 
		pineapple = Topping.NONE; 
		greenPepper = Topping.NONE; 
	}
		
		
	/**
	 * attribute to return cost of pizza
	 * @return double value 
	 */
	public double getCost() {
		double cost = 0.00; 
		if (size == Size.SMALL) {
			cost = 7.00d; 
		}
		if (size == Size.MEDIUM) {
			cost = 9.00d; 
		}
		if (size == Size.LARGE) {
			cost = 11.00d; 
		}
		if (cheese == Cheese.DOUBLE) {
			cost += 1.50d; 
		}
		if (cheese == Cheese.TRIPLE) {
			cost += 3.00d; 
		}
		if (ham == Topping.SINGLE) {
			cost += 1.50d; 
		}
		if (pineapple == Topping.SINGLE) {
			cost += 1.50d; 
		}
		if (greenPepper == Topping.SINGLE) {
			cost += 1.50d; 
		}return cost; 
	}
		
	/**
	 * attribute to return string message of pizza 
	 */
	public String toString() { 
		String output = "";
		output = size + " pizza, " + cheese + " cheese";
		
		
		if (pineapple == Topping.SINGLE) {
			output += ", pineapple";
		}
		if (greenPepper == Topping.SINGLE) {
			output += ", green pepper"; 
		}
		if (ham == Topping.SINGLE) {
			output += ", ham";
		}
		return output += ". Cost:" + " $" + getCost() + "0" + " each.";
	}
		
	/**
	 * equals method 
	 */
	public boolean equals(Object otherP) {
		if (!(otherP instanceof Pizza)) {
			return false; 
		}
		if(this.cheese != cheese) 
			return false; 
		if(this.size != size) 
			return false; 
		if (this.ham != ham) 
			return false;
		if (this.pineapple != pineapple) 
			return false;
		if (this.greenPepper != greenPepper) 
			return false; 
		return true; 
		

	}
	/**
	 * clone method 
	 */
	public Pizza clone() { 	
		Pizza otherPizza = null;
		try {
			otherPizza = new Pizza(size, cheese, ham, pineapple, greenPepper);
		} catch (IllegalPizza e) {
			return null; 
		}
		return otherPizza;
	}


	public static void main(String[] args) {


	}

}
