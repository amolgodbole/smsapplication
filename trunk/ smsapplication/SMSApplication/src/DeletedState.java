
public class DeletedState implements OrderStateInterface{

	int deleted=0;
	private StockOrderInterface st;
	
	void deleteExpired(){};
	void deleteOrderCompletionState(){};
	void deleteCustomerDelete(){};
	void displayDeletedDetails(){}
	
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
	};
}
