package assignment_21_sept_2025_OOP.Q6;

import java.util.*;

public class LibraryManagementSystem {
    public static Scanner sc = new Scanner(System.in);
    public static char ch;
    public static Book[] books = {
            new Book("Programming With Jave", "Dr Bugingo", 2),
            new Book("Fundamental Accounting", "Dr Shema", 1),
            new Book("Data Structure And Algorithm", "Prince", 2)
    };
    public static List<Student> students = new ArrayList<>();
    public  static void main(String[] args) {
        System.out.println("Hi, Librarian!");
        System.out.println("Write The name of student who came for book concern");
        System.out.print("Student FullNames: ");
        String studentNames = sc.nextLine();
        Student student = new Student(studentNames);
        students.add(student);
        do {
            System.out.println("What would " + student.getStudentNames() + " would like to do?");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("What Book isbn would you like to borrow?");
                    for (Book value : books) {
                        System.out.println(value.getIsbn() + ": " + value.getTitle());
                    }
                    System.out.print("Write Book Isbn from Above Books: ");
                    long isbn = sc.nextLong();
                    Book book = getBook(isbn);
                    if (book != null) book.borrowBook(student);

                    break;
                case 2:
                    System.out.print("What Book isbn would you like to return?: ");
                    long isbn2 = sc.nextLong();
                    Book book2 = getBook(isbn2);
                    if (book2 != null) book2.returnBook(student, isbn2);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
            System.out.println("Do you want to continue (y/n): ");
            ch = sc.next().charAt(0);

        }while (ch != 'n');
        sc.close();
    }
    public static Book getBook(long isbn) {
        for(Book book : books) {
            if(book.getIsbn() == isbn) {
                return book;
            }
        }
        System.out.println("Book with ISBN " + isbn + " does not exist");
        return null;
    }
}
