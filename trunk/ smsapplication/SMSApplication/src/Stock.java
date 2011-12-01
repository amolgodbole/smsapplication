
public  class Stock
{
	void processRequestType(int requestType){
		
		
		if(requestType==1){
			
			System.out.println("Creating stock listings ");
			
			Listing ls = new Listing();
			
			StockBean sb1 = new StockBean();
			sb1.setStrCompanyID("App");
			sb1.setStrCompanyName("Apple");
			sb1.setStockname("Buyer&sellers");
			sb1.setStockid("App-01");
			sb1.setdStockPrice(400);
			sb1.setTotalNoStocks(100);
			ls.addToList(sb1);
			
			StockBean sb = new StockBean();
			sb.setStrCompanyID("Ora");
			sb.setStrCompanyName("Oracle");
			sb.setStockname("B&s");
			sb.setStockid("Ora-01");
			sb.setdStockPrice(40);
			sb.setTotalNoStocks(1000);			
			ls.addToList(sb);
			
			StockBean sb2 = new StockBean();
			sb2.setStrCompanyID("TCS");
			sb2.setStrCompanyName("TCS");
			sb2.setStockname("TCS");
			sb2.setStockid("Tcs-01");
			sb2.setdStockPrice(140);
			sb2.setTotalNoStocks(1006);			
			ls.addToList(sb2);
			
			

			
			
		}
			
		if(requestType==2){
			
			System.out.println("Creating split stock listings ");
		
			System.out.println("Split details:");
			
			System.out.println("Split price : 20");
			System.out.println("Split stock count  : 2000");
			
			
		}
	}
}
