
/**
* @author Kenneth Loughery
*
*/
public class Shop {

	private Inventory theInventory;
	private SupplierList suppliers;

	

	public Shop(Inventory theInventory, SupplierList suppliers) {
		this.theInventory = theInventory;
		this.suppliers = suppliers;
	}

	/**
	 *	@returns a string containing all the generated aspects of an order, from a user inputted date
	 */
	public String generateOrder() {
		return theInventory.generateOrder();
	}

	
	
	/**
	 *	@returns a string indicating the success or failure of an item reduction
	 */
	public String reduceItem(String itemName) {
		if(theInventory.reduceItem(itemName)) {		
			return "Success! Reduced the number of items."; }
		return "Unable to reduce the number of items.";	
	}

	/**
	 *	@returns a string of the item characteristics that have been searched for by its name
	 */
	public String getItem(String itemName) {
		Item foundItem = theInventory.searchForItem(itemName);
		if(foundItem == null)
			return "\nItem not found. \n";
		return foundItem.toString();
	}
	
	/**
	 *	@returns a string of the item characteristics that have been searched for by its id number
	 */
	public String getItem(int id) {
		Item foundItem = theInventory.searchForItem(id);
		if(foundItem == null)
			return "\nItem not found. \n";
		return foundItem.toString();
	}
	
	/**
	 *	@returns a string of the quantity of items left in inventory
	 */
	public String getQuantity(String itName) {
		Item foundItem = theInventory.searchForItem(itName);
		if(foundItem == null)
			return "\nItem not found. \n";
		return "\nItem Quantity: " + foundItem.getItemStockQuantity() + "\n";
	}
	
	
	/**
	 *	prints out the full inventory
	 */
	public String printoutOfInventory() {
		return theInventory.toString();
	}
	

	
	
}
