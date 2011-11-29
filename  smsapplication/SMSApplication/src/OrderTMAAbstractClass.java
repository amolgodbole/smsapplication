
public abstract class OrderTMAAbstractClass 
{
	
	Order 	orderInTM 					= new Order();
	int 	nAccoiuntID 				= 0;
	double	dBalanceAmountInAccount		= 0;
	
	
	
	void implementOrder(Order order)
	{
		checkBalance(order.account);
		appendBrokerId(order);
		appendExchangeId(order);
		appendOrderHistoryId(order);
		String orderType = checkOrderType(order);
		if(orderType.equalsIgnoreCase("false"))
		{
			System.out.println("Incorrect Order Type!");
		}
		
		if(orderType.equalsIgnoreCase("stock"))
		{
			processOrder(order);
		}
		
		if(orderType.equalsIgnoreCase("mutualfund"))
		{
			processOrder(order);
		}
		
	}
	
	boolean checkBalance(Account account)
	{
		return false;
		//logic
		
	}
	
	protected String appendBrokerId(Order order)
	{
		orderInTM.setStrOrderID("B001-"+order.getStrOrderID());
		return orderInTM.getStrOrderID();
	}
	
	
	protected String appendExchangeId(Order order)
	{
		orderInTM.setStrOrderID("E001-"+order.getStrOrderID());
		return orderInTM.getStrOrderID();
	}
	
	protected void appendOrderHistoryId(Order order)
	{
		 //if(!order.isPartialOrderFlag())
		orderInTM.setStrOrderID(order.getStrOrderID()+"-0001");
		 
		 //if(partialOrderFlag)
		int orderHistoryID = Integer.parseInt(order.getStrOrderID().substring(17));
		++orderHistoryID;
		implementOrder(order);
		
	}
	
	protected String checkOrderType(Order order)
	{	
		String strReturn = "false";
		if (order.getOrderType().equalsIgnoreCase("mutualfund"))
		{
			strReturn = "MutualFund";
			return strReturn;
		}
		
		if(order.getOrderType().equalsIgnoreCase("stock"))
		{
			strReturn = "Stock";
			return strReturn;
		}
		return strReturn;
	}
	
	abstract void processOrder(Order order);
	
}
