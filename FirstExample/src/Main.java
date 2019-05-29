public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Movie firstMovie = new Movie();
        firstMovie.setTitle("alibaba and 40 thieves");
        firstMovie.setPriceCode(Movie.CHILDRENS);
        Movie secondMovie = new Movie();
        secondMovie.setTitle("Aladin");
        secondMovie.setPriceCode(Movie.CHILDRENS);
        Movie thirdMovie = new Movie();
        thirdMovie.setTitle("Fast and furious");
        thirdMovie.setPriceCode(Movie.REGULAR);
        Movie fourthMovie = new Movie();
        fourthMovie.setTitle("Avengers");
        fourthMovie.setPriceCode(Movie.NEW_RELEASE);
        Movie fifthMovie = new Movie();
        fifthMovie.setTitle("John Wicks");
        fifthMovie.setPriceCode(Movie.NEW_RELEASE);
        Movie sixthMovie = new Movie();
        sixthMovie.setTitle("ring ru");
        sixthMovie.setPriceCode(Movie.REGULAR);

        Rental firstRentel = new Rental(firstMovie, 5);
        Rental secondRentel = new Rental(secondMovie, 1);
        Rental thirdRentel = new Rental(thirdMovie, 3);
        Rental fourthRentel = new Rental(fourthMovie, 10);
        Rental fifthRentel = new Rental(fifthMovie, 20);

        Customer customer1 = new Customer("Huy");
        customer1.addRental(fifthRentel);
        customer1.addRental(secondRentel);

        System.out.println(customer1.statement());
    }
}
