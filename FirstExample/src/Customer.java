import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public String getName() {
        return _name;
    }

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg ) {
        _rentals.addElement(arg);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoint = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while(rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            thisAmount = amoutFor(each);
            // add frequent renter pointer
            frequentRenterPoint++;
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE) {
                frequentRenterPoint++;
            }
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) +"\n";
            totalAmount += thisAmount;
        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoint) + " frequent renter points";
        return result;
    }

    private double amoutFor(Rental rental) {
        double result = 0;
        switch(rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (rental.getDaysRented() > 2) {
                    result += (rental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (rental.getDaysRented() > 3) {
                    result += (rental.getDaysRented() - 3) * 1.5;
                }
        }
        return result;
    }
}
