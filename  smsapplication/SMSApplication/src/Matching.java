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
				
				  
				  
				  
				  Double buyStockPrice = buyQueue.lastKey();
				  Double sellStockPrice = sellQueue.firstKey();
				  
				  if(buyStockPrice.equals(sellStockPrice))
				  {
					  OrderBean buyStockOrder = buyQueue.get(buyStockPrice);
					  OrderBean sellStockOrder = sellQueue.get(sellStockPrice);
					  
					  int noOfStocksInBuyQueue = buyStockOrder.getNoOfStocks();
					  int noOfStocksInSellQueue = sellStockOrder.getNoOfStocks();
					  
					  
					  
					  
					  // WHEN STOCKS IN BOTH QUEUES ARE EQUAL
					  
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
						  String sellOrderInvestorId = sellStockOrder.getInvestorID();
						  
						  InvestorListing allInvestorList = new InvestorListing();
						  List<Investor> investorList = allInvestorList.getAllInvestors(); 
						  
						  Iterator<Investor> investorIterator = investorList.iterator();
						  //Change the no of stocks in seller Queue
						  
						  noOfStocksInSellQueue = noOfStocksInSellQueue - noOfStocksInBuyQueue;
						  
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
						  List<Stock> stocksInInvestorAccount = seller.getStocks();
						  Iterator<Stock> sellerStockIterator = stocksInInvestorAccount.iterator();
						  
						  while(sellerStockIterator.hasNext())
						  {
							  Stock getStock = sellerStockIterator.next();
							  if(_stock.equals(getStock))
							  {
								   getStock.setNumberOfStocks(noOfStocksInSellQueue);
							  }
							  
							  
						  }
						 //ECHANGE STOCKS
						  //getting the stock from the seller and setting it in buyer's account
						  Stock buyerStock = buyStockOrder.getStock();
						  // adding the matched stock to the List of all stocks by the buyer
						  buyer.getStocks().add(buyerStock);
						  
						  //Stock sellerStock = sellStockOrder.getStock();
						  //seller.getStocks().remove(sellerStock);
						  
						  //EXCHANGE AMOUNT : Setting the value of amount from the order and not from Stock as we take the stock order value: ASK/BID amount
						  
						  buyer.amountInAccount = buyer.amountInAccount - (buyerStock.getdStockPrice() * buyStockOrder.noOfStocks);
						  seller.amountInAccount = seller.amountInAccount + (buyerStock.getdStockPrice() * buyStockOrder.noOfStocks);
						  
						  
						  
						  
						  
						  String sellOrderId = sellStockOrder.getStrOrderID();
						  String newSellOrderHistoryId = sellOrderId.substring(19);
						  System.out.println("Order History ID: " +newSellOrderHistoryId);
						  int historyIdIncrement = Integer.parseInt(newSellOrderHistoryId);
						  historyIdIncrement++;
						  String histId = Integer.toString(historyIdIncrement);
						  sellOrderId = sellOrderId.substring(0, 18);
						  
						  sellOrderId = sellOrderId.concat(histId);
						  
						  sellStockOrder.setStrOrderID(sellOrderId);
						  
						  
					  }
					  
					  if(noOfStocksInBuyQueue > noOfStocksInSellQueue)
					  {
						  String sellOrderInvestorId = sellStockOrder.getInvestorID();
						  String buyOrderInvestorId = buyStockOrder.getInvestorID();
						  
						  String buyOrderId = buyStockOrder.getStrOrderID(); 
						  InvestorListing allInvestorList = new InvestorListing();
						  List<Investor> investorList = allInvestorList.getAllInvestors(); 
						  
						  Iterator<Investor> investorIterator = investorList.iterator();
						  
						  noOfStocksInBuyQueue = noOfStocksInBuyQueue - noOfStocksInSellQueue;
						  
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
						  List<Stock> stocksInInvestorAccount = buyer.getStocks();
						  Iterator<Stock> buyerStockIterator = stocksInInvestorAccount.iterator();
						  
						  while(buyerStockIterator.hasNext())
						  {
							  Stock getStock = buyerStockIterator.next();
							  if(_stock.equals(getStock))
							  {
								   getStock.setNumberOfStocks(noOfStocksInBuyQueue);
							  }
							  
							  
						  }
						 //ECHANGE STOCKS
						  //getting the stock from the seller and setting it in buyer's account
						  Stock sellerStock = sellStockOrder.getStock();
						  // adding the matched stock to the List of all stocks by the buyer
						  seller.getStocks().add(sellerStock);
						  
						  
						  
						  buyer.amountInAccount = buyer.amountInAccount - (sellerStock.getdStockPrice() * sellStockOrder.noOfStocks);
						  seller.amountInAccount = seller.amountInAccount + (sellerStock.getdStockPrice() * sellStockOrder.noOfStocks);
						  
						  
						  // Change the order ID
						  
						  
						  String buyOrderId1 = buyStockOrder.getStrOrderID();
						  String newBuyOrderHistoryId = buyOrderId1.substring(19);
						  System.out.println("Order History ID: " +newBuyOrderHistoryId);
						  int historyIdIncrement = Integer.parseInt(newBuyOrderHistoryId);
						  historyIdIncrement++;
						  String histId = Integer.toString(historyIdIncrement);
						  buyOrderId1 = buyOrderId1.substring(0, 18);
						  
						  buyOrderId1 = buyOrderId1.concat(histId);
						  buyStockOrder.setStockID(buyOrderId1);
						  
						  
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
