import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Profile {

	List<Investor> investorList = new ArrayList<Investor>();
	Investor investor = null;
	
	public Profile(Investor investor)
	{
		this.investor = investor;
	}
	
	public Profile()
	{
		
	}
	
	private void createProfile(Investor investorNew) {
		
		
			investorList.add(investorNew);
			System.out.println("Profile created : " +investorNew.getInvestorID());
			System.out.println("-----------------------------------------------");
			System.out.println("Name : " +investorNew.getStrFirstName()+investorNew.getStrLastName());
			System.out.println("Address : "+investorNew.getStrAddress()+","+investorNew.getStrState());
			System.out.println("Contact : "+investorNew.getnMobile()+","+investorNew.getnPhone());
			System.out.println("E-mail : "+investorNew.getStrEmail());
				}	
		/*public void viewList(List<Investor> investorList){
			Iterator<Investor> itr = investorList.iterator();
			
			while(itr.hasNext()) {
				Investor investor1 = (Investor) itr.next();
				System.out.println("Investor id: "+investor1.getInvestorID());
				System.out.println("Investor name: "+investor1.getStrFirstName());	
			}
		}*/

	private void updateProfile(Investor investor) {
		//viewList(investorList);
		System.out.println("Enter update for : ");
		System.out.println("1.E-mail");
		System.out.println("2.Contact number");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Iterator<Investor> itr = investorList.iterator();
		try {
			String option = br.readLine();
			if(option.equals("1")){
				while(itr.hasNext()) {
					Investor investorFromList = (Investor)itr.next();
					if(investorFromList.getInvestorID().equals(investor.getInvestorID())){
						System.out.println("Updating profile for: "+investor.getInvestorID());
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						System.out.println("Enter new email id : ");
						option=br1.readLine();
						investorFromList.setStrEmail(option);
						System.out.println("Name updated is : "+investor.getStrFirstName());
						System.out.println("Profile" +investor.getInvestorID()+ " updated :");
						System.out.println("-----------------------------------------------");
						System.out.println("Name : " +investor.getStrFirstName()+investor.getStrLastName());
						System.out.println("Address : "+investor.getStrAddress()+","+investor.getStrState());
						System.out.println("Contact : "+investor.getnMobile()+","+investor.getnPhone());
						System.out.println("E-mail : "+investor.getStrEmail());
						//System.out.println("Balance amount : "+investor.getAccountBal());
					}
				}
			}else if(option.equals("2")){
				while(itr.hasNext()) {
					Investor investorFromList = (Investor)itr.next();
					if(investorFromList.getInvestorID().equals(investor.getInvestorID())){
						System.out.println("Updating profile for: "+investor.getInvestorID());
						BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
						System.out.println("Enter new contact number : ");
						option=br1.readLine();
						investorFromList.setnPhone(Long.parseLong(option));
						System.out.println("Number updated is : "+investor.getStrFirstName());
						System.out.println("Profile" +investor.getInvestorID()+ " updated :");
						System.out.println("-----------------------------------------------");
						System.out.println("Name : " +investor.getStrFirstName()+investor.getStrLastName());
						System.out.println("Address : "+investor.getStrAddress()+","+investor.getStrState());
						System.out.println("Contact : "+investor.getnMobile()+","+investor.getnPhone());
						System.out.println("E-mail : "+investor.getStrEmail());
						//System.out.println("Balance amount : "+investor.getAccountBal());
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		/*String newName = "Kmp";
		System.out.println("Name : " +investorRecord[0].getStrFirstName());
		investorRecord[0].setStrFirstName(newName);
		System.out.println("Name : " +investorRecord[0].getStrFirstName());*/
	}
	
	
	void testprofile(Investor investor){
		createProfile(investor);
		System.out.println("Do you want to update the profile ? (y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String option = br.readLine();
			if(option.equals("y"))updateProfile(investor);;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	
}
