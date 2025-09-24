package assignment_21_sept_2025_OOP.Q5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    public final static  Scanner sc = new Scanner(System.in);
    public static double totalBillAfterDiscount;
    public static char choose;
    public  static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        do {
            System.out.println("Choose Product To buy");
            System.out.println("1. Laptop");
            System.out.println("2. Mouse");
            System.out.println("3. Keyboard");
            System.out.println("4. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("How many Laptops do you wish to buy?");
                    int laptops = sc.nextInt();
                    Product p = new Product("Laptop", 40_000, laptops);
                    products.add(p);
                    break;
                case 2:
                    System.out.println("How many Mouses do you wish to buy?");
                    int mouses = sc.nextInt();
                    Product p2 = new Product("Mouse", 1_000, mouses);
                    products.add(p2);
                    break;
                case 3:
                    System.out.println("How many Keyboards do you wish to buy?");
                    int keyboards = sc.nextInt();
                    Product p3 = new Product("Keyboard", 3000, keyboards);
                    products.add(p3);
                    break;
                case 4:
                    System.out.println("Thank you for using this program.");
                    choose = 'n';
                    break;
                default:
                    System.out.println("Invalid Choice");
                    System.out.println("Do you wish to continue? y/n");
                    choose =  sc.next().toLowerCase().charAt(0);
            }
        }while (choose != 'n');
        for (Product p : products) {
            totalBillAfterDiscount += p.getTotalCost();
        }
        if (totalBillAfterDiscount > 0) {
            System.out.println("Total Bill After Discount: " + totalBillAfterDiscount);
        }
        sc.close();
    }
}
