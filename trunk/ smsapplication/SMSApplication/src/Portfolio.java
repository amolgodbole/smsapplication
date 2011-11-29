
public class Portfolio {

	int profileId;
	int orderId;
	int accountId;
	int requestType;
	Investor investor = new Investor();
	private Profile profile = new Profile(investor);
	private Account account = new Account();
	private Order order = new Order();
	
	public Portfolio(int requestType,Investor investor){
		this.requestType=requestType;
		this.investor=investor;
	}
	
	void processRequestType(){
		if(requestType==1)profile.testprofile(this.investor);
		
		if(requestType==2)account.testaccount();
		
		if(requestType==3)order.orderOperation();
	};
}
