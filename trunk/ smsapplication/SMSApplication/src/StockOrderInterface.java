
public interface StockOrderInterface {
	
	public void processOrder();
	public void receiveOrder();
	public void updateResult();
	
	public OrderStateInterface getActiveState();
	public OrderStateInterface getCompletedState();
	public OrderStateInterface getInitializedState();
	public OrderStateInterface getDeletedState();

	public void setState(OrderStateInterface state);

}

