package term_project_22300245;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        InventoryManagement invman = new InventoryManagement(scanner);
        invman.readStockFile("Stock_Info.txt");
        invman.readCustomerFile("Customer_Records.txt");


        while (true) {
            System.out.println("\n----------------------------------------");
            System.out.println("\nInventory Management Menu:");
            System.out.println("1. List all stocks");
            System.out.println("2. Add new stock");
            System.out.println("3. Update stock quantity");
            System.out.println("4. List all customers");
            System.out.println("5. Add new customer");
            System.out.println("6. Update customer record");
            System.out.println("7. Search for a customer record");
            System.out.println("8. Print stock report");
            System.out.println("9. Print customer report");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
            } catch (InputMismatchException e) {
            	System.out.println("\n*************************************");
                System.out.println("Invalid input. Please enter a number.");
                System.out.println("*************************************");
                scanner.nextLine();  // Clear the invalid input
                continue;
            }

            switch (choice) {
            case 1:
                invman.allStock();
                break;
            case 2:
                invman.addNewStock();
                break;
            case 3:
                System.out.print("Enter stock item: ");
                String item = scanner.nextLine();
                System.out.print("Enter new quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                invman.updateStockQuantity(item, quantity);
                break;
            case 4:
                invman.viewall();
                break;
            case 5:
            	invman.addCustomer();
                break;
            case 6:
            	System.out.print("Enter customer ID: ");
                String customerId = scanner.nextLine();
                invman.updateCustomer(customerId);
                break;
            case 7:
            	invman.findCustomer();
                break;
            case 8:
            	invman.printStockReport();
                break;
            case 9:
                invman.printCustomerReport();
                break;
            case 10:
            	invman.exitProgram();
                return;
            default:
            	System.out.println("\n******************************************");
                System.out.println("Not a listed option. Please try again.");
                System.out.println("******************************************");
            }
        }
    }
    
}