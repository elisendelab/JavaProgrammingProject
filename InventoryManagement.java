package term_project_22300245;

import java.io.*;
import java.util.*;

public class InventoryManagement {
	private Scanner scanner;
    private ArrayList<Stock> stocks;
    private ArrayList<Customer> customers;
    private int totalCustomers;

    public InventoryManagement(Scanner scanner) {
    	this.scanner=scanner;
        stocks = new ArrayList<>();
        customers = new ArrayList<>();
        totalCustomers = 0;
    }

    public void addNewStock() {
    	while(true) {
	        System.out.println("\n\nEnter stock item:");
	        String item = scanner.nextLine();
	        System.out.println("Enter stock quantity:");
	        int quantity = scanner.nextInt();
	        scanner.nextLine(); // Consume newline
	        
	        Stock newStock = new Stock(item, quantity);
	        stocks.add(newStock);
	        System.out.println("New stock item added successfully!");
	        System.out.println("Do you want to add another stock item? (yes/no)");
	        String choice = scanner.nextLine();
	        if (choice.equalsIgnoreCase("yes")) {
		        continue;
		    }
		    else if (choice.equalsIgnoreCase("no")) {
		        break; // Exit the loop and return to the menu
		    }
		    else {
		    	System.out.println("Invalid input. Returning to menu.");
		    	break;
		    }
	    }
    }

    public void updateStockQuantity(String item, int quantity) {
    	while(true) {
	        Stock stock = findStock(item);
	        if (stock != null) {
	            stock.setQuant(quantity);
	            System.out.println(stock.getItem() + " quantity updated to " + stock.getQuant() + ".");
	        } 
	        else {
	            System.out.println("Stock not found in the inventory.");
	        }
	        System.out.println("Do you want to update another stock item? (yes/no)");
	        String choice = scanner.nextLine();
	        if (choice.equalsIgnoreCase("yes")) {
		        continue;
		    }
		    else if (choice.equalsIgnoreCase("no")) {
		        break; // Exit the loop and return to the menu
		    }
		    else {
		    	System.out.println("Invalid input. Returning to menu.");
		    	break;
		    }
	    }
    }

    public Stock findStock(String item) {
        for (Stock stock : stocks) {
            if (stock.getItem().equalsIgnoreCase(item)) {
                return stock;
            }
        }
        return null;
    }
    
    public void allStock() {
    	System.out.println("\n\n");
        for (Stock s : stocks) {
        	System.out.printf("%-15s %-10d%n", s.getItem(), s.getQuant());

        }
        returnToMenu();
    }

    public void printStockReport() {
    	System.out.println("\n\nStock Report:\n");
        System.out.println("Items that need to be restocked (quantity less than 4):\n");
        for (Stock s : stocks) {
            if (s.getQuant() < 4) {
            	System.out.printf("%-15s %-10d%n", s.getItem(), s.getQuant());
            }
        }
        returnToMenu();
    }
    

    public void addCustomer() {
    	while (true) {
	        int nextId = totalCustomers + 1;
	        System.out.println("\n\nEnter customer name:");
	        String name = scanner.nextLine();
	        System.out.println("Enter customer phone number:");
	        String phone_num = scanner.nextLine();
	        System.out.println("Enter customer email:");
	        String email = scanner.nextLine();
	        System.out.println("Enter camera type:");
	        String cam_type = scanner.nextLine();
	        System.out.println("Enter camera problem:");
	        String cam_prob = scanner.nextLine();
	        
	        Customer newCustomer = new Customer(String.valueOf(nextId), name, phone_num, email, cam_type, cam_prob, "Pending");
	        customers.add(newCustomer);
	        totalCustomers++; // Increment the total number of customers
	        System.out.println("New customer added successfully!");
	        System.out.println("Do you want to add another customer? (yes/no)");
	        String choice = scanner.nextLine();
	        if (choice.equalsIgnoreCase("yes")) {
		        continue;
		    }
		    else if (choice.equalsIgnoreCase("no")) {
		        break; // Exit the loop and return to the menu
		    }
		    else {
		    	System.out.println("Invalid input. Returning to menu.");
		    	break;
		    }
	    }
    }


    public void updateCustomer(String id) {
    	while (true) {
	        Customer customer = findCustomer(id);
	        if (customer != null) {
	            System.out.println("\nCustomer record found:\n");
	            System.out.println(customer.getRecord());
	
	            System.out.println("\nSelect what you want to edit:");
	            System.out.println("1. Name");
	            System.out.println("2. Phone Number");
	            System.out.println("3. Email");
	            System.out.println("4. Camera Type");
	            System.out.println("5. Camera Problem");
	            System.out.println("6. Status");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();
	
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter new name: ");
	                    String newName = scanner.nextLine();
	                    customer.setName(newName);
	                    System.out.println("Customer name updated.");
	                    break;
	                case 2:
	                    System.out.print("Enter new phone number: ");
	                    String newphone_num = scanner.nextLine();
	                    customer.setPhone_num(newphone_num);
	                    System.out.println("Customer phone number updated.");
	                    break;
	                case 3:
	                    System.out.print("Enter new email: ");
	                    String newEmail = scanner.nextLine();
	                    customer.setEmail(newEmail);
	                    System.out.println("Customer email updated.");
	                    break;
	                case 4:
	                    System.out.print("Enter new camera type: ");
	                    String newcam_type = scanner.nextLine();
	                    customer.setCam_type(newcam_type);
	                    System.out.println("Customer camera type updated.");
	                    break;
	                case 5:
	                    System.out.print("Enter new camera problem: ");
	                    String newcam_prob = scanner.nextLine();
	                    customer.setCam_prob(newcam_prob);
	                    System.out.println("Customer camera problem updated.");
	                    break;
	                case 6:
	                    System.out.print("Enter new status: ");
	                    String newStatus = scanner.nextLine();
	                    customer.setStatus(newStatus);
	                    System.out.println("Customer status updated.");
	                    break;
	                default:
	                    System.out.println("Invalid choice.");
	            }
	        } 
	        else {
	            System.out.println("Customer not found.");
	        }
	        System.out.println("\nDo you want to update another customer record? (yes/no)");
		    String choice = scanner.nextLine();
		    if (choice.equalsIgnoreCase("yes")) {
		    	System.out.print("Enter customer ID: ");
                id = scanner.nextLine();
		    }
		    else if (choice.equalsIgnoreCase("no")) {
		        break; // Exit the loop and return to the menu
		    }
		    else {
		    	System.out.println("Invalid input. Returning to menu.");
		    	break;
		    }
		}
    }


    public void findCustomer() {
        while (true) {
        	System.out.println("\n\nDo you want to search for a customer by ID or by name? (id/name)");
            String ans = scanner.nextLine();
            
            if (ans.equalsIgnoreCase("id")) {
                System.out.println("Enter customer ID to search:");
                String id = scanner.nextLine();
                boolean found = false;
                for (Customer c : customers) {
                    if (c.getId().equals(id)) {
                        System.out.println(c.getRecord());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Customer name not found.");
                }
            } 
            else if (ans.equalsIgnoreCase("name")) {
                System.out.println("Enter customer name to search:");
                String name = scanner.nextLine();
                boolean found = false;
                for (Customer c : customers) {
                    if (c.getName().equalsIgnoreCase(name)) {
                        System.out.println(c.getRecord());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Customer name not found.");
                }
            } 
            else {
                System.out.println("Invalid input");
            }
		    System.out.println("\nDo you want to search for another customer? (yes/no)");
		    String choice = scanner.nextLine();
		    if (choice.equalsIgnoreCase("yes")) {
		        continue;
		    }
		    else if (choice.equalsIgnoreCase("no")) {
		        break; // Exit the loop and return to the menu
		    }
		    else {
		    	System.out.println("Invalid input. Returning to menu.");
		    	break;
		    }
		}
    }
        
    public Customer findCustomer(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(id)) {
                return customer;
            }
        }
        return null;
    }

    public void viewall() {
    	System.out.println("\n\n");
        for (Customer customer : customers) {
            System.out.println(customer.getRecord());
        }
        returnToMenu();
    }
    
    
    public void printCustomerReport() {
        System.out.println("\n\nCustomer Report (Pending):");
        for (Customer c : customers) {
            if (c.getStatus().equalsIgnoreCase("Pending")) {
                System.out.println(c.getRecord());
            }
        }
        returnToMenu();
        
    }
    
    public void returnToMenu() {
    	System.out.println("\nDo you want to return to the menu or exit the program? (m/e)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("m")) {
            return; // Return to the menu
        } 
        else if (choice.equalsIgnoreCase("e")) {
        	exitProgram();
        } 
        else{
            System.out.println("Invalid choice. Returning to the menu.");
        }
    }


    public void readStockFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length >= 2) {
                    String item = data[0];
                    int quantity = Integer.parseInt(data[1]);
                    stocks.add(new Stock(item, quantity));
                } 
                else {
                    System.out.println("Invalid stock record format: " + scanner.nextLine());
                }
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Stock file not found.");
        }
    }


    public void readCustomerFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] rec = scanner.nextLine().split(",");
                if (rec.length >= 7) {
                    String id = rec[0];
                    String name = rec[1];
                    String phone_num = rec[2];
                    String email = rec[3];
                    String cam_type = rec[4];
                    String cam_prob = rec[5];
                    String status = rec[6];
                    customers.add(new Customer(id, name, phone_num, email, cam_type, cam_prob, status));
                    totalCustomers++;
                } 
                else{
                    System.out.println("Invalid customer record format: " + scanner.nextLine());
                }
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Customer file not found.");
        }
    }


    public void writeStockFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Stock stock : stocks) {
                writer.write(stock.getItem() + "," + stock.getQuant() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to stock file.");
        }
    }

    public void writeCustomerFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Customer customer : customers) {
                writer.write(customer.getId() + "," + customer.getName() + "," + customer.getPhone_num() + ","
                        + customer.getEmail() + "," + customer.getCam_type() + "," + customer.getCam_prob() + ","
                        + customer.getStatus() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to customer file.");
        }
    }
    
    public void exitProgram() {
    	System.out.println("Exited");
	    writeStockFile("Stock_Info.txt");
	    writeCustomerFile("Customer_Records.txt");
	    scanner.close();
	    System.exit(0);
    }
}