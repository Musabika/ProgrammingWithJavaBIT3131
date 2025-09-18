package caseOne;

public class TestRecta {

	//NAMES OF GROUP MEMBERS
	//1.MUSABIKA FIDELE 223003195
	//2.NISHIMWE SEZERANO DELICE 223010486
	//3.MUKAMA UYISENGA LEA 223018803
	//4.MUHAYIMPUNDU CHARLENNE 223003942
	//5.UWIMANA AMINA 223009215
	 private double length;
	    private double width;

	    public void insertLength(double length) {
	        this.length = length;
	    }

	    public void insertWidth(double width) {
	        this.width = width;
	    }
	    public boolean checkIfIsSquare() {
	        return length == width;
	    }
	    public  double calculateArea() {
	        return length * width;
	    }
}
