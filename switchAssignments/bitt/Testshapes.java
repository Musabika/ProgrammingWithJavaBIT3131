package bitt;
import java.util.Scanner;

import bitt.Rectangle11;

public class Testshapes {


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	
		char choice;
		do{
			System.out.println("Shapes we have");
			System.out.println("1.Rectangle");
			System.out.println("2.Circle");
			System.out.println("3.Square");
			System.out.println("4.Triangle");
			System.out.print("Select Shape: ");
			int chosen = sc.nextInt();

			switch(chosen) {
			case 1:
				System.out.print("Enter Length: ");
				double len = sc.nextDouble();
				
				System.out.print("Enter Width: ");
				double width = sc.nextDouble();
				Rectangle11 rect =new Rectangle11(len, width);
				
				System.out.println("What would you like to do ");
				System.out.println("1: Area");
				System.out.println("2: Perimeter");
				System.out.print("Choose: ");
				
				int c = sc.nextInt();
				if(c == 1) {
					System.out.println("Area Of Rectangle: " + rect.calculateArea());
				}else if(c == 2) {
					System.out.println("Parameter Of Rectangle:" + rect.calculatePerimeter());
				}else {
					System.out.println("Choose 1 or 2 options");
				}
				
				break;
			case 2:
				System.out.print("Enter radius: ");
				double rad = sc.nextDouble();
				Circle cr=new Circle(rad);
				System.out.println("What would you like to do ");
				System.out.println("1: Area");
				System.out.println("2: Perimeter");
				System.out.print("Choose: ");
				
				int rad1 = sc.nextInt();
				if(rad1 == 1) {
					System.out.println("Area Of Rectangle: " + cr.calculateArea());
				}else if(rad1 == 2) {
					System.out.println("Parameter Of Rectangle:" + cr.calculatePerimeter());
				}else {
					System.out.println("Choose 1 or 2 options");
				}
				
				
			
				break;
			case 3:
				System.out.print("Enter side: ");
				double sp=sc.nextDouble();
				squaree Sp=new squaree(sp);
				System.out.println("What would you like to do ");
				System.out.println("1: Area");
				System.out.println("2: Perimeter");
				System.out.print("Choose: ");
				
				int side = sc.nextInt();
				if(side == 1) {
					System.out.println("Area Of Rectangle: " + Sp.calculateArea());
				}else if(side == 2) {
					System.out.println("Parameter Of Rectangle:" + Sp.calculatePerimeter());
				}else {
					System.out.println("Choose 1 or 2 options");
				}
				
						
				
				break;
			case 4:
				System.out.print("Enter Base: ");
				double base = sc.nextDouble();
				System.out.print("Enter height: ");
				double hgh = sc.nextDouble();
				trianglee Tr=new trianglee(base, hgh);
				System.out.println("What would you like to do ");
				System.out.println("1: Area");
				System.out.println("2: Perimeter");
				System.out.print("Choose: ");
				
				int basee = sc.nextInt();
				if(basee == 1) {
					System.out.println("Area Of Rectangle: " + Tr.calculateArea());
				}else if(basee == 2) {
					System.out.println("Parameter Of Rectangle:" + Tr.calculatePerimeter());
				}else {
					System.out.println("Choose 1 or 2 options");
				}
		
				break;
			default:
				System.out.println("Invalid selection");
				break;
			}



















			System.out.print("Would You Like to continue y/n: ");
			choice = sc.next().toLowerCase().charAt(0);
		}
		while (choice == 'y');
	}

}
