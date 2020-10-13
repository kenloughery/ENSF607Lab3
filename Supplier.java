
import java.util.ArrayList;

/**
 * @author Kenneth Loughery
 *
 */
public class Supplier {
	
	private int supplierID;
	private String supplierName, supplierAddress, supplierContact;
	private ArrayList<Item> itemList;
	
	public Supplier(int supplierID, String supplierName, String supplierAddress, String supplierContact) {
		this.supplierID = supplierID;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.supplierContact = supplierContact;
		this.itemList = new ArrayList<Item> ();
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public int getSupplierID(){
		return supplierID;
	}

	public String getSupplierName(){
		return supplierName;
	}

	public String getSupplierContact(){
		return supplierContact;
	}
	public String getSupplierAddress(){
		return supplierAddress;
	}

}
