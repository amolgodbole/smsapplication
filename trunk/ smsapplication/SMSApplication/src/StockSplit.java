
public class StockSplit extends StockDecorator{

	public StockSplit(StockItem stockItem) {
		super(stockItem);
		// TODO Auto-generated constructor stub
	}
	
	public void processSplitStock(Stock stockItem)
	{
		System.out.println("Before split");
		System.out.println("Number of stocks : " +stockItem.getNumberOfStocks());
		System.out.println("Price of stock : " +stockItem.getdStockPrice());
		int newNumberOfStocks = stockItem.getNumberOfStocks() * 2;
		double newPriceOfStocks = stockItem.getdStockPrice()/2;
		stockItem.setNumberOfStocks(newNumberOfStocks);
		stockItem.setdStockPrice(newPriceOfStocks);
		System.out.println("After split");
		System.out.println("Number of stocks : " +stockItem.getNumberOfStocks());
		System.out.println("Price of stock : " +stockItem.getdStockPrice());
		
		
	}

	
	/*void updateResult()
	{
		
	}*/
	
	public void display()
	{
		super.display();
	}

	/*@Override
	public void getStockListing() {
		// TODO Auto-generated method stub
		
	}
	
	*/

}
