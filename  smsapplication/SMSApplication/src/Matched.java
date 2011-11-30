
public class Matched implements ActiveStatesInterface
{
	private ActiveOrderStateInterface activeOrderStateInterface;
	
	public Matched(ActiveOrderStateInterface a)
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
	public String processMatchedOrder(OrderBean order, StockOrderInterface stockOrder) 
	{
		stockOrder.setState(stockOrder.getCompletedState());
		return "matched";
	}



	@Override
	public String processWaitingOrder(OrderBean order,
			StockOrderInterface stockOrderInterface) {
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
