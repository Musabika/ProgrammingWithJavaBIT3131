package caseThree;

import java.awt.Rectangle;
import java.util.Scanner;

public class caseThree {

	//NAMES OF GROUP MEMBERS
	//1.MUSABIKA FIDELE 223003195
	//2.NISHIMWE SEZERANO DELICE 223010486
	//3.MUKAMA UYISENGA LEA 223018803
	//4.MUHAYIMPUNDU CHARLENNE 223003942
	//5.UWIMANA AMINA 223009215
		        Scanner sc = new Scanner(System.in);
		        Rectangle[] rectangles =  {new Rectangle(), new Rectangle(),  new Rectangle()};
		        for (int j = 0; j < rectangles.length; j++) {
		            System.out.print("Enter length of rectangle " + (j + 1) + ":");
		            double length = sc.nextDouble();
		            System.out.println("Enter width of rectangle " + (j + 1) + ":");
		            double width = sc.nextDouble();
		            rectangles[j].insertWidth(width);
		            rectangles[j].insertLength(length);
		        }
		        System.out.println("Rectangle Name \t\t\t Area of Rectangle \t\t\t isSquare");
		        for (int i = 0; i < rectangles.length; i++) {
		            Rectangle rectangle = rectangles[i];
		            System.out.println("Rectangle" + (i+ 1) + "\t\t\t\t\t\t" + rectangle.calculateArea() + "\t\t\t\t\t " + rectangle.checkIfIsSquare());

		        }
		    }

	}


