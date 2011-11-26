
public interface OrderState {

		String Orderid="";
		OrderState state=null;
		OrderState initialised=null;
		OrderState active=null;
		 
		
		void receiveOrder();
		void processMatching();
		void updateResult();

	
	
}
