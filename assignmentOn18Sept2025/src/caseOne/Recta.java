package caseOne;

import java.awt.Rectangle;
import java.util.Scanner;

public class Recta {

	//NAMES OF GROUP MEMBERS
	//1.MUSABIKA FIDELE 223003195
	//2.NISHIMWE SEZERANO DELICE 223010486
	//3.MUKAMA UYISENGA LEA 223018803
	//4.MUHAYIMPUNDU CHARLENNE 223003942
	//5.UWIMANA AMINA 223009215
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.print("Enter the length of the rectangle: ");
            double length = sc.nextDouble();
            System.out.print("Enter the width of the rectangle: ");
            double width = sc.nextDouble();
            TestRecta recta  = new TestRecta();
            recta.insertLength(length);
            recta.insertWidth(width);
            double area = recta.calculateArea();
            System.out.println("The area of the rectangle is: " + area);
            if ( recta.checkIfIsSquare()) {
                System.out.println("The rectangle is a square");
            }

            System.out.print("Do you want to continue (y/n): ?");
            choice = sc.next().toLowerCase();

        } while (choice.equals("y"));


    }

}
