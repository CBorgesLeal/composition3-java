package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name:");
		String clientName = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY):");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter order data:");
		System.out.print("Status:");
		String status = sc.nextLine();
		
		Client client = new Client(clientName, email, birthDate);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			
			System.out.println("Enter #" + i + " item data");
			System.out.print("Product name:");
			String name = sc.nextLine();
			System.out.print("Product price:");
			double price = sc.nextDouble();
			System.out.print("Quantity:");
			int quantity = sc.nextInt();
			
			Product product = new Product(name, price);
			OrderItem orderItem = new OrderItem(quantity, price, product);
			Order order = new Order(new Date(), OrderStatus.valueOf(status));
			
			order.addItem(orderItem);
		}
		
		
		
		sc.close();
	}
}
