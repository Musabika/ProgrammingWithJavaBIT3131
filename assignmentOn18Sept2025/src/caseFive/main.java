package caseFive;

import java.awt.Rectangle;
import java.util.Scanner;

import caseTwo.Circle;

//NAMES OF GROUP MEMBERS
//1.MUSABIKA FIDELE 223003195
//2.NISHIMWE SEZERANO DELICE 223010486
//3.MUKAMA UYISENGA LEA 223018803
//4.MUHAYIMPUNDU CHARLENNE 223003942
//5.UWIMANA AMINA 223009215

public class main {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hi engineer, inorder to compare The area of rectangle and circle, Please provide some data");
        System.out.print("Please enter the length: " );
        double length = input.nextDouble();
        System.out.print("Please enter the width: " );
        double width = input.nextDouble();
        System.out.println("Please enter the radius of the Circle: ");
        double radius = input.nextDouble();
        Circle circle = new Circle(radius);
        Rectangle rectangle = new Rectangle();
        rectangle.insertLength(length);
        rectangle.insertWidth(width);
        double areaOfRectangle = rectangle.calculateArea();
        System.out.println("Area of rectangle is: " + areaOfRectangle);
        double areaOfCircle = circle.calculateArea();
        System.out.println("Area of circle is: " + areaOfCircle);
        if (areaOfRectangle > areaOfCircle) {
            System.out.println("The area of the rectangle is greater than the area of the Circle");
        }else {
            System.out.println("The area of the rectangle is less than the area of the Circle");
        }


    }

}
