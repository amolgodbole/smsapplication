
public class CompletedState implements OrderStateInterface
{
	private StockOrderInterface stockOrderInterface;
	
	public CompletedState(StockOrderInterface s)
	{
		stockOrderInterface = s;
	}
	public void receiveOrder() {
		// TODO Auto-generated method stub
		
	}

	public void processOrder() {
		// TODO Auto-generated method stub
		
	}

	public void updateResult() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String processInitializedOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String processActiveOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String processDeletedOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String processCompletedOrder(OrderBean order) {

		System.out.println("Order Completed Sending it to delete");
		stockOrderInterface.setState(stockOrderInterface.getActiveState());
		return null;
	}
	@Override
	public String processOrder(OrderBean order) 
	{
		
		return "Completed";
	}

	
	
}
