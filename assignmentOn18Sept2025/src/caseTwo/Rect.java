package caseTwo;

import java.util.Scanner;

public class Rect {

	//NAMES OF GROUP MEMBERS
	//1.MUSABIKA FIDELE 223003195
	//2.NISHIMWE SEZERANO DELICE 223010486
	//3.MUKAMA UYISENGA LEA 223018803
	//4.MUHAYIMPUNDU CHARLENNE 223003942
	//5.UWIMANA AMINA 223009215
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();
        Circle circle = new Circle(radius);

        System.out.println("Do you what to calculate the Area or circumference (Area/circumference) of Circle: ");
        System.out.println("1. Area");
        System.out.println("2. Circumference");
        System.out.print("Enter your choice: ");
        int chosen = sc.nextInt();
       switch (chosen) {
           case 1:
               double area = circle.calculateArea();
               System.out.println("The area of the circle is: " + area);
               break;
           case 2:
               double circumference = circle.calculateCircumference();
               System.out.println("The circumference of the circle is: " + circumference);
               break;
           default:
               System.out.println("Invalid choice");
               break;
       }


	}

}

            
