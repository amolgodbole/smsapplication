
public interface StockOrderInterface {
	
	public String processOrder(OrderBean order);

	
	public OrderStateInterface getActiveState();
	public OrderStateInterface getCompletedState();
	public OrderStateInterface getInitializedState();

	public void setState(OrderStateInterface state);

}

