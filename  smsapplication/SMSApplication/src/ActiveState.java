public class ActiveState implements OrderStateInterface,ActiveOrderStateInterface{

	private StockOrderInterface st;
	ActiveStates matching; 
	ActiveStates matched;
	ActiveStates waiting;
	ActiveStates state;
	
	public ActiveState(StockOrderInterface s)
	{
		st=s;
	}
	
	public ActiveState()
	{
		matching=new Matching(this);
		matched=new Matched(this);
		waiting=new Waiting(this);
		state=waiting;
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

	@Override
	public void processMatching() {
		// TODO Auto-generated method stub
		System.out.println("ProcessMatching");
	}

	@Override
	public ActiveStates getMatched() {
		// TODO Auto-generated method stub
		return matched;
	}

	@Override
	public ActiveStates getMatching() {
		// TODO Auto-generated method stub
		System.out.println("Get Matching");
		return matching;
	}

	@Override
	public ActiveStates getWaiting() {
		// TODO Auto-generated method stub
		return waiting;
	}

	@Override
	public void setStates(ActiveStates state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setState(ActiveState state) {
		// TODO Auto-generated method stub
		
	}




}
