import java.util.Iterator;
import java.util.List;


public class OrderCompletionState implements DeleteStrategy{

	int OrderCompletionStateID=0;
	boolean OrderCompletionStateType=false;
	private Investor investor;
	String strOrderID ="";
	
	
	
	public OrderCompletionState(Investor investor, String orderID) 
	{

		this.investor =  investor;
		this.strOrderID = orderID;
	}
	public OrderCompletionState() 
	{
		
	}
	void deleteStrategyMethod() {};
	void deleteStrategyCompletionStateDetails(){}
	
	
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
					System.out.println("In Order Completion State Class !!");
					System.out.println("Deleteing Order");
					orders.remove(orderID);
					System.out.println("Deleted");
					return"deleted";
				}
			}
		}
		return "deleted";
	}
	
	


}

