import java.util.SortedMap;
import java.util.TreeMap;


public class SellQueue 
{
	OrderBean order ;
	SortedMap map = new TreeMap();
	
	public String insertOrderinQueue(OrderBean order)
	{
		System.out.println("In Sell Queue! ");
		Double bidAmount = (Double) order.getBidAmount();
		map.put(bidAmount, order);
		return "Inserted";
		
	}

}
