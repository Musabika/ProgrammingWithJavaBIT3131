package assignment_21_sept_2025_OOP.Q9;

import java.util.Scanner;

public class HotelManager {
    public static final  Room[] rooms = {
            new StandardRoom(1, "Standard", 12000),
            new Deluxe(2, "Deluxe", 12000),
            new Suite(3, "Suite", 12000),
    };
    public static Scanner scanner = new Scanner(System.in);
    public static char ch;
    public static void main(String[] args) {
        System.out.print("Enter Your name: ");
        String name = scanner.nextLine();
       do {
           System.out.println("Below Are Rooms In hotels");
           System.out.println("Which Room Number You want to book ?");
           for (Room room : rooms) {
               System.out.println(room.getRoomNumber() + ": " + room.getRoomType());
           }
           System.out.print("Choose Room Number: ");
           int roomNumber = scanner.nextInt();

           for (Room room : rooms) {
               if (room.getRoomNumber() == roomNumber) {
                   System.out.println("You are going to book room " + room.getRoomNumber());
                   System.out.println("The Price of Room " + room.getRoomType() + " is $" + room.getPrice());
                   System.out.print("Enter nights to stay: ");
                   double nights = scanner.nextDouble();
                   room.bookRoom(nights, name);
               }
           }
           System.out.print("Do you want to book another room y/n ?: ");
           ch = scanner.next().charAt(0);
       } while (ch == 'y');
       scanner.close();
    }

}
