package code2;
import java.util.*;

public class Store {
	private ArrayList<ProductExt> productList;
	private ArrayList<Customer> customerList;
	private double revenue;
	private double expense;
	private int numProducts;
	private boolean restockProduct;

	public Store() {
		this.productList = new ArrayList<ProductExt>();
		this.customerList = new ArrayList<Customer>();
		this.revenue = 0.0;
		this.expense = 0.0;
		this.numProducts = 0;
		this.setRestockProduct(false);
	}

	public ArrayList<ProductExt> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<ProductExt> productList) {
		this.productList = productList;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public int getNumProducts() {
		return numProducts;
	}

	public void setNumProducts(int numProducts) {
		this.numProducts = numProducts;
	}

	public Store(ArrayList<ProductExt> productList, ArrayList<Customer> customerList, double revenue, double expense) {
		this.productList = new ArrayList<ProductExt>();
		this.customerList = new ArrayList<Customer>();
		this.revenue = revenue;
		this.expense = expense;
		this.numProducts = Product.getNumProducts();

	}

	public void addProduct(ProductExt product) {
		productList.add(product);
	}

	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	public int searchProduct(String name, String color, String size) {
		int x = 0;
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).equal(name, color, size)) {
				x = i;
			} else {
				x = -1;
			}
		}
		return x;
	}

	public int searchCustomer(String personID, String name, String lastname) {
		int x = 0;
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).equals()) {
				x = i;
			} else {
				x = -1;
			}
		}
		return x;
	}

	public void removeProduct(int productindex) {
		productList.remove(productindex);
	}

	public int checkAvailability(ProductExt product, int num) {
		if (num >= product.getCurrNumStock()) {
			return 1;
		} else {
			return 0;
		}
	}

	public void updateStock(OrderElement element) {
		element.getProduct().withdrawStock(element.getNum());
		Product.restock();
		if (Product.getCurrNumStock() < 3) {
			this.restockProduct = true;

		}
	}

	public Order checkOut(Customer customer, boolean registered, boolean express) {
		Order order = new Order(customer, registered, express);
		this.revenue += order.getTotalPrice();
		this.expense += order.getShipping().getShippingFee();
		customer.addToHistoryList(order);
		customer.clearBasket();
		return order;
	}

	public void clearRestock() {
		if (Product.isRestock() == true) {
			Product.restock();
		}
        this.expense += Product.getNumRestocks();
        Product.setRestock(false);
	}

	public String getProductListString() {
		return productList.toString();
	}

	public String getCustomerListString() {
		return customerList.toString();
	}
	public double getProfit(){
		return this.revenue - this.expense;
	}
	public String toString(){
		return String.format("Revenue: %.2f, Expense: %.2f ,Profit: %.2f",this.revenue + this.expense + this.getProfit());
	}

	public boolean isRestockProduct() {
		return restockProduct;
	}

	public void setRestockProduct(boolean restockProduct) {
		this.restockProduct = restockProduct;
	}
}
