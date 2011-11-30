public class ActiveState implements OrderStateInterface,ActiveOrderStateInterface{

	private StockOrderInterface stockOrderInterface;
	private ActiveOrderStateInterface activeOrderStateInterface;
	ActiveStatesInterface matching; 
	ActiveStatesInterface matched;
	ActiveStatesInterface waiting;
	ActiveStatesInterface state;
	
	
	
	BuyQueue buyQueue = new BuyQueue();
	SellQueue sellQueue = new SellQueue();
	
	public ActiveState(StockOrderInterface s)
	{
		stockOrderInterface=s;
	}
	
	public ActiveState()
	{
		matching=new Matching(this);
		matched=new Matched(this);
		waiting=new Waiting(this);
		state	=	waiting;
	}


	public void updateResult() {
		// TODO Auto-generated method stub
		System.out.println("Update the result");
	}

	@Override
	public void processMatching() {
		// TODO Auto-generated method stub
		System.out.println("ProcessMatching");
	}


	@Override
	public ActiveStatesInterface getMatching() {
		// TODO Auto-generated method stub
		System.out.println("Get Matching");
		return matching;
	}

	@Override
	public ActiveStatesInterface getWaiting() {
		// TODO Auto-generated method stub
		return waiting;
	}

	@Override
	public void setStates(ActiveStatesInterface state) {
		
	}

	public void setState(ActiveState state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String processInitializedOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processActiveOrder(OrderBean order) 
	{
		System.out.println("Order in Active State !!");
		if(order.getOrderProcessType().equalsIgnoreCase("Buy_Orders"))
		{
			buyQueue.insertOrderinQueue(order);
			activeOrderStateInterface.setStates(activeOrderStateInterface.getWaiting());
			//stockOrderInterface.setState(stockOrderInterface.getActiveState());
		}
		else if(order.getOrderProcessType().equalsIgnoreCase("Sell_Orders"))
		{
			sellQueue.insertOrderinQueue(order);
		}
		
		return null;
	}

	@Override
	public String processDeletedOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String processCompletedOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void receiveOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActiveStatesInterface getMatched(StockOrderInterface stockOrder) {
		// TODO Auto-generated method stub
		return null;
	}




}
