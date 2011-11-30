import java.util.ArrayList;
import java.util.List;


public class Investor 
{
	String investorID;
	String 	strFirstName;
	String 	strLastName;
	String 	strAddress;
	String 	strState;
	String 	strEmail;
	long	nPhone;
	int		nMobile;

	Account account = new Account();
	List<OrderBean> orderList = new ArrayList<OrderBean>();
	
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<OrderBean> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderBean> orderList) {
		this.orderList = orderList;
	}

	public void setAccountBal(int accountBal) {
		account.setBalanceAmountlnAccount(accountBal);
	}
	
	public double getAccountBal(){
		return account.getBalanceAmountlnAccount();
	}
	public String getStrFirstName() {
		return strFirstName;
	}
	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}
	public String getStrLastName() {
		return strLastName;
	}
	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}
	public String getStrAddress() {
		return strAddress;
	}
	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}
	public String getStrState() {
		return strState;
	}
	public void setStrState(String strState) {
		this.strState = strState;
	}
	public String getStrEmail() {
		return strEmail;
	}
	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}
	public long getnPhone() {
		return nPhone;
	}
	public void setnPhone(long nPhone) {
		this.nPhone = nPhone;
	}
	public int getnMobile() {
		return nMobile;
	}
	public void setnMobile(int nMobile) {
		this.nMobile = nMobile;
	}
	public String getInvestorID() {
		return investorID;
	}
	public void setInvestorID(String investorID) {
		this.investorID = investorID;
	}


	
	
}
