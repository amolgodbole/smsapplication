
public class ActiveState implements OrderStateInterface{

	private StockOrderInterface st;
	
	public ActiveState(StockOrderInterface s)
	{
		st=s;
	}
	
	public void receiveOrder() {
		// TODO Auto-generated method stub
		System.out.println("Receiving the order");
	}

	public void processOrder() {
		// TODO Auto-generated method stub
		System.out.println("Processing the order");
	}

	public void updateResult() {
		// TODO Auto-generated method stub
		System.out.println("Update the result");
	}

}
