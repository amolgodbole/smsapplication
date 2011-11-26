
public class Portfolio {

	int profileID=0;
	int accountID=0;
	int orderID=0;
	int requestType;
	private Profile profile = new Profile();
	private Account account = new Account();
	private Order order = new Order();

	public Portfolio(int requestType){
		this.requestType=requestType;
	}
	
	void processRequestType(){
		if(requestType==1)profile.testprofile();
		
		if(requestType==2)account.testaccount();
		
		if(requestType==3)order.testorder();
	};
}
