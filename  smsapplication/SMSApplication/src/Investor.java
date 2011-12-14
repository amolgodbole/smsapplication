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


	List<AccountBean> accountList = new ArrayList<AccountBean>();
	List<Stock> stocks = new ArrayList<Stock>();
	List<MutualFund> mutualFunds = new ArrayList<MutualFund>();
	double amountInAccount = 25000d;
	List<OrderBean> orderList = new ArrayList<OrderBean>();
	
	
	
	
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	public List<MutualFund> getMutualFunds() {
		return mutualFunds;
	}
	public void setMutualFunds(List<MutualFund> mutualFunds) {
		this.mutualFunds = mutualFunds;
	}
	public double getAmountInAccount() {
		return amountInAccount;
	}
	public void setAmountInAccount(double amountInAccount) {
		this.amountInAccount = amountInAccount;
	}
	public List<AccountBean> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<AccountBean> accountList) {
		this.accountList = accountList;
	}
	public List<OrderBean> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<OrderBean> orderList) {
		this.orderList = orderList;
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
