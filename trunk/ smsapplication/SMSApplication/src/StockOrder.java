
public class StockOrder extends OrderTMAAbstractClass implements StockOrderInterface{

		int orderID=0;
		String stockID="";
		double stockPrice=0;
		private DeleteStrategy ds;
		
		OrderStateInterface initialized;
		OrderStateInterface active;
		OrderStateInterface deleted;
		OrderStateInterface completed;
		OrderStateInterface state;
		
		public StockOrder()
		{
			active=new ActiveState(this);
			deleted=new DeletedState(this);
			completed=new CompletedState(this);
			state=active;
		}
		
		public void receiveOrder()
		{
			System.out.println("Receive Order");
		}
		
		public void processOrder()
		{
			System.out.println("Process Order");
		}
		
		public void updateResult()
		{
			System.out.println("Update Result");
		}
		
		public OrderStateInterface getActiveState()
		{
			return active;
		}
		
		public OrderStateInterface getDeletedState()
		{
			return deleted;
		}
		

		public OrderStateInterface getCompletedState()
		{
			return completed;
		}
		public OrderStateInterface getInitializedState()
		{
			return initialized;
		}
		String type="";
		
		
		
	
		
		private DeleteStrategy setDeleteStrategy() {
			// TODO Auto-generated method stub
			//implementation of different delete strategy methods
			//based on the logic we implement.
			
			if (type=="customerdelete")
			{}//goto (CustomerDelete);
			if(type=="expired")
				//goto (Expired);
			{}
				if(type=="ordercompleted")
				//goto (OrderCompletionDelete);
				{}
				
				
			return ds;
			
		}

		@Override
		public void setState(OrderStateInterface state) {
			// TODO Auto-generated method stub
			
		}

		@Override
		void processOrder(OrderBean order) {
			// TODO Auto-generated method stub
			
		}


		
		
		//void processOrder(orderID);

				
		
}
