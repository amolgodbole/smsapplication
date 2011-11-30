
public class Waiting implements ActiveStates
{
    private ActiveOrderStateInterface activeinterface;
	
	public Waiting(ActiveOrderStateInterface a)
	{
		activeinterface=a;
	}
	
	@Override
	public void receiveOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processMatching() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateResult() {
		// TODO Auto-generated method stub
		
	}
		
}
