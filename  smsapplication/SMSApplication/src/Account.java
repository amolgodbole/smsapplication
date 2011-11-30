
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Account {

	String accoundID;
	double balanceAmountlnAccount;
	//SortMap<Stock,numberOfShares> stock;
	//SortMap<MutualFund,numberOfMf> mutualfund;

	void displayAccountDetails(){};
	void createAccount(Investor investor){
		AccountBean account = new AccountBean("ACC-01",10000);
		investor.accountList.add(account);
		System.out.println("Account id created is : " +investor.getStrFirstName());
	};
	void deleteAccount(){};
	void modifyAccount(){};
	void checkBalanceAmountlnAccount(){};
	
	public void viewAccount(List<AccountBean> accountList) {
		Iterator<AccountBean> itr = accountList.iterator();
		
		while(itr.hasNext()) {
			AccountBean accountBean = (AccountBean) itr.next();
			System.out.println("Account id: "+accountBean.getAccoundID());
			System.out.println("Account balance: "+accountBean.getBalanceAmountlnAccount());
		}
	}
	
	public void accountOperations(Investor investor){
		while(true) {
			
			System.out.println("Enter your choice : ");
			System.out.println("1. Create Account");
			System.out.println("2. Delete Account");
			System.out.println("3. Update Account");
			System.out.println("4. View Account");
			System.out.println("5. Exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				String option = br.readLine();
				if(option.equals("1")){
					createAccount(investor);;
				}
				if(option.equals("2")) deleteAccount();
				if(option.equals("3")) modifyAccount();
				//if(option.equals("4")) order.viewOrders(investor.orderList);
				if(option.equals("4")) viewAccount(investor.accountList);
				if(option.equals("5")) break;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	}
	
	
	public double getBalanceAmountlnAccount() {
		return balanceAmountlnAccount;
	}
	public void setBalanceAmountlnAccount(double balanceAmountlnAccount) {
		this.balanceAmountlnAccount = balanceAmountlnAccount;
	}
}
