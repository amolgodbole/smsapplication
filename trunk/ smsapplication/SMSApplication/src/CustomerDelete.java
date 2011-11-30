import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CustomerDelete implements DeleteStrategy{

	int customerDeleteID=0;
	boolean customerDeleteType=false;
	private Investor investor;
	String strOrderID ="";
	
	
	public CustomerDelete(Investor investor, String orderID) 
	{
		this.investor =  investor;
		this.strOrderID = orderID;
	}
	public CustomerDelete() 
	{
		
	}
	
	void deleteStrategyMethod() {};
	void displayCustomerDeleteDetails() {}
	
	
	
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
		return null;
	}
	

}
