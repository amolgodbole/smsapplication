
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
	public String processOrder(OrderBean order) 
	{
		
		System.out.println("Order in completed state");
		
		return "Completed";
	}

	
	
}
