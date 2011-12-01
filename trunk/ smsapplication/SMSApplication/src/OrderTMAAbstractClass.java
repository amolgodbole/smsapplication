
public abstract class OrderTMAAbstractClass 
{
	
	OrderBean 	orderInTM 					= new OrderBean();
	int 	nAccoiuntID 				= 0;
	double	dBalanceAmountInAccount		= 0;
	
	
	
	void implementOrder(OrderBean order)
	{
		//checkBalance(order.account);
		System.out.println("In Template method order class");
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
	
	protected String appendBrokerId(OrderBean order)
	{
		System.out.println("Appending broker id");
		orderInTM.setStrOrderID("B001-"+order.getStrOrderID());
		System.out.println("Appending broker id" +orderInTM.getStrOrderID());
		return orderInTM.getStrOrderID();
	}
	
	
	protected String appendExchangeId(OrderBean order)
	{
		System.out.println("Appending exchange id");
		orderInTM.setStrOrderID("E001-"+order.getStrOrderID());
		System.out.println("Appending exchange id" +orderInTM.getStrOrderID());
		return orderInTM.getStrOrderID();
	}
	
	protected String appendOrderHistoryId(OrderBean order)
	{
		 //if(!order.isPartialOrderFlag())
		System.out.println("Appending order history id");
		orderInTM.setStrOrderID(order.getStrOrderID()+"-0001");
		System.out.println("Appending order history id" +orderInTM.getStrOrderID());
		
		 return orderInTM.getStrOrderID();
		 //if(partialOrderFlag)
		//int orderHistoryID = Integer.parseInt(order.getStrOrderID());
		//int orderHistoryID = 01;
		//++orderHistoryID;
		//implementOrder(order);
		
	}
	
	protected String checkOrderType(OrderBean order)
	{	
		System.out.println("Checking order type");
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
	
	abstract String processOrder(OrderBean order);
	
}
