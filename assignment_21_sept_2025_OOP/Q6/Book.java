package assignment_21_sept_2025_OOP.Q6;

public class Book {
    private final long isbn;
    private final String title;
    private final String author;
    private int quantity;

    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = (long) (Math.random() * 10_000_000_000L);
        this.quantity = quantity;
    }

    public long getIsbn() {
        return isbn;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public void borrowBook(Student student) {
        if (quantity < 0) {
            System.out.println("Book has been borrowed. is not available");
        } else if (student.getBookBorrowed() != null) {
            System.out.println("Return The book " + student.getBookBorrowed().getTitle() + " Inorder to Borrow Another one");
        }else {
            this.quantity -= 1;
            student.setBookBorrowed(this);
            displayBookDetails(student,"Book Borrowed Details");
        }
    }
    public void returnBook(Student student, long isbn) {
        if (this.isbn != isbn) {
            System.out.println("This is not the book you borrowed");
            System.out.println("Return The book " + student.getBookBorrowed().getTitle() + " instead");
        } else {
            this.quantity += 1;
            student.setBookBorrowed(null);
            displayBookDetails(student,"Book Returned Details");
        }

    }
    public void displayBookDetails(Student student, String heading) {
        System.out.println(heading);
        System.out.println("Title: " + student.getBookBorrowed().getTitle());
        System.out.println("Author: " + student.getBookBorrowed().getAuthor());
        System.out.println("Isbn: " + student.getBookBorrowed().getIsbn());
        System.out.println("Student Names: " + student.getStudentNames() );
    }


}
