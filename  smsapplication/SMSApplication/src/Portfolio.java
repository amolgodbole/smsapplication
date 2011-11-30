
public class Portfolio {

	int profileId;
	int orderId;
	int accountId;
	int requestType;
	Investor investor = new Investor();
	private Profile profile = new Profile(investor);
	private Account account = new Account();
	private Order order = null;
	
	public Portfolio(Investor investor){
		this.investor=investor;
	}
	
	void processRequestType(int requestType){
		if(requestType==1)profile.testprofile(this.investor);
		
		if(requestType==2)account.accountOperations(this.investor);
		
		if(requestType==3) {
			order = new Order(investor);
			order.orderOperation();
		}
	};
}
