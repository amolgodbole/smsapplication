
import java.util.Collections;

public class Account {

	int accoundID=0;
	double balanceAmountlnAccount;
	//SortMap<Stock,numberOfShares> stock;
	//SortMap<MutualFund,numberOfMf> mutualfund;

	void displayAccountDetails(){};
	void createAccount(){};
	void deleteAccount(){};
	void modifyAccount(){};
	void checkBalanceAmountlnAccount(){};
	
	void testaccount(){
		System.out.println("Inside account");
	}
	public double getBalanceAmountlnAccount() {
		return balanceAmountlnAccount;
	}
	public void setBalanceAmountlnAccount(double balanceAmountlnAccount) {
		this.balanceAmountlnAccount = balanceAmountlnAccount;
	}
}
