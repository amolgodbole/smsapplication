import java.util.SortedMap;
import java.util.TreeMap;


public class BuyQueue 
{
	OrderBean order ;
	SortedMap<Double, OrderBean> map = new TreeMap<Double, OrderBean>();
	
	public String insertOrderinQueue(OrderBean order)
	{
		System.out.println("In Buy Queue");
		Double bidAmount = (Double) order.getBidAmount();
		map.put(bidAmount, order);
		
		return "Inserted";
	}
	
	public OrderBean getOrder() {
		return order;
	}

	public void setOrder(OrderBean order) {
		this.order = order;
	}

	public SortedMap<Double, OrderBean> getMap() {
		return map;
	}

	public void setMap(SortedMap<Double, OrderBean> map) {
		this.map = map;
	}

	public SortedMap<Double,OrderBean> getBuyQueue()
	{
		return map;
	}
	
/*	
	  Iterator iterator = map.keySet().iterator();
	  while (iterator.hasNext()) {
	  Object key = iterator.next();
	  System.out.println("key : " + key + " value :" + map.get(key));
	  }*/
}
