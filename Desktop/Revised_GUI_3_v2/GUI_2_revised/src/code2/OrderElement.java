package code2;
import java.util.*;

public class OrderElement {
	private ProductExt product;
	private int num;
    public OrderElement(){
    	this.num =0;
    	this.product = new ProductExt();
    }
    public OrderElement(ProductExt product,int num){
    	this.product = product;
    	this.num= num;
    }
	public ProductExt getProduct() {
		return product;
	}
	public OrderElement clone(){
		OrderElement obj = new OrderElement();
		return obj;
	}
	public void setProduct(ProductExt product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
	     this.num = num;
	}
}
