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
		
		MutualFund mf = null;
		
		
		
		@Override
		public String processOrder(OrderBean order) 
		
		{
			allMFOrders.add(order);

			return mutualFundID;
			
		}
		
		public void listMutualFund()
		{
			
			
			
			
		}
		
		public String processMutualFundOrder(MutualFund mf,Investor investor)
		{
			Investor mfCompany = new Investor();
				MutualFund mfOrder = mf;
				int totalMF = mfOrder.getNoofStocks();
				String mfId = mfOrder.getMutualFundID();
				double price=0;
				
				for (int i=0;i<Listing.getInstance().getAllStocks().size();i++)
				{
				price=Listing.getInstance().getAllStocks().get(i).getdStockPrice();
				price=price+(price*0.0025);
				Listing.getInstance().getAllStocks().get(i).setdStockPrice(price);
				price=0;
				} 
				double nav=calculate_NAV(mf);
				
				  mfCompany.setInvestorID("INV000009");
				  mfCompany.setAmountInAccount(10000);
				  
				  //buyer=mfCompany;
				  
				  investor.amountInAccount = investor.amountInAccount - (mf.getMutualFundPrice() *  totalMF);
				  mfCompany.amountInAccount = mfCompany.amountInAccount + (mf.getMutualFundPrice() *  totalMF);
			
				  System.out.println("Balance in investors acocunt:"+investor.amountInAccount);
				  System.out.println("Balance in MFCompany account:"+investor.amountInAccount);
			return "MF Orders Processed!";
		}
		

		public double calculate_NAV(MutualFund mf)
		{
			int stock_count=0;
			double mf_nav=0;
			
			for (int i=0;i<mf.stocks.size();i++)
			{
				mf_nav=mf_nav+ (mf.stocks.get(i).dStockPrice*mf.stocks.get(i).numberOfStocks);
				stock_count=stock_count+mf.stocks.get(i).numberOfStocks;
			}
			mf_nav=mf_nav/stock_count;
			return mf_nav;
		}
}
