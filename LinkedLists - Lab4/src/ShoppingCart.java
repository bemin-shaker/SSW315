// ********************************************************************** 
//   ShoppingCart.java 
// 
//   Represents a shopping cart as an array of items 
// ********************************************************************** 
import java.text.NumberFormat;
import java.util.Scanner; 
public class ShoppingCart 
{ 
	private int itemCount;      // total number of items in the cart 
	private double totalPrice;  // total price of items in the cart 
	private int capacity;       // current cart capacity 
	
	private Item[] cart;		// internal shopping cart data member;
	
	// ----------------------------------------------------------- 
	//  Creates an empty shopping cart with a capacity of 5 items. 
	// ----------------------------------------------------------- 
	public ShoppingCart() 
	{ 
		capacity = 5; 
		itemCount = 0; 
		totalPrice = 0.0; 
		
		//Activity Part II.a - Your code goes at below to instantiate the cart be an array holding capacity items:
		
		cart = new Item[capacity];
		
		
	} 
	
	
	
	// ------------------------------------------------------- 
	//  Adds an item to the shopping cart. 
	// ------------------------------------------------------- 
	public void addToCart(String itemName, double price, int quantity) 
	{ 
	// Activity Part II.c - Fill in the code for the addToCart method. This method should add a new item  to the cart, 
	// which stores the input data, and update the totalPrice instance variable accordingly (note this variable takes 
	// into account the quantity). 
		
		if(itemCount == capacity)
			increaseSize();
			cart[itemCount++] = new Item(itemName, price, quantity);
			totalPrice = totalPrice + (price * quantity);
		
	
	
	
	} 
	// ------------------------------------------------------- 
	//  Returns the contents of the cart together with 
	//  summary information. 
	// ------------------------------------------------------- 
	public String toString() 
	{ 
		NumberFormat fmt = NumberFormat.getCurrencyInstance(); 
		String contents = "\nShopping Cart\n"; 
		contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n"; 
		for (int i = 0; i < itemCount; i++) 
			contents += cart[i].toString() + "\n"; 
		contents += "\nTotal Price: " + fmt.format(totalPrice); 
		contents += "\n"; 
		return      contents;      
	} 
	
	// --------------------------------------------------------- 
	//  Increases the capacity of the shopping cart by 3 
	// --------------------------------------------------------- 
	private void increaseSize() 
	{ 
	// Activity Part II.b - Fill in the code for the increaseSize method, which is to increase the capacity of the cart. 
	// Your code would be similar to lines 157-159 in weiss.util.ArrayList.java, but instead of doubling the size just 
	// increase it by 3 elements. 
	
		capacity = capacity + 3;
		
		Item[] newItem = new Item[capacity];
		for(int i=0; i<itemCount; i++)
			newItem[i] = cart[i];
			cart = newItem;
	
	
	
	} 
	
	public static void main (String[] args) 
	{ 
		ShoppingCart shoppingTest = new ShoppingCart(); 

		Item      item;      
		String      itemName;      
		double      itemPrice;      
		int      quantity;      
		Scanner scan = new Scanner(System.in); 
		String keepShopping = "y"; 
		do            
		{ 
			System.out.print ("Enter the name of the item: ");  
			itemName      =      scan.nextLine();      
			System.out.print ("Enter the unit price: "); 
			itemPrice      =      scan.nextDouble();      
			System.out.print ("Enter the quantity: "); 
			quantity      =      scan.nextInt();      

			// add item to cart;
			shoppingTest.addToCart(itemName, itemPrice, quantity);


			// print cart;
			double totalprice = 0;
			for (int i = 0; i < shoppingTest.itemCount; i++)
			{
				item = shoppingTest.cart[i];
				System.out.println(item.getName() + ":  "
						+ item.getQuantity() + "*"
						+ item.getPrice());
				totalprice += item.getQuantity() * item.getPrice();
			}
			System.out.println("Total price: " + totalprice);
			System.out.println();
			System.out.print ("Continue shopping (y/n)? "); 
			scan.nextLine(); // go to next line.
			keepShopping      =      scan.nextLine();  
		} 
		while      (keepShopping.equals("y"));  
		System.out.print("done");
	} 
	
}
