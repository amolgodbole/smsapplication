
public class CompletedState implements OrderStateInterface
{
	private StockOrderInterface st;
	
	public CompletedState(StockOrderInterface s)
	{
		s=st;
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
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
