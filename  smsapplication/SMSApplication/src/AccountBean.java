import java.util.*;

public class AccountBean {
	String accoundID;
	double balanceAmountlnAccount;
	
	
	public AccountBean(String accountID, double balanceAmountlnAccount) {
		// TODO Auto-generated constructor stub
		this.accoundID=accountID;
		this.balanceAmountlnAccount=balanceAmountlnAccount;
		
	}

	void testaccount(Investor investor){
		System.out.println("Creating new account");
	}
	
	public String getAccoundID() {
		return accoundID;
	}
	public void setAccoundID(String accoundID) {
		this.accoundID = accoundID;
	}

	public double getBalanceAmountlnAccount() {
		return balanceAmountlnAccount;
	}

	public void setBalanceAmountlnAccount(double balanceAmountlnAccount) {
		this.balanceAmountlnAccount = balanceAmountlnAccount;
	}
}
