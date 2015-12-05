package code2;
import java.util.*;
public class Order {
 private ArrayList<OrderElement> buyList;
 private int numBuyElements;
 private Customer customer;
 private String memberClass;
 private Shipping shipping;
 private Payment payment;
 private int orderID;
 private static int numOrders;
 public Order(){
	 this.buyList = new ArrayList<OrderElement>();
	 this.numBuyElements =0;
	 this.memberClass ="";
	 this.shipping = new Shipping();
	 this.payment = new Payment();
	 this.orderID =0;
	 this.numOrders = 0;
	 this.customer = new Customer();
 }
 public ArrayList<OrderElement> getBuyList() {
	return buyList;
}
public void setBuyList(ArrayList<OrderElement> buyList) {
	this.buyList = buyList;
}
public int getNumBuyElements() {
	return numBuyElements;
}
public void setNumBuyElements(int numBuyElements) {
	this.numBuyElements = numBuyElements;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public String getMemberClass() {
	return memberClass;
}
public void setMemberClass(String memberClass) {
	this.memberClass = memberClass;
}
public Shipping getShipping() {
	return shipping;
}
public void setShipping(Shipping shipping) {
	this.shipping = shipping;
}
public Payment getPayment() {
	return payment;
}
public void setPayment(Payment payment) {
	this.payment = payment;
}
public int getOrderID() {
	return orderID;
}
public void setOrderID(int orderID) {
	this.orderID = orderID;
}
public static int getNumOrders() {
	return numOrders;
}
public static void setNumOrders(int numOrders) {
	Order.numOrders = numOrders;
}
public Order(Customer customer,boolean registered,boolean express){
	 
	 
	 getDiscountRate();
	 getTotalWeight();
	 this.shipping = new Shipping();
	 this.payment = new Payment();
     this.customer = new Customer();
     
 }
 public Order clone(){
	 Order order = new Order();
	 return order;
 }
 
 public double getDiscountRate(){
	 if(memberClass.equals("Gold")){
		 return 0.2;
	 }else if(memberClass.equals("Silver")){
		 return 0.1;
	 }else if(memberClass.equals("Green")){
		 return 0.05;
	 }else{
		 return 0.00;
	 }
	 
 }
 public double getTotalWeight(){
	 return shipping.getTotalWeight();
 }
 public double getTotalPrice(){
	 return payment.getTotalPrice();
 }
 @Override
 public String toString(){
	 return "";
 }

}
