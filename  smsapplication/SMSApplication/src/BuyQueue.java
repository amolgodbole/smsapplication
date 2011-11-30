import java.util.SortedMap;
import java.util.TreeMap;


public class BuyQueue 
{
	OrderBean order ;
	SortedMap map = new TreeMap();
	
	public String insertOrderinQueue(OrderBean order)
	{
		System.out.println("In Buy Queue");
		Double bidAmount = (Double) order.getBidAmount();
		map.put(bidAmount, order);
		
		return "Inserted";
	}
	
	
	  Iterator iterator = map.keySet().iterator();
	  while (iterator.hasNext()) {
	  Object key = iterator.next();
	  System.out.println("key : " + key + " value :" + map.get(key));
	  }
}
