
public class Waiting implements ActiveStatesInterface
{
    private ActiveOrderStateInterface activeOrderStateInterface;
	
	public Waiting(ActiveOrderStateInterface a)
	{
		activeOrderStateInterface=a;
	}
	


	@Override
	public String processMatching() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String updateResult() {
		return null;
		// TODO Auto-generated method stub
		
	}




	@Override
	public String processWaitingOrder(OrderBean order,
			StockOrderInterface stockOrderInterface) 
	{
		System.out.println("IN Waiting");
		activeOrderStateInterface.setStates(activeOrderStateInterface.getMatching());
		return null;
	}



	@Override
	public String processMatchedOrder(OrderBean order,
			StockOrderInterface stockOrder) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String processMatchingOrder(OrderBean order,
			StockOrderInterface stockOrderInterface) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
