import java.util.Scanner;

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of different items bought: ");
        int itemCount = scanner.nextInt();

        String[] itemNames = new String[itemCount];
        double[] prices = new double[itemCount];
        int[] quantities = new int[itemCount];
        double[] subtotals = new double[itemCount];

        double totalBill = 0;

        for (int i = 0; i < itemCount; i++) {
            System.out.println("\nItem " + (i + 1) + ":");

            System.out.print("Enter item name: ");
            itemNames[i] = scanner.next();

            System.out.print("Enter price per unit: ");
            prices[i] = scanner.nextDouble();

            System.out.print("Enter quantity: ");
            quantities[i] = scanner.nextInt();

            subtotals[i] = prices[i] * quantities[i];
            totalBill += subtotals[i];
        }

        double discount = 0;
        if (totalBill > 50000) {
            discount = totalBill * 0.05;
        }
        double finalAmount = totalBill - discount;

        // 6. Print receipt
        System.out.println("\n--- Supermarket Receipt ---");
        System.out.printf("%-15s %-10s %-15s %-10s\n", "Item", "Qty", "Price/Unit", "Subtotal");
        for (int i = 0; i < itemCount; i++) {
            System.out.printf("%-15s %-10d %-15.2f %-10.2f\n",
                    itemNames[i], quantities[i], prices[i], subtotals[i]);
        }

        System.out.println("-------------------------------------------");
        System.out.printf("Grand Total (before discount): %.2f\n", totalBill);
        System.out.printf("Discount: %.2f\n", discount);
        System.out.printf("Final Amount Payable: %.2f\n", finalAmount);

        scanner.close();
    }
}
