
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
		strReturn = order.getOrderType();
		
		return strReturn;
		
	}
	
	abstract void processorder(Order order);
	
	
	/*	int orderID=0;
		int brokerID=0;
		int exchangeID=0;
		int flag=0;*/
		
		//void implementOdr(Order order);
		//void checkBalance(balanceAmountInAccount);
	//	void appendBrokerID(orderID);
	//	void appendExchangeID(brokerID);
	//	void appendOrderHistoryID(exchangeID);
	//	void checkOrderType();
	//	void processOrder(Order order);

	
	
	
	
}
