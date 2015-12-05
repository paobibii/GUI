package code2;
import java.util.*;
public class Payment {
 private double totalPrice;
 private double discountRate;
 private double shippingFee;
 private double discount;
 private double value;
 public Payment(){
	 this.discount =0.0;
	 this.discountRate =0.0;
	 this.shippingFee =0.0;
	 this.totalPrice= 0.0;
	 this.value =0.0;
 }
 public Payment(double totalPrice,double discountRate,double shippingFee){
	 this.discount = discount;
	 this.discountRate = discountRate;
	 this.shippingFee = shippingFee;
	 
 }
 @Override
 public String toString()
 {
	 return String.format("Total price = %.2f,Discount rate =%.2f%,Discount = %.2f,ShippingFee = %.2f,Payment =%.2f",this.totalPrice,this.discountRate,this.discount,this.shippingFee,this.value);
 }
public double getTotalPrice() {
	return totalPrice;
}
public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}
public double getDiscountRate() {
	return discountRate;
}
public void setDiscountRate(double discountRate) {
	this.discountRate = discountRate;
}
public double getShippingFee() {
	return shippingFee;
}
public void setShippingFee(double shippingFee) {
	this.shippingFee = shippingFee;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
}
