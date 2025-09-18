package caseFour;

import java.awt.Rectangle;
import java.util.Scanner;

import caseTwo.Circle;

public class Main{
	
	//NAMES OF GROUP MEMBERS
	//1.MUSABIKA FIDELE 223003195
	//2.NISHIMWE SEZERANO DELICE 223010486
	//3.MUKAMA UYISENGA LEA 223018803
	//4.MUHAYIMPUNDU CHARLENNE 223003942
	//5.UWIMANA AMINA 223009215
	
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Shape you want to Draw?");
        System.out.println("1. Rectangle");
        System.out.println("2. Circle");
        System.out.print("Enter your choice: ");
        int chosen = sc.nextInt();
        switch (chosen) {
            case 1:
                Rectangle rectangle = new Rectangle();
                System.out.println("Please enter length of rectangle");
                double length = sc.nextDouble();
                System.out.println("Please enter width of rectangle");
                double width = sc.nextDouble();
                rectangle.insertWidth(width);
                rectangle.insertLength(length);
                System.out.println("The area of the rectangle is: " +  rectangle.calculateArea() + "m");
                break;
            case 2:
                System.out.println("Please enter radius of Circle");
                double radius = sc.nextDouble();
                Circle circle = new Circle(radius);
                double ac = circle.calculateArea();
                System.out.println("The area of the circle is: " + ac);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        sc.close();
    }

}
