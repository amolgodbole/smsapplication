

public class Order 
{
	
	String 		strOrderID;
	boolean 	partialOrderFlag;
	Account 	account;
	String 		orderType;//should be set to MutualFund or Should be set to Stocks
	
	
	public String getStrOrderID() {
		return strOrderID;
	}



	public void setStrOrderID(String strOrderID) {
		this.strOrderID = strOrderID;
	}



	public boolean isPartialOrderFlag() {
		return partialOrderFlag;
	}



	public void setPartialOrderFlag(boolean partialOrderFlag) {
		this.partialOrderFlag = partialOrderFlag;
	}
	
	



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	public String getOrderType() {
		return orderType;
	}



	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

}

/*public class Order implements OrderTMAAbstractClass{

	void testorder(){
		System.out.println("Inside order");
	}
}*/
