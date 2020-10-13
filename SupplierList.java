

import java.util.ArrayList;
/**
 * @author Kenneth Loughery
 *
 */
public class SupplierList {
	private ArrayList<Supplier> suppliers;
	
	public SupplierList(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	/**
	 * Searches for a supplier by the supplier id
	 * @return supplier found
	 */
	public Supplier findSupplier(int id) {
		for(Supplier mySupplier : suppliers) {
			if(mySupplier.getSupplierID() == id) {
				return mySupplier;
			}
		}
		return null;
	}

	/**
	 * @return the suppliers
	 */
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}

}
