import java.sql.Time;


public class StockOrder extends OrderTMAAbstractClass implements StockOrderInterface{

	int orderID=0;
	String stockID="";
	double stockPrice=0;
	private DeleteStrategy ds;

	OrderStateInterface initialized;
	OrderStateInterface active;
	OrderStateInterface deleted;
	OrderStateInterface completed;
	OrderStateInterface orderStateInterface;

	public StockOrder()
	{
		initialized 	= 	new InitializedState(this);
		active 			= 	ActiveState.getInstance(this);
		deleted 		= 	new DeletedState(this);
		completed 		= 	new CompletedState(this);
		orderStateInterface = initialized;
	}




	public void updateResult()
	{
		System.out.println("Update Result");
	}

	public OrderStateInterface getActiveState()
	{
		return active;
	}

	public OrderStateInterface getDeletedState()
	{
		return deleted;
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





	private DeleteStrategy setDeleteStrategy() {
		// TODO Auto-generated method stub
		//implementation of different delete strategy methods
		//based on the logic we implement.

		if (type=="customerdelete")
		{}//goto (CustomerDelete);
		if(type=="expired")
			//goto (Expired);
		{}
		if(type=="ordercompleted")
			//goto (OrderCompletionDelete);
		{}


		return ds;

	}

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


	public void processActiveOrder(OrderBean order) {
		orderStateInterface.processActiveOrder(order);

	}



} 
