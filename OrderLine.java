/**
 * @author Kenneth Loughery
 *
 */

public class OrderLine {
	private Item orderItem;
	private int orderQuantity;
	
	public OrderLine(Item item, int quantity) {
		this.orderItem = item;
		this.orderQuantity = quantity;
	}
	
	public String orderLine() {
		String st = "\n";
		st+= "Item description:\t\t" + orderItem.getItemName() + "\n";
		st+= "Amount ordered:\t\t\t" + orderQuantity + "\n";
		st+= "Supplier:\t\t\t" + orderItem.getItemSupplier().getSupplierName() + "\n";
		return st;
	}

}
