import java.util.Iterator;
import java.util.List;


public class OrderBean {

	String 		strOrderID;
	boolean 	partialOrderFlag;
	String 		orderType;//should be set to MutualFund or Should be set to Stocks
	String investorID;
	
	/*Account account;
	*/
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
	
	/*



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}*/



	public String getOrderType() {
		return orderType;
	}



	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public void createOrder(){
	System.out.println("Order created");	
	}
	
	public void updateOrder(){
		
	}
	
	public void deleteOrder(){
		
	}



	public String getInvestorID() {
		return investorID;
	}



	public void setInvestorID(String investorID) {
		this.investorID = investorID;
	}
	
	public void viewOrders(List<OrderBean> orderList) {
		Iterator<OrderBean> itr = orderList.iterator();
		
		while(itr.hasNext()) {
			OrderBean orderBean = (OrderBean) itr.next();
			System.out.println("Investor id: "+orderBean.getInvestorID());
			System.out.println("Order id: "+orderBean.getStrOrderID());
			System.out.println("Order Type: "+orderBean.getOrderType());
		}
	}
}
