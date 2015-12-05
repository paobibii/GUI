package code2;
import java.util.*;

public class StoreApp {
    static Scanner input = new Scanner (System.in);
	
	public static Customer getCustomer (Store store) {
		String personID, name, lastname, gender, memberClass;
		String answer;
		int age, index;
		Customer shopper;

		System.out.print("Are you new customer (Yes/No)? ");
		answer = input.nextLine();

		if (answer.equals("No")) {
			// Old customer
			System.out.print("Enter person ID: ");
			personID = input.nextLine();
			System.out.print("Enter name: ");
			name = input.nextLine();
			System.out.print("Enter lastname: ");
			lastname = input.nextLine();
			
			// search for Customer index
			index = store.searchCustomer(personID, name, lastname);
			
			// get the Customer object from the CustomerList
			shopper = store.getCustomerList().get(index);
		} else {
			//New customer
			System.out.println("Enter customer information: ");
			System.out.print("Enter person ID: ");
			personID = input.nextLine();
			System.out.print("Enter name: ");
			name = input.nextLine();
			System.out.print("Enter lastname: ");
			lastname = input.nextLine();
			System.out.print("Enter gender (M/F): ");
			gender = input.nextLine();
			System.out.print("Enter age: ");
			age = Integer.parseInt(input.nextLine());
			System.out.print("Do you want to apply for our membership (Gold/Silver/Green/None)? ");
			memberClass = input.nextLine();

			//create new Customer object
			shopper = new Customer(personID, name, lastname, gender, age, memberClass);
			
			//add to the CustomerList of the store
			store.addCustomer(shopper);
		}	
		//return Customer object
		return shopper;	
	}
	
	public static void main (String[] args) {

		Store store;

		ArrayList<ProductExt> productList = new ArrayList<ProductExt> ();
		ArrayList<Customer>  customerList = new ArrayList<Customer> ();
		int productIndex = 0, customerIndex = 0;
		String answer = "";

		// Create ProductList
		productList.add(new ProductExt("Gap T-Shirt", 1.25, 120, 5, 20, "blue", "S", 90));
		productList.add(new ProductExt("Gap T-Shirt", 1.25, 120, 5, 20, "black", "S", 90));
		productList.add(new ProductExt("Gap T-Shirt", 1.35, 200, 5, 15,  "blue", "M", 120));
		productList.add(new ProductExt("Gap T-Shirt", 1.35, 200, 5, 15, "black", "M", 120));
		
		// Create CustomerList
		customerList.add(new Customer("1234", "Ann", "Marie", "F", 25, "Silver"));
		customerList.add(new Customer("5913", "Bob", "Martin", "M", 20, "None"));
		customerList.add(new Customer("8394", "Charlie", "Wang", "M", 65, "Green"));

		// Create Store object
		store = new Store(productList, customerList, 5000.0, 0.0);  

		// Add more Product to the store
		store.addProduct(new ProductExt("Gap T-Shirt", 1.5, 300, 3, 10, "blue", "L", 230));
		store.addProduct(new ProductExt("Gap T-Shirt", 1.5, 300, 3, 10, "black", "L", 230));

		// Add more Customer to the store
		store.addCustomer(new Customer("1958", "Diana", "Spence", "F", 70, "None"));
		System.out.println("List of Customers:");
		System.out.println(store.getCustomerListString());
		
		// while taking shopping oder
		do {
			Customer shopper; 
			Order order;
			String shippingOption;
			boolean registered, express;
			
			System.out.print("----------\n");
			System.out.println("Welcome to SKE clothes shop!");

			// get Customer object
			shopper = getCustomer(store);
			System.out.println(shopper);

			// display product menu
			System.out.println("Shopping menu: ");
			System.out.println(store.getProductListString()); 

			productIndex = 0;
			while (productIndex != -1) {
				
				// ask shopper (customer) to select product or -1 to quit
				System.out.printf("Enter product index (1-%d) or -1 to quit: ", store.getProductList().size());
				productIndex = Integer.parseInt(input.nextLine());

				if (productIndex != -1) {
					
					// ask shopper for amount of product he/she wants
					System.out.print("Enter amount: ");
					int num = Integer.parseInt(input.nextLine());

					if (num > 0) {
						// check to see whether the stock has enough items of product shopper wants
						int availStatus = store.checkAvailability(store.getProductList().get(productIndex-1),num);
						
						if (availStatus  == 1) {  
							// if the stock is enough, 
							// add OrderElement with product and num to basket
							OrderElement element = new OrderElement(store.getProductList().get(productIndex-1), num);
							shopper.addToBasket(element); 

							// display current basket
							System.out.print("Current basket:\n");
							System.out.println(shopper.getBasketString());

							// the store updates stock
							store.updateStock(element);

						} else {  // if (availStatus  == 1) 
							
							// if the stock is enough, notify shopper
							System.out.printf("Sorry.  We only have %d left. Please reorder.\n",store.getProductList().get(productIndex-1).getCurrNumStock());
						} // if (availStatus  == 1 || availStatus  == -1) 
					} else {
						// if shopper enters negative number for num, notify shopper
						System.out.printf("Sorry.  Enter more than zero for amount\n");
					}

				} // if (index != -1)
			}// while (index != -1)

			// when shopper finish shopping, 
			// ask shipping question -> registered or express
			System.out.println("Proceed to check out...");
			do {
				System.out.print("For shipping, do you want registered (R) or express shipping (E) or none (N)?: ");
				shippingOption = input.nextLine();
			} while (!(shippingOption.equals("R") || shippingOption.equals("E") || shippingOption.equals("N")));

			// set value for registered and express according to shopper's choice
			registered = false;
			express = false;
			if (shippingOption.equals("R")) {
				registered = true;
			} else if (shippingOption.equals("E")) {
				express = true;
			} 

			// check out the shopper and display order
			order = store.checkOut(shopper, registered, express);
			System.out.printf("%s", order.toString());

			// display information of store and productList of store
			System.out.print("\nCurrent store:\n");
			System.out.println(store);
			System.out.print(store.getProductListString());

			// if restock is needed, display information of store and productList of store
			if (store.isRestockProduct()) {
				store.clearRestock();
				System.out.print("\n----------\n");
				System.out.print("After restock:\n");
				System.out.println(store);
				System.out.print(store.getProductListString());
			}

			// ask whether there is more customer to take shopping order or not
			System.out.print("\nMore customer to take order (Yes or No)? ");
			answer = input.nextLine();

		} while (!answer.equals("No"));

		// display list of Orders from each Customer
		System.out.println("\nList of All Customer Orders: ");
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getHistoryList().size() > 0) {
				System.out.println(customerList.get(i).getHistoryListString());
			}
		}
		
		// search and remove Product
		productIndex = store.searchProduct("Gap T-Shirt", "black", "L");
		if (productIndex != -1) {
			store.removeProduct(productIndex);
		}
		
		// display final ProductList
		System.out.print("Final Stock:\n");
		System.out.println(store.getProductListString());
		
		// search and display Customer if found
		customerIndex = store.searchCustomer("1003", "Charlie", "Wang");
		if (customerIndex != -1) {
			System.out.println(store.getCustomerList().get(customerIndex));
		}
				
	}
}