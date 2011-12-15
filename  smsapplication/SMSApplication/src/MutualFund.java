import java.util.ArrayList;
import java.util.List;


public class MutualFund extends Investor
{
	String mutualFundID=""; // some investor ID
	double mutualFundPrice=0;
	int noofunits;
	List<Stock> stocks=new ArrayList<Stock>();
	
	
	public int getNoofStocks() {
		return noofunits;
	}
	public void setNoofStocks(int noofStocks) {
		this.noofunits = noofStocks;
	}
	
	
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
