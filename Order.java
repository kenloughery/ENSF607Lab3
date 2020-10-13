
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.util.ArrayList;

/**
 * @author Kenneth Loughery
 *
 */
public class Order {

	private ArrayList<OrderLine> myOrder;
	
	public Order() {
		myOrder = new ArrayList<OrderLine>();
	}

	public void addOrderLine(OrderLine newLine) {
		if(newLine != null){ myOrder.add(newLine); }
	}


	/**
	 * @return the order
	 */
	public String generateOrder() { 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("LLLL dd, yyyy");
		LocalDateTime now = LocalDateTime.now();
		String order = "*********************************************************\n";
		order+= "ORDER ID:\t\t\t" + (int) (Math.random() * 100000) + "\n";
		order+= "Data Ordered:\t\t\t" + dtf.format(now) + "\n";

		for(OrderLine l : myOrder) {
			order+=l.orderLine();
		}
		order += "*********************************************************\n";
		return order;
	}




}
