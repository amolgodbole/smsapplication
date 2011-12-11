import java.util.ArrayList;
import java.util.List;


public class InvestorListing 
{
	private static InvestorListing instance;

	private static List<Investor> allInvestors = new ArrayList<Investor>();
	

	private InvestorListing() 
	{
	}

	public List<Investor> getAllInvestors() {
		return allInvestors;
	}

	public void setAllInvestors(List<Investor> allInvestors) {
		InvestorListing.allInvestors = allInvestors;
	}
	
	public static InvestorListing getinstance()
	{
		if(instance == null)
		{
			instance = new InvestorListing();
		}
		return instance;
	}
	
	public void addInvestor(Investor investor)
	{
		allInvestors.add(investor);
	}
	
	
}
