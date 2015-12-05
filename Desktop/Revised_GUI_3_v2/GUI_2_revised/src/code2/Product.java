package code2;
public class Product {
	private  String productID;
	private  String name;
	private double price;
	private double weight;
	private static int currNumStock;
	private static boolean restock;
	private static int numProducts;
	private static int numRestocks;

	public Product() {
		this.currNumStock = 0;
		this.name = "";
		this.price = 0.0;
		this.productID = "";
		this.weight = 0.0;
		this.restock = true;
		this.numProducts = 0;
		this.numRestocks = 5;
	}

	public Product(String name, double weight, double price, int currNumStock,int numReStocks) {
		this.name = name;
		this.price = price;
		this.weight = weight;
		this.currNumStock = currNumStock;
		this.numRestocks = numReStocks;
		
	}
	public static void withdrawStock(int num){
		currNumStock -= num;
	}
	public static void restock(){
		if(currNumStock<3){
			setRestock(true);
		}else{
			setRestock(false);
		}
	}
	@Override
	public  String toString(){
		
		return String.format("%s, %.3f, %.2f, %d, %d",this.getName(),this.getWeight(),this.getPrice(),this.getCurrNumStock(),this.getNumRestocks()+"\n");
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public static int getCurrNumStock() {
		return currNumStock;
	}

	public void setCurrNumStock(int currNumStock) {
		this.currNumStock = currNumStock;
	}

	public static boolean isRestock() {
		return restock;
	}

	public  static void setRestock(boolean restock) {
		restock = restock;
	}

	public static int getNumProducts() {
		return numProducts;
	}

	public static void setNumProducts(int numProducts) {
		Product.numProducts = numProducts;
	}

	public static int getNumRestocks() {
		return numRestocks;
	}

	public static void setNumRestocks(int numRestocks) {
		Product.numRestocks = numRestocks;
	}

}
