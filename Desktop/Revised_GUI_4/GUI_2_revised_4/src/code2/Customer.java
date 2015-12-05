package code2;
import java.util.*;

public class Customer extends Person {
	private String CustomerID = "1";
	private String memberClass;
	private ArrayList<OrderElement> basket;
	private ArrayList<Order> historyList;
	private static int numCustomers;
    public Customer(){
    	this.CustomerID = "";
    	this.memberClass ="";
    	this.basket = new ArrayList<OrderElement>();
    	this.historyList = new ArrayList<Order>();
    	this.numCustomers =0;
    }
    public Customer(String personID,String name,String lastname,String gender,int age,String memberClass){
    	super(personID,name,lastname,gender,age);
    	this.memberClass = memberClass;
    	
    }
    public void addToBasket(OrderElement element){
    	basket.add(element);
    }
    public double getBasketTotalWeight(){
    	OrderElement orderE = new OrderElement();
    	
    	return orderE.getProduct().getWeight();
    }
    public double getBasketTotalPrice(){
    	OrderElement orderE = new OrderElement();
    	
    	return orderE.getProduct().getPrice(); 
    }
    public void clearBasket(){
    	for(int i = basket.size();i>=0;i--){
    		basket.remove(i);
    	}
    }
    public  void addToHistoryList(Order order){
    	historyList.add(order);
    }
    public String getBasketString(){
    	OrderElement orderE = new OrderElement();
    	
    	return this.getName() + orderE.getProduct().getColor() +orderE.getProduct().getSize() + orderE.getProduct().getWeight()
    			+orderE.getProduct().getPrice()+orderE.getProduct().getNumProducts();
    }
    public String getHistoryListString(){
    	return historyList.toString();
    }
    public boolean equals(){
    	if(super.getID() == this.getID() &&super.getLastname() == this.getLastname() && super.getName() == this.getName()){
    		return true;
    	}else{
    		return false;
    	}
    }
    public String toString(){
    	return this.CustomerID+" "+super.getID()+" "+super.getName()+" "+super.getLastname()+" "+super.getGender()+" "+super.getAge()+" "+this.memberClass;
    }
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getMemberClass() {
		return memberClass;
	}
	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}
	public ArrayList<OrderElement> getBasket() {
		return basket;
	}
	public void setBasket(ArrayList<OrderElement> basket) {
		this.basket = basket;
	}
	public ArrayList<Order> getHistoryList() {
		return historyList;
	}
	public void setHistoryList(ArrayList<Order> historyList) {
		this.historyList = historyList;
	}
	public static int getNumCustomers() {
		return numCustomers;
	}
	public static void setNumCustomers(int numCustomers) {
		Customer.numCustomers = numCustomers;
	}

}
