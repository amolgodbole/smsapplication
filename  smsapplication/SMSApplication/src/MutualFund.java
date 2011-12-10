import java.util.ArrayList;
import java.util.List;


public class MutualFund extends Investor
{
	String mutualFundID=""; // some investor ID
	double mutualFundPrice;
	List<Stock> stocks=new ArrayList<Stock>();
	
	public String getMutualFundID() {
		return mutualFundID;
	}
	public void setMutualFundID(String mutualFundID) {
		this.mutualFundID = mutualFundID;
	}
	public double getMutualFundPrice() {
		return mutualFundPrice;
	}
	public void setMutualFundPrice(double mutualFundPrice) {
		this.mutualFundPrice = mutualFundPrice;
	}
	

	
}
