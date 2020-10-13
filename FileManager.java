

import java.io.*;
import java.util.ArrayList;
/**
 * @author Ken
 *
 */

public class FileManager {
	
	private ArrayList<Supplier> suppliers;
	private ArrayList<Item> items;
	private static final String ItemLocation = "items.txt";
	private static final String SupplierLocation = "suppliers.txt";



	public FileManager() throws Exception{
		suppliers =  new ArrayList<Supplier>();
		readSuppliers();
		System.out.println("Success!");
		items = new ArrayList<Item>();
		readItems();
	}



	public void readSuppliers() throws Exception{

		BufferedReader myBufferedReader = new BufferedReader(new FileReader(SupplierLocation));
		
		String readLine = "";
		while((readLine = myBufferedReader.readLine()) != null) {
			String[] inputArray = readLine.split(";");
			suppliers.add(new Supplier(Integer.parseInt(inputArray[0]),inputArray[1],inputArray[2],inputArray[3]));
		}
		myBufferedReader.close();
	}

	private void readItems() throws Exception  {

		BufferedReader myBufferedReader = new BufferedReader(new FileReader(ItemLocation));
		
		for(String readLine = myBufferedReader.readLine(); readLine != null;readLine = myBufferedReader.readLine()) {
			String[] inputArray = readLine.split(";");

			int id = Integer.parseInt(inputArray[4]);
		
			Supplier supplier = findSupplier(id);

			if(supplier != null) {
				Item item = new Item(Integer.parseInt(inputArray[0]), inputArray[1], Integer.parseInt(inputArray[2]), Double.parseDouble(inputArray[3]), supplier);

				items.add(item);
				
				supplier.getItemList().add(item);
			}
		}
		myBufferedReader.close();
	}

	private Supplier findSupplier(int id) {
		for(Supplier mySupplier : suppliers) {
			if(mySupplier.getSupplierID() == id) {
				return mySupplier;
			}
		}
		return null;
	}

	public ArrayList<Item> getItems(){
		return items;
	}
	public ArrayList<Supplier> getSuppliers(){
		return suppliers;
	}	

}
