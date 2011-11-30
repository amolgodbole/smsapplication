
public class Expired implements DeleteStrategy {

	
	int expiredID=0;
	boolean expiredType=false;
	private Investor investor;
	String orderID ="";
	
	public Expired(Investor investor, String orderID) 
	{
		
		this.investor =  investor;
		this.orderID = orderID;
	}
	public Expired() 
	{


	}
	void deleteStrategyMethod(){};
	void displayExpiredDetails(){}
	@Override
	public String deleteOrder(Investor investor, String OrderID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
