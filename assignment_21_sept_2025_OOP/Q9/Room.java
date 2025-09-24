package assignment_21_sept_2025_OOP.Q9;

public class Room {
    private final int roomNumber;
    private final String type;
    private double price;
    private double nightBooked;
    private String bookedGuest;
    private double discount;

    public Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.nightBooked = 0;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public void  bookRoom(double stayNight, String guestNAme) {
        if(stayNight <= this.nightBooked) {
            System.out.println("Room number is already booked");
        }else if(guestNAme.equalsIgnoreCase(this.bookedGuest)) {
            this.nightBooked += stayNight;
            System.out.println("Your Night Has been Extended to" + stayNight + " nights");
            System.out.println("Your Stay Now:  " + this.nightBooked + " nights from now");
            calculateDiscount();
            displayRoomDetails();
        } else {
            this.bookedGuest = guestNAme;
            this.nightBooked = stayNight;
            calculateDiscount();
            displayRoomDetails();
        }
    }
    public void displayRoomDetails() {
        System.out.println("Room Number: " + this.roomNumber);
        System.out.println("Type: " + this.type);
        System.out.println("Price: " + this.price);
        System.out.println("Night Booked: " + this.nightBooked);
        System.out.println("Booked Guest: " + this.bookedGuest);
    }
    private void calculateDiscount() {
        if (nightBooked > 5) {
            double discount = this.price * 0.15;
            price -= discount;
            System.out.println("Your Discount has been calculated to " + discount);
        } else {
            System.out.println("Discount is not applicable");
        }
    }
    public String getRoomType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
}
