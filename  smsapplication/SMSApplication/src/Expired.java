import java.util.Iterator;
import java.util.List;


public class Expired implements DeleteStrategy {

	
	int expiredID=0;
	boolean expiredType=false;
	private Investor investor;
	String 	strOrderID ="";
	
	public Expired(Investor investor, String orderID) 
	{
		
		this.investor =  investor;
		this.strOrderID = orderID;
	}
	public Expired() 
	{


	}
	void deleteStrategyMethod(){};
	void displayExpiredDetails(){}
	@Override
	public String deleteOrder(Investor investor, String orderID) 
	{
		List<OrderBean> orders = investor.getOrderList();
		Iterator<OrderBean> orderIterator = orders.iterator();
		while(!orders.isEmpty())
		{
			while(orderIterator.hasNext())
			{
				OrderBean order = orderIterator.next();
				strOrderID = order.getStrOrderID();
				
				if(strOrderID.equalsIgnoreCase(orderID))
				{
					
				}
			}
		}
		return "deleted";

	}
	
	

}
