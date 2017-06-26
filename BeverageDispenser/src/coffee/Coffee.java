package coffee;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Coffee {
	
	private Map<String, Integer> coffeeAndBeans = new HashMap<>();
	private Map<String, Integer> condimentsAndAmount = new HashMap<>();
	
	public Coffee(){
		coffeeAndBeans = cbDeserialization();
		condimentsAndAmount = caDeserialization();
	}

	public Map<String, Integer> getCoffeeAndBeans() {
		return coffeeAndBeans;
	}

	public Map<String, Integer> getCondimentsAndAmount() {
		return condimentsAndAmount;
	}

	public void hashMapSerialization(Map<String, Integer> hashMap) {
		String fileName;
		if (hashMap == coffeeAndBeans) {
			fileName = "coffeeAndBeans";
		}else{
			fileName = "condimentsAndAmount";
		}
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName + ".ser"));
			out.writeObject(hashMap);
			out.flush();
			out.close();
			System.out.println("\nObject Serialization success!");

		} catch (Exception e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}

	public Map<String, Integer> cbDeserialization() {
		Map<String, Integer> coffeeAndBeansTemp = null;
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("coffeeAndBeans.ser"));
			coffeeAndBeansTemp = (Map<String, Integer>) in.readObject(); // cast it as CoffeeAndBeans
			in.close();
			System.out.println("Object Deserialization success!\n");

		} catch (Exception e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}

		return coffeeAndBeansTemp;
	}
	
	public Map<String, Integer> caDeserialization() {
		Map<String, Integer> condimentsAndAmountTemp = null;
		
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("condimentsAndAmount.ser"));
			condimentsAndAmountTemp = (Map<String, Integer>) in.readObject(); // cast it as CoffeeAndBeans
			in.close();
			System.out.println("Object Deserialization success!\n");

		} catch (Exception e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}

		return condimentsAndAmountTemp;
	}
	
	public void resetAllAfterRefill(){
		coffeeAndBeans.put("Verona", 100);				// oz
		coffeeAndBeans.put("Pike Place", 100);			// oz
		coffeeAndBeans.put("Pike Place Decaf", 100);	// oz
		coffeeAndBeans.put("Mix Two", 100);				// oz
		coffeeAndBeans.put("Hot Chocolate", 100);		// oz
		coffeeAndBeans.put("Hot Water", 5000);			// oz

		condimentsAndAmount.put("sugar", 1000);			// teaspoon
		condimentsAndAmount.put("splenda", 1000);		// teaspoon
		condimentsAndAmount.put("cream", 1000);			// teaspoon
		
		hashMapSerialization(coffeeAndBeans);
		hashMapSerialization(condimentsAndAmount);
		
	}
	
	public void printCurrentStock(){
		System.out.println("Display entries in coffeeAndBeans:");
		System.out.println(coffeeAndBeans + "\n");

		System.out.println("Display entries in condimentsAndAmount:");
		System.out.println(condimentsAndAmount + "\n");
	}
	
	public void subtractStock(String key){
		switch (key) {
		case "Verona": coffeeAndBeans.put("Verona", coffeeAndBeans.get("Verona") - 1);
			break;
		case "Pike Place": coffeeAndBeans.put("Pike Place", coffeeAndBeans.get("Pike Place") - 1);
			break;
		case "Pike Place Decaf": coffeeAndBeans.put("Pike Place Decaf", coffeeAndBeans.get("Pike Place Decaf") - 1);
			break;
		case "Mix Two": coffeeAndBeans.put("Mix Two", coffeeAndBeans.get("Mix Two") - 1);
			break;
		case "Hot Chocolate": coffeeAndBeans.put("Hot Chocolate", coffeeAndBeans.get("Hot Chocolate") - 1);
			break;
		case "Hot Water": coffeeAndBeans.put("Hot Water", coffeeAndBeans.get("Hot Water") - 8);
			break;
		case "sugar": condimentsAndAmount.put("sugar", condimentsAndAmount.get("sugar") - 1);
			break;
		case "splenda": condimentsAndAmount.put("splenda", condimentsAndAmount.get("splenda") - 1);
			break;
		case "cream": condimentsAndAmount.put("cream", condimentsAndAmount.get("cream") - 1);
			break;

		}
	}
	
}
