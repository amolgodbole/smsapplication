
public class OrderCompletionState implements DeleteStrategy{

	int OrderCompletionStateID=0;
	boolean OrderCompletionStateType=false;
	private Investor investor;
	String orderID ="";
	
	
	
	public OrderCompletionState(Investor investor, String orderID) 
	{

		this.investor =  investor;
		this.orderID = orderID;
	}
	public OrderCompletionState() 
	{
		
	}
	void deleteStrategyMethod() {};
	void deleteStrategyCompletionStateDetails(){}
	
	
	@Override
	public String deleteOrder(Investor investor, String OrderID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}

