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
		
		//Db for mutual funds
		//List<MutualFund> allmutualfunds=new ArrayList<MutualFund>();
		
		MutualFund mf = null;
		
		
		
		@Override
		public String processOrder(OrderBean order) 
		
		{
			allMFOrders.add(order);

			return mutualFundID;
			
		}
		
		public String processMutualFundOrder(MutualFund mf,Investor investor)
		{
			Investor mfCompany = new Investor();
				MutualFund mfOrder = mf;
				int totalMF = mfOrder.getNoofStocks();
				String mfId = mfOrder.getMutualFundID();
				
				String buyOrderInvestorId = mfOrder.getInvestorID();
				
				InvestorListing allInvestorList = InvestorListing.getinstance();
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
				  
				
				/*  while(investorIterator.hasNext())
				  {
					  Investor sellerCheck = investorIterator.next();
					  if(sellerCheck.getInvestorID().equalsIgnoreCase("MF01"))
					  {
						  mfCompany = sellerCheck;
						  mf = (MutualFund) mfCompany;
					  }
					  
				  }*/
				  
				  
				  mfCompany.setInvestorID("INV000009");
				  mfCompany.setAmountInAccount(10000);
				  
				  //buyer=mfCompany;
				  
				  investor.amountInAccount = investor.amountInAccount - (mf.getMutualFundPrice() *  totalMF);
				  mfCompany.amountInAccount = mfCompany.amountInAccount + (mf.getMutualFundPrice() *  totalMF);
			
			
			return "MF Orders Processed!";
		}
		

		public double calculate_NAV(MutualFund mf)
		{
			List<Stock> listofstocks=mf.getStocks();
			int length=listofstocks.size();
			int stock_count=0;
			double mf_nav=0;
			double stock_price=0;
			
			for (int i=0;i<length;i++)
			{
				//get the particular stock and get the price
				
				Stock stock=listofstocks.get(i);
				stock_price=stock_price+stock.dStockPrice;
				stock_count++;
			}
			mf_nav=stock_price/stock_count;
			return mf_nav;
		}
}
