import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


public class Matching implements ActiveStatesInterface, Runnable	
{ 
    private ActiveOrderStateInterface activeOrderStateInterface;
	
	public Matching(ActiveOrderStateInterface a)
	{
		activeOrderStateInterface=a;
	}
	


	@Override
	public String processMatching() {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public String updateResult() {
		return null;
		// TODO Auto-generated method stub
		
	}



	//@SuppressWarnings("static-access")
	@Override
	public String processMatchingOrder(OrderBean order, StockOrderInterface stockOrderInterface) {
		System.out.println("In Matching");
		
		//Logic of Matching
		boolean timeCheck = false;
		
		
		Listing stockListing = new Listing();
		List<Stock> allListedStocks = stockListing.getAllStocks();
		Investor buyer = null;
		Investor seller  = null;
		
		int noOfStocks = allListedStocks.size();
		
		//SortedMap<Double, OrderBean> map = new TreeMap<Double, OrderBean>();
		
		//THREAD
		if(new ClockInstance1().checkTimevalidity())
		{
			timeCheck = true;
		}
		
		while(timeCheck) // check for time validity and for the synchronized request.
		{
			Iterator<Stock> stockIterator = allListedStocks.iterator();
			while(stockIterator.hasNext())
			{
				
				
				Stock _stock = stockIterator.next();
				SortedMap<Double, OrderBean> buyQueue = _stock.getBuyQueue();
				SortedMap<Double, OrderBean> sellQueue = _stock.getSellQueue();
				
				//Iterator iterator = map.keySet().iterator();
				
				  
				  
				  
				  Double buyStockPrice = buyQueue.firstKey();
				  Double sellStockPrice = sellQueue.firstKey();
				  
				  if(buyStockPrice.equals(sellStockPrice))
				  {
					  OrderBean buyStockOrder = buyQueue.get(buyStockPrice);
					  OrderBean sellStockOrder = sellQueue.get(sellStockPrice);
					  
					  int noOfStocksInBuyQueue = buyStockOrder.getNoOfStocks();
					  int noOfStocksInSellQueue = sellStockOrder.getNoOfStocks();
					  
					  if(noOfStocksInBuyQueue == noOfStocksInSellQueue)
					  {
						  String buyOrderInvestorId = buyStockOrder.getInvestorID();
						  String sellOrderInvestorId = sellStockOrder.getInvestorID();
						  
						  InvestorListing allInvestorList = new InvestorListing();
						  List<Investor> investorList = allInvestorList.getAllInvestors();
						  
						  Iterator<Investor> investorIterator = investorList.iterator();
						  
						  // GET BUYER
						  while(investorIterator.hasNext())
						  {
							  Investor buyerCheck = investorIterator.next();
							  if(buyerCheck.getInvestorID().equalsIgnoreCase(buyOrderInvestorId))
							  {
								  buyer = buyerCheck;
							  }
							   
							  
						  }
						  
						  // GET SELLER
						  
						  while(investorIterator.hasNext())
						  {
							  Investor sellerCheck = investorIterator.next();
							  if(sellerCheck.getInvestorID().equalsIgnoreCase(sellOrderInvestorId))
							  {
								   seller = sellerCheck;
							  }
							  
						  }
						  
						 //ECHANGE STOCKS
						  //getting the stock from the seller and setting it in buyer's account
						  Stock buyerStock = sellStockOrder.getStock();
						  // adding the matched stock to the List of all stocks by the buyer
						  buyer.getStocks().add(buyerStock);
						  
						  Stock sellerStock = sellStockOrder.getStock();
						  seller.getStocks().remove(sellerStock);
						  
						  //EXCHANGE AMOUNT : Setting the value of amount from the order and not from Stock as we take the stock order value: ASK/BID amount
						  
						  buyer.amountInAccount = buyer.amountInAccount - (sellerStock.getdStockPrice() * sellStockOrder.noOfStocks);
						  seller.amountInAccount = seller.amountInAccount + (sellerStock.getdStockPrice() * sellStockOrder.noOfStocks);
						  
						  
						  
					  }
					  
					  
					  
					  
					  
					  if(noOfStocksInBuyQueue < noOfStocksInSellQueue)
					  {
						  String buyOrderInvestorId = buyStockOrder.getInvestorID();
						  
						  String sellOrderId = sellStockOrder.getStrOrderID();
						  
						  noOfStocksInSellQueue = noOfStocksInSellQueue - noOfStocksInBuyQueue;
						  
						  
					  }
					  
					  if(noOfStocksInBuyQueue > noOfStocksInSellQueue)
					  {
						  String sellOrderInvestorId = sellStockOrder.getInvestorID();
						  
						  String buyOrderId = buyStockOrder.getStrOrderID(); 
						  noOfStocksInBuyQueue = noOfStocksInBuyQueue - noOfStocksInSellQueue;
						  
						  
						  
					  }
				  }
				  
				
			}
		
		}
		//logic to call Matched 
		//activeOrderStateInterface.setStates(activeOrderStateInterface.getMatched(stockOrderInterface));
		return null;
	}







	@Override
	public String processWaitingOrder(OrderBean order,
			StockOrderInterface stockOrderInterface) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String processMatchedOrder(OrderBean order,StockOrderInterface stockOrder) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
