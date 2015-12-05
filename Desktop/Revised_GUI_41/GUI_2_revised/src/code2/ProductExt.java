package code2;
import java.util.*;

public class ProductExt extends Product {
	private String color;
	private String size;
	private double buyingPrice;

	public String getColor(){
		return this.color;
	}
	public String getSize(){
		return this.size;
	}
	public ProductExt() {
        super();
        this.color = "";
    	this.size = "";
    	this.buyingPrice = 0.0;
	}
    public ProductExt(String name,double weight,double price,int currNumStock,int numReStocks ,String color,String size,double buyingPrice){
    	super(name, weight, price, currNumStock, numReStocks);
    	this.color = color;
    	this.size = size;
    	this.buyingPrice = buyingPrice;
    
    }
	public  ProductExt clone(){
		ProductExt productExt_1= new ProductExt();
		return productExt_1;
	}
	public double restockProductExt(){
		super.restock();
		return this.getNumRestocks()*this.buyingPrice;
		
	}
    public boolean equal(String name,String color,String size){
    	if(this.color == color && this.size == size && this.getName() == name){
    		return true;
    	}else{
    		return false;
    	}
    }
    public String toString(){
    	String format = "%s %.3f %.2f %d %d %s %s %.2f";
    	return String.format(format,this.getName(),this.getWeight(),this.getPrice(),this.getCurrNumStock(),this.getNumRestocks(),this.color,this.size,this.buyingPrice);
    }
}


