import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MutualFundOrder extends  OrderTMAAbstractClass
{

		int orderID=0;
		String mutualFundID="";
		double mutualFundPrice;
		List<OrderBean> allMFOrders = new ArrayList<OrderBean>();
		Investor buyer = null;
		Investor mfCompany = null;
		MutualFund mf = null;
		
		@Override
		public String processOrder(OrderBean order) 
		
		{
			allMFOrders.add(order);

			return mutualFundID;
			
		}
		
		public String processMutualFundOrder()
		{
			Iterator<OrderBean> mfIterator = allMFOrders.iterator();
			while(mfIterator.hasNext())
			{
				OrderBean mfOrder = mfIterator.next();
				int totalMF = mfOrder.getNoOfStocks();
				String mfId = mfOrder.getMutualFundID();
				
				String buyOrderInvestorId = mfOrder.getInvestorID();
				
				InvestorListing allInvestorList = new InvestorListing();
				  List<Investor> investorList = allInvestorList.getAllInvestors();
				  
				  Iterator<Investor> investorIterator = investorList.iterator();
				  while(investorIterator.hasNext())
				  {
					  Investor buyerCheck = investorIterator.next();
					  if(buyerCheck.getInvestorID().equalsIgnoreCase(buyOrderInvestorId))
					  {
						  buyer = buyerCheck;
					  }
				  }
				  
				  while(investorIterator.hasNext())
				  {
					  Investor sellerCheck = investorIterator.next();
					  if(sellerCheck.getInvestorID().equalsIgnoreCase(mfId))
					  {
						  mfCompany = sellerCheck;
						  mf = (MutualFund) mfCompany;
					  }
					  
				  }
				  
				  
				  buyer.amountInAccount = buyer.amountInAccount - (mf.getMutualFundPrice() *  totalMF);
				  mfCompany.amountInAccount = mfCompany.amountInAccount + (mf.getMutualFundPrice() *  totalMF);
			}
			
			return "MF Orders Processed!";
		}
		
	
}
