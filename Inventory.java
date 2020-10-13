
import java.util.ArrayList;

/**
 * @author Kenneth Loughery
 *
 */
public class Inventory {

	private ArrayList <Item> itemList;
	private Order order;
	
	public Inventory( ArrayList <Item> items) {
		itemList = items;
		order = new Order();
	}
	



	/**
	 * Searches for an item by the items name
	 * @return null if not found, item if it exists
	 */
	public Item searchForItem(String itemName) {
		for(Item iterateItem : itemList) {
			if(iterateItem.getItemName().equals(itemName)){ return iterateItem; }
		}
		return null;
	}
	
	/**
	 * Searches for an item by the id number
	 * @return null if not found, item if it exists
	 */
	public Item searchForItem(int id) {
		for(Item iterateItem : itemList) {
			if(iterateItem.getItemID() == (id)){ return iterateItem;}
		}
		return null;
	}
	
	/**
	 * adds a new line to an order, if the item needs ordering as set by the minimum item quantity in genOrderLine()
	 */
	public void placeOrder(Item item) {
		OrderLine newOrderLine = item.genOrderLine();
		if( newOrderLine != null) { order.addOrderLine(newOrderLine);}
	}
	
	/**
	 *  Reduces an item found by the items name
	 * @return null if the item is not found, returns item if the item is found
	 */
	public boolean reduceItem(String itemName) {
		Item item  = searchForItem(itemName);
		if(item != null && item.reduceItem() == true) {
			placeOrder(item);
			return true;
		}
		return false;
	}
	/**
	 * @return text for printing out all the items in the inventory
	 */
	@Override
	public String toString() {
		String rtn = "\n";
		rtn += "\nAll items in inventory:\n";
		for(Item iterateItem : itemList) {
			rtn += iterateItem.toString();
		}
		return rtn;
	}
	
	/**
	 * Scans all items to check their quantity and return their ordered status to false
	 * @return text for a generated order
	 */
	public String generateOrder() {
		for(Item iterateItem : itemList) {
			placeOrder(iterateItem);
			iterateItem.setIsOrdered(false);
		}
		return order.generateOrder();
	}



}
