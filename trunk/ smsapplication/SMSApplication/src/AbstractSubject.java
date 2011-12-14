import java.util.ArrayList;
import java.util.List;


public class AbstractSubject 
{
	protected List<Investor> investorList = new ArrayList<Investor>();
	
	
	public void addObserver(Investor investor)
	{
		investorList.add(investor);
	}
	
	public void removeObserver(Investor investor)
	{
		investorList.remove(investor);
	}
	
	
	
}
