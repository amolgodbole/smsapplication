import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Profile {

	String name="";
	String address="";
	String email="";
	double contactNumber=0;
	List<Investor> investorList = new ArrayList<Investor>();
	Investor investor = null;
	
	public Profile(Investor investor){
		this.investor=investor;
	}
	
	private void createProfile(Investor investor) {
		// TODO Auto-generated method stub	
		// investorRecord[0]=investor;
		investorList.add(investor);
	}

	private void updateProfile(Investor investor) {
		Iterator<Investor> itr = investorList.iterator();
		
		while(itr.hasNext()) {
			Investor investorFromList = (Investor)itr.next();
			
			if(investorFromList.getStrFirstName().equals(investor.getStrFirstName())){
				System.out.println("Updating profile for: "+investor.getStrFirstName());
				investorFromList.setStrFirstName("Angad");
				System.out.println("Name updated is : "+investor.getStrFirstName());
				
			}
		}
		/*String newName = "Kmp";
		System.out.println("Name : " +investorRecord[0].getStrFirstName());
		investorRecord[0].setStrFirstName(newName);
		System.out.println("Name : " +investorRecord[0].getStrFirstName());*/
	}
	
	
	void testprofile(Investor investor){
		createProfile(investor);
		updateProfile(investor);
	}

	

	
}
