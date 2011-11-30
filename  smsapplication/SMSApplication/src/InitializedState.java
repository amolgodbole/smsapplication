
public class InitializedState implements OrderStateInterface
{
	private StockOrderInterface st;
	
	void InitializedState(StockOrderInterface s)
	{
		s=st;
	}
		
		public void processOrder() {
			// TODO Auto-generated method stub
			st.setState(st.getActiveState());
			//st.setState(st.getActiveState());
			System.out.println("Process Order");
		}
	
		public void receiveOrder() {
			// TODO Auto-generated method stub
			st.setState(st.getActiveState());
		}
	
		public void updateResult() {
			// TODO Auto-generated method stub
		st.setState(st.getCompletedState());	
		};

	
}
