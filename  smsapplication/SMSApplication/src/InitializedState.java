import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;


public class InitializedState implements OrderStateInterface
{
	private StockOrderInterface stockOrderInterface;

	List<OrderBean> initializedOrders = new ArrayList<OrderBean>();
	List<Stock> allStocks = Listing.getInstance().getAllStocks();
	Stock stock = null;

	ClockInstance1 clock=new ClockInstance1();

	InitializedState(StockOrderInterface stockOrderInterface)
	{
		this.stockOrderInterface = stockOrderInterface;
	}


	public InitializedState() {
		
	}

	public void updateResult() {
		
		stockOrderInterface.setState(stockOrderInterface.getCompletedState());	
	}

	
	@Override
	public String  processInitializedOrder(OrderBean order) 
	{
		return null;

	}

	public void processChangeStateAtValidTime(boolean validity)
	{
		while(validity)
		{
			Iterator<OrderBean> orderIterator = initializedOrders.iterator();

			while(orderIterator.hasNext())
			{
				OrderBean order = orderIterator.next();
				processInitializedOrder(order);
			}
		}
	}

	@Override
	public String processActiveOrder(OrderBean order) {
		return "false: Incorrect process in Active Order! Will enter Active State at valid Time";
		

	}

	@Override
	public String processDeletedOrder(OrderBean order) {
		return "false: Incorrect process in Deleted Order! Will enter Deleted State after Order Complete";
		

	}

	@Override
	public String processCompletedOrder(OrderBean order) 
	{
		return "false: Incorrect process in Complete Order! Order Needs to be completed first";

	}


	@SuppressWarnings("deprecation")
	@Override
	public String processOrder(OrderBean order) {
		
		//System.out.println("In process order of Initialized state");



		System.out.println("Order Initialized !!");
		if(order.equals(null))
		{
			System.out.println("Order is Null");
		}
		if(clock.checkTimevalidity())
		{

			OrderBean orderInInitializedState = order;
			String stockIdInOrder = orderInInitializedState.getStockID();
			Iterator<Stock> allStockIterator = allStocks.iterator();

			while(allStockIterator.hasNext())
			{
				Stock stockInIter = allStockIterator.next();
				if( stockInIter.getStockid().equals(stockIdInOrder))
				{
					this.stock = stockInIter;
					System.out.println("Stock is : "+this.stock.getStockname());
				}
			}
	
			
			/*if(order.isMarketOrderFlag())
			{
				System.out.println("Order Type is Market Order");
				
				if(order.getOrderProcessType().equalsIgnoreCase("Buy_Orders"))
				{
					Stock stockToBeBought = null;
					String stockIDInOrder = order.getStockID();
					Listing stockListing = Listing.getInstance();
					List<Stock> allListedStocks = stockListing.getAllStocks();
					Iterator<Stock> stockIterator = allListedStocks.iterator();
					while(stockIterator.hasNext())
					{
						// this is to iterate over all the stocks
						Stock _stock = stockIterator.next();

						if(_stock.getStockid().equals(stockIDInOrder))
						{
							int noOfStocksInBuyQueue = order.getNoOfStocks();
							
							
							while(noOfStocksInBuyQueue != 0)
							{
								SortedMap<Double, OrderBean> sellQueue = _stock.getSellQueue();
								Double sellStockPrice = sellQueue.lastKey();
								
								OrderBean sellStockOrder = sellQueue.get(sellStockPrice);
								int noOfStocksInSellQueue = sellStockOrder.getNoOfStocks();
								
								String buyOrderInvestorId = order.getInvestorID();
								String sellOrderInvestorId = sellStockOrder.getInvestorID();		
								System.out.println("Buy Order Investor ID: "+buyOrderInvestorId);
								System.out.println("Sell Order Investor ID: "+sellOrderInvestorId);
								
								InvestorListing allInvestorList = InvestorListing.getinstance();
								List<Investor> investorList = allInvestorList.getAllInvestors();
								
								Investor seller = null;
								Investor buyer = null;
								
								Iterator<Investor> investorIterator1 = investorList.iterator();
								
								while(investorIterator1.hasNext())
								{
									Investor sellerCheck = investorIterator1.next();
									System.out.println("SellerCheck Investor ID: "+sellerCheck.getInvestorID());
									System.out.println("Sell order Investor Id: "+sellOrderInvestorId);
									if(sellerCheck.getInvestorID().equalsIgnoreCase(sellOrderInvestorId))
									{
										seller = sellerCheck;
										System.out.println("Seller Set! : "+seller.getInvestorID());
										break;
									}// close if
	
								}//close while for seller iteration
								

								Iterator<Investor> investorIterator = investorList.iterator();

								// GET BUYER
								while(investorIterator.hasNext())
								{
									Investor buyerCheck = investorIterator.next();
									System.out.println("BuyerCheck Investor ID: "+buyerCheck.getInvestorID());
									if(buyerCheck.getInvestorID().equalsIgnoreCase(buyOrderInvestorId))
									{
										buyer = buyerCheck;
										System.out.println("BuyerSet! :"+buyer.getInvestorID());
										break;
									}


								}//close while for buyer 
								
								
								// WHEN STOCKS IN BOTH QUEUES ARE EQUAL
								if(noOfStocksInBuyQueue == noOfStocksInSellQueue)
								{
									System.out.println("Entered Complete Order match !!");

									//ECHANGE STOCKS
									//getting the stock from the seller and setting it in buyer's account
									Stock buyerStock = sellStockOrder.getStock();
									// adding the matched stock to the List of all stocks by the buyer
									buyer.stocks.add(buyerStock);
									System.out.println("Buyer Stocks added");

									Stock sellerStock = sellStockOrder.getStock();
									seller.stocks.remove(sellerStock);
									System.out.println("Seller stocks sold");

									//EXCHANGE AMOUNT : Setting the value of amount from the order and not from Stock as we take the stock order value: ASK/BID amount
									System.out.println(" Buyer Initial Amount In Account:"+buyer.amountInAccount);
									System.out.println("Number of Stocks in Seller Order: "+sellStockOrder.noOfStocks);
									System.out.println("Seller Stock Order Amount "+sellerStock.getdStockPrice());
									System.out.println("Seller Stock Order Amount "+sellStockPrice);
									buyer.amountInAccount = buyer.amountInAccount - (sellStockPrice * sellStockOrder.noOfStocks);
									seller.amountInAccount = seller.amountInAccount + (sellStockPrice * sellStockOrder.noOfStocks);
									buyer.setAmountInAccount(buyer.amountInAccount);
									seller.setAmountInAccount(seller.amountInAccount);

									System.out.println("Amount in buyer acount " +buyer.amountInAccount);
									System.out.println("Amount in Sellers acount " +seller.amountInAccount);

									
									_stock.sellQueue.remove(sellQueue.firstKey());
									System.out.println("Stock Removed from Sell Queue !");

									noOfStocksInBuyQueue  = 0;
									noOfStocksInSellQueue = 0;

									
									sellStockOrder = null;


									stockOrderInterface.setState(stockOrderInterface.getCompletedState());

								}





								if(noOfStocksInBuyQueue < noOfStocksInSellQueue)
								{
									System.out.println("Number of Stocks in Sell Queue is Less Than Number Of Stocks in Buy Queue! ");

									//ECHANGE STOCKS
									//getting the stock from the seller and setting it in buyer's account
									Stock buyerStock = buyStockOrder.getStock();
									// adding the matched stock to the List of all stocks by the buyer
									buyer.getStocks().add(sellerStock);

									//Stock sellerStock = sellStockOrder.getStock();
									//seller.getStocks().remove(sellerStock);

									//EXCHANGE AMOUNT : Setting the value of amount from the order and not from Stock as we take the stock order value: ASK/BID amount

									System.out.println(" Buyer Initial Amount In Account:"+buyer.amountInAccount);
									System.out.println("Initial Amount In Seller Account: "+seller.amountInAccount);
									buyer.amountInAccount = buyer.amountInAccount - (buyStockPrice * noOfStocksInBuyQueue);
									seller.amountInAccount = seller.amountInAccount + (buyStockPrice * noOfStocksInBuyQueue);

									buyer.setAmountInAccount(buyer.amountInAccount);
									seller.setAmountInAccount(seller.amountInAccount);

									System.out.println("Amount in buyer acount " +buyer.amountInAccount);
									System.out.println("Amount in Seller Account "+seller.amountInAccount);


									String sellOrderId = sellStockOrder.getStrOrderID();
									System.out.println("Seller Order Id: "+sellOrderId);


									String newSellOrderHistoryId = sellOrderId.substring(0, 2);
									System.out.println("Order History ID: " +newSellOrderHistoryId);

									int historyIdIncrement = Integer.parseInt(newSellOrderHistoryId);
									historyIdIncrement++;
									String histId = Integer.toString(historyIdIncrement);
									System.out.println("History ID: "+histId);

									sellOrderId = sellOrderId.substring(0,6);
									System.out.println("UnConcatinated Sell Order Id: "+sellOrderId);
									sellOrderId = sellOrderId.concat(histId);

									System.out.println("New Sell Order Id: "+sellOrderId);

									sellStockOrder.setStrOrderID(sellOrderId);

									_stock.buyQueue.remove(buyQueue.lastKey());
									System.out.println("Stock Removed from Buy Queue !");

									noOfStocksInBuyQueue = 0;
									noOfStocksInSellQueue =0;
									buyer = null;
									seller = null;


									stockOrderInterface.setState(stockOrderInterface.getCompletedState());


								}

								if(noOfStocksInBuyQueue > noOfStocksInSellQueue)
								{

									//ECHANGE STOCKS
									//getting the stock from the seller and setting it in buyer's account
									Stock sellerStock = sellStockOrder.getStock();
									// adding the matched stock to the List of all stocks by the buyer
									seller.getStocks().add(sellerStock);



									System.out.println(" Buyer Initial Amount In Account:"+buyer.amountInAccount);
									System.out.println("Initial Amount In Seller Account: "+seller.amountInAccount);
									buyer.amountInAccount = buyer.amountInAccount - (sellStockPrice * noOfStocksInSellQueue);
									seller.amountInAccount = seller.amountInAccount + (sellStockPrice * noOfStocksInSellQueue);

									buyer.setAmountInAccount(buyer.amountInAccount);
									seller.setAmountInAccount(seller.amountInAccount);


									System.out.println("Amount in buyer acount " +buyer.amountInAccount);
									System.out.println("Amount in Seller Account "+seller.amountInAccount);

									// Change the order ID


									String buyOrderId1 = buyStockOrder.getStrOrderID();
									String newBuyOrderHistoryId = buyOrderId1.substring(1, 7);
									System.out.println("Order History ID: " +newBuyOrderHistoryId);
									int newRandomValue = new Random().nextInt(9999999);
									String orderAppender = Integer.toString(newRandomValue);

									String newBuyOrderID = ("O" +orderAppender);
									System.out.println("New Buy Order Id: "+newBuyOrderID);


									_stock.sellQueue.remove(buyQueue.firstKey());
									System.out.println("Stock Removed from Sell Queue !");

									int newNoOfStocksInBuyQueue = noOfStocksInBuyQueue - noOfStocksInSellQueue;
									buyStockOrder.setNoOfStocks(newNoOfStocksInBuyQueue);
									buyStockOrder.setStrOrderID(newBuyOrderID);

									_stock.buyQueue.remove(buyQueue.lastKey());
									System.out.println("Initial Order Removed");

									_stock.buyQueue.put(buyStockPrice, buyStockOrder);

									System.out.println("New Stock Order Placed In Queue !");

									noOfStocksInBuyQueue = 0;
									noOfStocksInSellQueue =0;
									buyer = null;
									seller = null;

									stockOrderInterface.setState(stockOrderInterface.getCompletedState());


								}
								
							}
						}
						
						
					}

					
				}
				
				
			}
			*/
			//else
		 if(! order.isMarketOrderFlag())
			{
				if(order.getOrderProcessType().equalsIgnoreCase("Buy_Orders"))
				{

					Double bidAmount = (Double) order.getBidAmount();
					System.out.println("Bid Amount: "+bidAmount);
					//System.out.println("Order Id: " +order.getStrOrderID());


					ActiveState as = ActiveState.getInstance();
					as.setThreadChanger("true");
					//System.out.println("Before Insert!"+System.currentTimeMillis());
					this.stock.buyQueue.put(bidAmount, order);
					//System.out.println("After Insert!"+System.currentTimeMillis());
					as.setThreadChanger("false");


					Double d = this.stock.buyQueue.lastKey();
					//System.out.println("Buy Queue last Key: "+d);
					System.out.println("order placed in Buy Queue of Stock with Stock id: "+ this.stock.getStockid());

				}
				else if(order.getOrderProcessType().equalsIgnoreCase("Sell_Orders"))
				{
					Double askAmount = (Double) order.getAskAmount();

					this.stock.sellQueue.put(askAmount, order);
					System.out.println("order placed in Sell Queue of Stock with Stock id: "+ this.stock.getStockid());
					//stockOrderInterface.processOrder(order);
				}
				
			}

			

			stockOrderInterface.setState(stockOrderInterface.getActiveState());
			System.out.println("Changed State Call method InitializedOrder to ActiveOrder !");
			stockOrderInterface.processOrder(order);
			//st.setState(st.getActiveState());
			//System.out.println("Changed State Call method InitializedOrder to ActiveOrder !");
			return "true: Changed State Call method InitializedOrder to ActiveOrder ";
		}
		else
		{
			initializedOrders.add(order);
			return "true: Order Initialized and is waiting for time to be valid";
		}


	}

}
