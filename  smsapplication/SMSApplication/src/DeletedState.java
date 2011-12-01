import java.util.Iterator;
import java.util.List;


public class DeletedState implements OrderStateInterface
{

	int deleted=0;
	private StockOrderInterface st;
	private Investor investor;
	
	void deleteExpired(){};
	void deleteOrderCompletionState(){};
	void deleteCustomerDelete(){};
	void displayDeletedDetails(){}
	
	private Profile profile = new Profile(investor); 
	private List<Investor> allInvestors = profile.investorList;
	
	private DeleteContext deleteContext; 
	
	public DeletedState(StockOrderInterface s)
	{
		st=s;
	}
	
	
	public void receiveOrder() {
		// TODO Auto-generated method stub
	System.out.println("Receive Order");	
	}
	
	public void processOrder() {
		// TODO Auto-generated method stub
		System.out.println("Process Order");
	}
	
	public void updateResult() {
		// TODO Auto-generated method stub
	System.out.println("Update Result");
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
	public String processDeletedOrder(OrderBean order) 
	{
		System.out.println("In Deleted Order State");
		String investorID = order.getInvestorID();
		Iterator<Investor> investorIterator = allInvestors.iterator();
		while (investorIterator.hasNext())
		{
			Investor matchInvestor = investorIterator.next();
			String matchInvestorID = matchInvestor.getInvestorID();
			
			if(matchInvestorID.equalsIgnoreCase(investorID))
			{
				System.out.println("Sending order to be deleted to strategy pattern");
				deleteContext.delete(matchInvestor, order.getStrOrderID(), "completed");
			}
			else
			{
				System.out.println("Order is already Deleted!");
			}
		}
		
		
		System.out.println("Order has been deleted... and waiting for processing new order!");
		return null;
	}
	@Override
	public String processCompletedOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return null;
	};
}
