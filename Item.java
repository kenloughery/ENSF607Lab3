/**
 * @author Kenneth Loughery
 *
 */

public class Item {

	private int itemID, itemStockQuantity;
	private String itemName;
	private double itemPrice;
	private boolean isOrdered;
	private Supplier itemSupplier;
	private static final int maximumOrderQuantity = 50;
	private static final int minimumStockQuantity= 40;
	
	public Item(int itemId, String name, int stockQuantity, double price, Supplier supplier) {
		this.itemID = itemId;
		this.itemName = name;
		this.itemSupplier = supplier;
		this.itemPrice = price;
		this.itemStockQuantity = stockQuantity;
		this.isOrdered = false;
	}
	/**
	 * @returns a boolean indicating the success or failure of reducing one item in the item quantity
	 */
	public boolean reduceItem() {
		if(itemStockQuantity > 0) {
			itemStockQuantity = itemStockQuantity -1;
			return true;
		}
		return false;
		
	}
	/**
	 * @returns an order line of an item if its quantity has dropped below the minimum 
	 */
	public OrderLine genOrderLine() {
		if(this.itemStockQuantity < minimumStockQuantity && !isOrdered) {
			OrderLine line = new OrderLine(this, maximumOrderQuantity-this.itemStockQuantity);
			this.isOrdered = true;
			return line;
		}
		return null;
	}

	/**
	 * @return the id
	 */
	public int getItemID() {
		return itemID;
	}

	/**
	 * @return the name
	 */
	public String getItemName() {
		return itemName;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return itemPrice;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}


	/**
	 * @param ordered the ordered to set
	 */
	public void setIsOrdered(boolean isOrdered) {
		this.isOrdered = isOrdered;
	}

	/**
	 * @return the supplier
	 */
	public Supplier getItemSupplier() {
		return itemSupplier;
	}

	/**
	 * @return the itemQuant
	 */
	public int getItemStockQuantity() {
		return itemStockQuantity;
	}

	/**
	 * @param itemQuant the itemQuant to set
	 */
	public void setItemQuant(int itemStockQuantity) {
		this.itemStockQuantity = itemStockQuantity;
	}
	/**
	 * @returns string of the different item characteristics
	 */
	@Override
	public String toString () {	
			String rtn = "\n";
			rtn += itemName;
			rtn += "\nID: " + itemID + "\n";
			rtn += "\nPrice: " + itemPrice + "\n";
			rtn += "\nQuantity left: " + itemStockQuantity + "\n";
			rtn += "\nSupplier name: " + itemSupplier.getSupplierName() + "\n";
			rtn += "\n-------\n";
			return rtn;
	}
}
