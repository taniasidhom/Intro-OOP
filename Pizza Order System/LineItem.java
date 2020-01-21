package PizzaOrderSystem;
import java.io.Serializable;

public class LineItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pizza pizza ; 
	private int numPizzas; 
	
	/**main constructor
	 * 
	 * @param numPizzas (integer for number of pizzas)
	 * @param pizza (pointer to pizza object)
	 * @throws IllegalPizza
	 */
	public LineItem (int numPizzas, Pizza pizza) throws IllegalPizza {
		
		this.pizza = pizza; 
		
		this.setNumber(numPizzas);
		
		if(pizza == null) {
			throw new IllegalPizza("Illegal option"); 
		}
		
		
	}
	/**
	 * default constructor for single pizza 
	 * @param pizza
	 * @throws IllegalPizza
	 */
	public LineItem(Pizza pizza) throws IllegalPizza {
		this(1, pizza); 
	}
	/**
	 * accessor for number of pizzas attribute
	 * @return
	 */
	public int getNumber() {
		return this.numPizzas; 
	}
	/**
	 * accessor for Pizza attribute
	 * @return
	 */
	public Pizza getPizza() {
		//Pizza attribute; 
		return this.pizza; 
	}
	
	/**
	 * sets number of pizzas attribute 
	 * @param numPizzas
	 * @throws IllegalPizza
	 */
	public void setNumber(int numPizzas) throws IllegalPizza {
		if(numPizzas < 1 || numPizzas > 100) {
			throw new IllegalPizza("Invalid number of pizzas!");
		}
		this.numPizzas = numPizzas; 
	}
	/**
	 * accessor to return total cost
	 * @return
	 */
	public double getCost() {
		double pizzaCost = pizza.getCost();
		double bulkDiscount = 1.0d; 
		 
		if (numPizzas >= 10 && numPizzas <= 20) {
			bulkDiscount = 0.95d;
		}
		if (numPizzas > 20) {
			bulkDiscount = 0.9d; 
		}
		return (pizzaCost * bulkDiscount) * numPizzas; 
	}
	/** 
	 * returns string line message 
	 */
	public String toString() {
		
		String output = ""; 
		if (numPizzas < 10) {
			output += " " + numPizzas; 
		} else {
			output += numPizzas; 
		}
		output += " " + pizza.toString(); 
		return output; 	
		
	}
	
	/** 
	 * sorts values from least to greatest (cost)
	 * @param line
	 * @return
	 */
	public int compareTo(LineItem item) {
		
		double difference = (this.getCost() - ((LineItem)line).getCost());
		if (difference > 0) return -1;
		else if (difference == 0) return 0; 
		return 1; 
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
