
import java.io.*;

/**
 * @author Kenneth Loughery
 *
 */
public class FrontEnd {

	private Shop shop;
	private BufferedReader stdin;
	
	public FrontEnd(){
		stdin = new BufferedReader(new InputStreamReader(System.in));
		try {
			FileManager myFileManager = new FileManager();

			shop = new Shop(new Inventory (myFileManager.getItems()), new SupplierList(myFileManager.getSuppliers()));
		} catch (Exception e) {
			System.out.println("Unable to read input files. Exiting!");
			System.exit(1);
		}

	}

	/**
	 *	prints out the different menu options
	 */
	private void printMenu() {
		System.out.println("Welcome to the menu, what would you like to do today?");
		System.out.println("Please enter the number for your desired action:");
		System.out.println("1. List all tools in the inventory");
		System.out.println("2. Find a tool by its name");
		System.out.println("3. Find a tool by its id number");
		System.out.println("4. Check the remaining quantity of an item");
		System.out.println("5. Reduce the item quantity");
		System.out.println("6. Print an order");
		System.out.println("7. Quit");
	}

	private int getUserMenuInput(){
		String input = null;
		int response = 0;
		do  { //this loop will run until a non empty response has been received that is within the boundaries of the menu
			try{
				input= stdin.readLine();
				response = Integer.parseInt(input);
				if(response > 7 || response < 1){
					throw new NumberFormatException();
				}
			}
			catch(Exception e){
				System.out.println("Invalid input!");
				System.out.println("Please enter a number from 1-7");
			}

		} while (input == null || response < 1 || response > 7);	
		return response;	
	}

	private String getUserInput(String prompt){
		String input = null;
		System.out.println(prompt);
		do  { //this loop will run until a non empty response has been received that is within the boundaries of the menu
			try{
				input= stdin.readLine();
			}
			catch(Exception e){
				System.out.println("Invalid input!");
				System.out.println("Please try again");
				input = null;
			}
		} while (input == null);	
		return input;		
	}


	private int getNumericalUserInput(String prompt){
		int response;
		try{
			response = Integer.parseInt(getUserInput(prompt));
		}catch(Exception e){
			return getNumericalUserInput(prompt);
		}
		return response;
	}

	public void run(){

		int response;
		while(true) {
			printMenu();
			response = getUserMenuInput();
			switch(response){
				case 1:
					System.out.println(shop.printoutOfInventory());
				break;
				case 2:
					System.out.println(shop.getItem(getUserInput("Please enter the name of the tool you would like to find.")));
				break;
				case 3:					
					System.out.println(shop.getItem(getNumericalUserInput("Please enter the id number of the tool you would like to find.")));
				break;
				case 4:
					System.out.println(shop.getQuantity(getUserInput("Please enter the name of the tool you would like to find the remaining quantity of.")));
				break;
				case 5:
					System.out.println(shop.reduceItem("Please enter the name of the tool you would like to reduce the quantity of."));
				break;
				case 6: 
					System.out.println(shop.generateOrder());
				break;
				default:
					System.out.println("Exiting program...");
					return;
				
			}
		}
	}
	
	
	public static void main (String [] args){
		FrontEnd start = new FrontEnd();
		start.run();
	
	}
		
}
