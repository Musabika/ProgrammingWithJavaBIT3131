package assignment_21_sept_2025_OOP.Q5;

public class Product {
    private final long id;
    private final String name;
    private final double price;
    private final int quantity;
    private double  totalCost;
    public Product(String name, double price,  int quantity) {
        this.id =(long) (Math.random() * 10_000_000L);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.calculateTotalCost();
    }
    private void calculateTotalCost() {
        double cost = price * quantity;
        if (cost > 10_000) {
            double discount = cost * 0.1;
            System.out.println("The Discount to " + name + " Was applied With amount " + discount);
            totalCost = cost - discount;
        }else {
            totalCost = cost;
            System.out.println("The Discount to " + name + " Was not applied");
        }
        System.out.println("Total Cost for product " + name + ": " + totalCost);
    }

    public String getName() {
        return name;
    }
    public long getId() {
        return id;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
