import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

public class ActiveState implements OrderStateInterface
{

	private StockOrderInterface stockOrderInterface;
	boolean timeCheck = false;
	Listing stockListing = new Listing();
	List<Stock> allListedStocks = stockListing.getAllStocks();
	Investor buyer = null;
	Investor seller  = null;


	public ActiveState(StockOrderInterface stockOrderInterface)
	{
		this.stockOrderInterface = stockOrderInterface;

	}

	public ActiveState()
	{

	}


	public void updateResult() {
		// TODO Auto-generated method stub
		System.out.println("Update the result");
	}



	public void setState(ActiveState state) {
		// TODO Auto-generated method stub

	}

	@Override
	public String processInitializedOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return "False: This order needs to be in Active Order State";
	}

	@Override
	public String processActiveOrder(OrderBean order) 
	{
		System.out.println("Order in Active State !!");
		System.out.println("Orders will be Matched in this state as long as the Stock exchange is Open");

		if(new ClockInstance1().checkTimevalidity())
		{
			timeCheck = true;
		}


		while(timeCheck) // check for time validity and for the synchronized request.
		{
			Iterator<Stock> stockIterator = allListedStocks.iterator();
			while(stockIterator.hasNext())
			{
				// this is to iterate over all the stocks
				Stock _stock = stockIterator.next();
				SortedMap<Double, OrderBean> buyQueue = _stock.getBuyQueue();
				SortedMap<Double, OrderBean> sellQueue = _stock.getSellQueue();

				//Iterator iterator = map.keySet().iterator();



				/*
				 *  Match the stock prices of last Order in Buy Queue and 1st Order in Sell Queue;
				 *   As the orders are arranged by default in ascending order we need to match the max value from buyer and least value from seller.
				 *   For POC we will be matching only the values at the indexed last and 1st position of Buy and sell Queue respectively 
				 */

				Double buyStockPrice = buyQueue.lastKey();
				Double sellStockPrice = sellQueue.firstKey();

				if(buyStockPrice.equals(sellStockPrice))
				{
					/*
					 * Get the orders in both queues where the price of bid = ask
					 */
					OrderBean buyStockOrder = buyQueue.get(buyStockPrice);
					OrderBean sellStockOrder = sellQueue.get(sellStockPrice);

					/*
					 * Get the number of stocks in each order
					 */
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
						seller.amountInAccount = seller.amountInAccount + (buyerStock.getdStockPrice() * buyStockOrder.noOfStocks);



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
						String newSellOrderHistoryId = sellOrderId.substring(21);
						System.out.println("Order History ID: " +newSellOrderHistoryId);
						int historyIdIncrement = Integer.parseInt(newSellOrderHistoryId);
						historyIdIncrement++;
						String histId = Integer.toString(historyIdIncrement);
						sellOrderId = sellOrderId.substring(0, 20);

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
						String newBuyOrderHistoryId = buyOrderId1.substring(21);
						System.out.println("Order History ID: " +newBuyOrderHistoryId);
						int historyIdIncrement = Integer.parseInt(newBuyOrderHistoryId);
						historyIdIncrement++;
						String histId = Integer.toString(historyIdIncrement);
						buyOrderId1 = buyOrderId1.substring(0, 20);

						buyOrderId1 = buyOrderId1.concat(histId);
						buyStockOrder.setStockID(buyOrderId1);


					}
				}


			}

		}
		
		//stockOrderInterface.setState(stockOrderInterface.));
		
		return "true";
	}
	@Override
	public String processDeletedOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return "false: Incorrect process in Deleted Order This order needs to be in active order state";
	}

	@Override
	public String processCompletedOrder(OrderBean order) {
		// TODO Auto-generated method stub
		return "false: Incorrect process in Completed Order This order needs to be in active order state";
	}







}
