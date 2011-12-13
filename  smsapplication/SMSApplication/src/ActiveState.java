import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;

public class ActiveState extends Thread implements OrderStateInterface
{
	
	private static ActiveState instance;

	private StockOrderInterface stockOrderInterface;
	boolean timeCheck = false;
	Listing stockListing = Listing.getInstance();
	List<Stock> allListedStocks = stockListing.getAllStocks();
	Investor buyer = null;
	Investor seller  = null;
	String threadChanger; 


	
	public String isThreadChanger() {
		return threadChanger;
	}

	public void setThreadChanger(String threadChanger) 
	{
		
			this.threadChanger = threadChanger;
	}
	
	
	public void stopMatching()
	{
		synchronized (allListedStocks) 
		{

				try {
					allListedStocks.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				
			}

		}
	}

	private ActiveState(StockOrderInterface stockOrderInterface)
	{
		this.stockOrderInterface = stockOrderInterface;
	}

	private ActiveState()
	{

	}
	
	public static ActiveState getInstance(StockOrderInterface stockOrderInterface)
	{
		if(instance == null)
		{
			instance = new ActiveState(stockOrderInterface);
		}
		return instance;
		
	}
	
	public static ActiveState getInstance()
	{
		if(instance == null)
		{
			instance = new ActiveState();
		}
		return instance;
	}

	public void updateResult() 
	{
		System.out.println("Update the result");
	}

	public void setState(ActiveState state) 
	{

	}

	@Override
	public String processInitializedOrder(OrderBean order) {

		return "False: This order needs to be in Active Order State";
	}

	@Override
	public String processActiveOrder(OrderBean order) 
	{
		
		return "true";
	}
	
	@Override

	
	public String processDeletedOrder(OrderBean order) {
	
		return "false: Incorrect process in Deleted Order This order needs to be in active order state";
	}

	@Override
	public String processCompletedOrder(OrderBean order) {
		
		return "false: Incorrect process in Completed Order This order needs to be in active order state";
	}
	
	

	@Override
	public String processOrder(OrderBean order) {
		

		System.out.println("Order in Active State !!");
		System.out.println("Orders will be Matched in this state as long as the Stock exchange is Open");
		System.out.println("order in process order");
		
		processMatching();
		
		
		stockOrderInterface.setState(stockOrderInterface.getCompletedState());
		System.out.println("Changed State Call method Active State to Waiting State !");
		stockOrderInterface.processOrder(order);
		
		return "true";
		
	}
	
	public void run()
	{
		processMatching();
	}
	
	public void processMatching()
	{
		
		System.out.println("In Process matching State !!");
		
		
		
		if(new ClockInstance1().checkTimevalidity())
		{	
			timeCheck = true;
		}else{
			System.out.println("System will work only between 9am to 4pm");
		}


		while(timeCheck) // check for time validity and for the synchronized request.
		{
			if(new ClockInstance1().checkTimevalidity()){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(this.threadChanger.equals("true")){
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println(" matching Queues !!");
				Iterator<Stock> stockIterator = allListedStocks.iterator();
				while(stockIterator.hasNext())
				{
					// this is to iterate over all the stocks
					Stock _stock = stockIterator.next();
					SortedMap<Double, OrderBean> buyQueue = _stock.getBuyQueue();
					SortedMap<Double, OrderBean> sellQueue = _stock.getSellQueue();

					/*
					 *   Match the stock prices of last Order in Buy Queue and 1st Order in Sell Queue;
					 *   As the orders are arranged by default in ascending order we need to match the max value from buyer and least value from seller.
					 *   For POC we will be matching only the values at the indexed last and 1st position of Buy and sell Queue respectively 
					 */
					System.out.println("Size of _stock: "+buyQueue.size());
					if(buyQueue.isEmpty()||sellQueue.isEmpty())
					{
						System.out.println("Buy queue or Sell Queue is Empty !!");
						this.timeCheck = false;
						System.out.println("To Display the Matched Results, Time is Invalidated: In Normal Process Next Stock match Will TakePlace ! To Change this just comment timeCheck assignment above this line...");
						continue;
					}
					Double buyStockPrice = buyQueue.lastKey();
					System.out.print("buy stock price: "+buyStockPrice);
					Double sellStockPrice = sellQueue.firstKey();
					System.out.print("Sell stock price: "+sellStockPrice);

					if(buyStockPrice.equals(sellStockPrice))
					{
						
						try {
							
							System.out.println("queues Matched for Stock: "+_stock.getStockname());
							Thread.sleep(5000);
							
						} catch (InterruptedException e) {
							
							e.printStackTrace();
						}
						System.out.println("queues Matched for Stock: "+_stock.getStockname());
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

						System.out.println("Number of Stocks in buy queue: "+noOfStocksInBuyQueue);
						System.out.println("Number of Stocks in sell queue: "+noOfStocksInSellQueue);

						String buyOrderInvestorId = buyStockOrder.getInvestorID();
						String sellOrderInvestorId = sellStockOrder.getInvestorID();		
						System.out.println("Buy Order Investor ID: "+buyOrderInvestorId);
						System.out.println("Sell Order Investor ID: "+sellOrderInvestorId);

						InvestorListing allInvestorList = InvestorListing.getinstance();
						List<Investor> investorList = allInvestorList.getAllInvestors();

						Iterator<Investor> investorIterator = investorList.iterator();

						// GET BUYER
						while(investorIterator.hasNext())
						{
							Investor buyerCheck = investorIterator.next();
							System.out.println("BuyerCheck Investor ID: "+buyerCheck.getInvestorID());
							System.out.println("Buy order Investor Id: "+buyOrderInvestorId);
							if(buyerCheck.getInvestorID().equalsIgnoreCase(buyOrderInvestorId))
							{
								buyer = buyerCheck;
								System.out.println("BuyerSet! :"+buyer.getInvestorID());
								break;
							}
							

						}

						// GET SELLER
						System.out.println("Get the seller ..");
						InvestorListing allInvestorList1 = InvestorListing.getinstance();
						List<Investor> investorList1 = allInvestorList1.getAllInvestors();
						Iterator<Investor> investorIterator1 = investorList1.iterator();
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
							}

						}

						
						// WHEN STOCKS IN BOTH QUEUES ARE EQUAL
						if(noOfStocksInBuyQueue == noOfStocksInSellQueue)
						{
							System.out.println("Enterred Complete Order match !!");
							
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
							seller.amountInAccount = seller.amountInAccount + (buyStockPrice * buyStockOrder.noOfStocks);
							
							System.out.println("Amount in buyer acount " +buyer.amountInAccount);
							System.out.println("Amount in Sellers acount " +seller.amountInAccount);
							
							_stock.buyQueue.remove(buyQueue.lastKey());
							System.out.println("Stock Removed from Buy Queue !");
							_stock.sellQueue.remove(sellQueue.firstKey());
							System.out.println("Stock Removed from Sell Queue !");

						}





						if(noOfStocksInBuyQueue < noOfStocksInSellQueue)
						{
							System.out.println("Number of Stocks in Sell Queue is Less Than Number Of Stocks in Buy Queue! ");
							
							//ECHANGE STOCKS
							//getting the stock from the seller and setting it in buyer's account
							Stock buyerStock = buyStockOrder.getStock();
							// adding the matched stock to the List of all stocks by the buyer
							buyer.getStocks().add(buyerStock);

							//Stock sellerStock = sellStockOrder.getStock();
							//seller.getStocks().remove(sellerStock);

							//EXCHANGE AMOUNT : Setting the value of amount from the order and not from Stock as we take the stock order value: ASK/BID amount

							System.out.println(" Buyer Initial Amount In Account:"+buyer.amountInAccount);
							System.out.println("Initial Amount In Seller Account: "+seller.amountInAccount);
							buyer.amountInAccount = buyer.amountInAccount - (buyStockPrice * noOfStocksInBuyQueue);
							seller.amountInAccount = seller.amountInAccount + (buyStockPrice * noOfStocksInBuyQueue);
							
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
							


						}
					}


				}
			}//end if loop of clock instance
			else{
				
				timeCheck = false;
			}
			

		}//end while
		


		//stockOrderInterface.setState(stockOrderInterface.));

		
		
	}


}
