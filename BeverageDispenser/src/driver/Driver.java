package driver;

import java.util.HashMap;
import java.util.Map;

import coffee.Coffee;
import gui.UI;

public class Driver {

	public static void main(String[] args) {
		UI ui = new UI();
		//Coffee coff = new Coffee();
		//coff.printCurrentStock();
		
		//coff.resetAllAfterRefill();
		//testDeserializtion(coff);
	}
	
	public static void testDeserializtion(Coffee coff){
		Map<String, Integer> coffeeAndBeans = new HashMap<>();
		Map<String, Integer> condimentsAndAmount = new HashMap<>();
		
		coffeeAndBeans = coff.cbDeserialization();
		condimentsAndAmount = coff.caDeserialization();
		
		System.out.println("Display entries in coffeeAndBeans");
		System.out.println(coffeeAndBeans + "\n");
		
		System.out.println("Display entries in condimentsAndAmount");
		System.out.println(condimentsAndAmount + "\n");
	}

}
