
public class StockOrder extends OrderTMAAbstractClass implements StockOrderInterface{

	int orderID=0;
	String stockID="";
	double stockPrice=0;

	OrderStateInterface initialized;
	OrderStateInterface active;
	OrderStateInterface completed;
	
	 
	OrderStateInterface orderStateInterface;

	public StockOrder()
	{
		initialized 	= 	new InitializedState(this);
		active 			= 	ActiveState.getInstance(this);
		completed 		= 	new CompletedState(this);
		orderStateInterface = initialized;
	}



	public OrderStateInterface getActiveState()
	{
		return active;
	}


	public OrderStateInterface getCompletedState()
	{
		return completed;
	}
	public OrderStateInterface getInitializedState()
	{
		return initialized;
	}
	String type="";




	@Override
	public void setState(OrderStateInterface state)
	{
		orderStateInterface = state;
	}

	@Override
	public String processOrder(OrderBean order)
	{

		orderStateInterface.processOrder(order);

		return order.getStrOrderID();

	}




} 
