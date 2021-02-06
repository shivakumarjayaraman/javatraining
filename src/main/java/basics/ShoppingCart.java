package basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Example illustrates nested classes (static inner classes)
 * 
 * @author shivjaya
 *
 */
public class ShoppingCart {
	public static class Item {
		String name;
		int quantity;
		double unitPrice;
		
		public Item(String name, int quantity, double unitPrice) {
			this.name = name;
			this.quantity = quantity;
			this.unitPrice = unitPrice;
		}
	}
	
	private List<Item> myItems = new ArrayList<Item>();
	
	public static void main(String [] args) {
		ShoppingCart c = new ShoppingCart();
		c.myItems.add(new Item("Shoe", 3, 45.20));
		
		ShoppingCart.Item i = new ShoppingCart.Item("Pen", 2, 1.20);
	}
}
