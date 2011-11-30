
public class Matching implements ActiveStatesInterface
{ 
    private ActiveOrderStateInterface activeOrderStateInterface;
	
	public Matching(ActiveOrderStateInterface a)
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
	public String processMatchingOrder(OrderBean order, StockOrderInterface stockOrderInterface) {
		System.out.println("In Matching");
		
		//Logic of Matching
		
		
		//logic to call Matched 
		activeOrderStateInterface.setStates(activeOrderStateInterface.getMatched(stockOrderInterface));
		return null;
	}







	@Override
	public String processWaitingOrder(OrderBean order,
			StockOrderInterface stockOrderInterface) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String processMatchedOrder(OrderBean order,StockOrderInterface stockOrder) {
		// TODO Auto-generated method stub
		return null;
	}

}
