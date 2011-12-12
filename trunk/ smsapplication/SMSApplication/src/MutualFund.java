import java.util.ArrayList;
import java.util.List;


public class MutualFund extends Investor
{
	String mutualFundID=""; // some investor ID
	double mutualFundPrice;
	int noofStocks;
	public int getNoofStocks() {
		return noofStocks;
	}
	public void setNoofStocks(int noofStocks) {
		this.noofStocks = noofStocks;
	}
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
