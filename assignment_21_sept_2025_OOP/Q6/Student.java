package assignment_21_sept_2025_OOP.Q6;

public class Student {
    private final String studentNames;
    private Book bookBorrowed;
    public Student(String studentNames) {
        this.studentNames = studentNames;
        this.bookBorrowed = null;
    }


    public Book getBookBorrowed() {
        return bookBorrowed;
    }
    public void setBookBorrowed(Book bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }
    public String getStudentNames() {
        return studentNames;
    }
}
