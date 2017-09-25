import java.util.ArrayList;

public class ShoppingCart implements Cart {
	
	ArrayList<SelectedItem> itemList = new ArrayList<SelectedItem>();
	private double total;
	
	public ShoppingCart() {
		
	}
	
	public void addItem(SelectedItem newItem) {
		itemList.add(newItem);		
		for(SelectedItem itemListArray : itemList) {
			if (itemListArray.getItemNumber() == newItem.getItemNumber()) {
				itemListArray.setQuantity(itemListArray.getQuantity());
			}
		}
		
	}

	
	public void deleteItem(int deleteItemNumber) {
		for(SelectedItem itemListArray : itemList) {
			if (itemListArray.getItemNumber() == deleteItemNumber) {
				itemListArray.setQuantity(0);
			}
		}
	}

	public double getTotal() {
		for(SelectedItem itemListArray : itemList) {
			total = itemListArray.getQuantity() * itemListArray.getUnitPrice() + total;
		}
		return total;
	}

	public double getTax() {
		return total * 0.045;
	}

	public double getShipping() {
		if (total <= 10) {
			return 2.50;
		} else {
			return total * 0.15;
		}
	}
	
	public double grandTotal() {
		double total = 0;
		total = this.total + this.getShipping() + this.getTax();
		return total;
	}
	
	public String toString() {
		for(SelectedItem itemListArray : itemList) {
			if (itemListArray.getQuantity() != 0) {
				System.out.print("Item: " + itemListArray.getDescription() + "\n" 
					+ "Quantity: " + itemListArray.getQuantity() + "\n" 
					+ "Unit Price: $" + itemListArray.getUnitPrice() + "\n" 
					+ "Total Price: $" + (itemListArray.getQuantity() * itemListArray.getUnitPrice()) + "\n" + "\n");
			}
			
		}
		return "Total: $" + this.getTotal() + "\n" + "Tax: $" + this.getTax() + "\n" 
				+ "Shipping: $" + this.getShipping() + "\n"
				+ "GRAND TOTAL: $" + this.grandTotal();
	}

}
