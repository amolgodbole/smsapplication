
public interface StockOrderInterface {
	
	public String processOrder(OrderBean order);
	//public void processActiveOrder(OrderBean order);
	public void updateResult();
	
	public OrderStateInterface getActiveState();
	public OrderStateInterface getCompletedState();
	public OrderStateInterface getInitializedState();
	public OrderStateInterface getDeletedState();

	public void setState(OrderStateInterface state);

}

