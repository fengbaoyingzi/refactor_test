import org.testng.Assert;
import org.testng.annotations.Test;
import step.Customer;
import step.Movie;
import step.MovieType;
import step.Rental;

public class CustomerTest1 {

	@Test
	public void testStatement() {
		Customer customer = new Customer("xiaoqiang");
		Movie movie = new Movie("哪吒", MovieType.CHILDREN);
		Rental rental = new Rental(movie, 7);
		Movie movie2 = new Movie("当幸福来敲门", MovieType.NEW_RELEASE);
		Rental rental2 = new Rental(movie2, 4);
		customer.addRental(rental);
		customer.addRental(rental2);
		String result = customer.statement();
		String expection = "Rental Record for xiaoqiang\n";
		expection += "\t哪吒\t7.5\n";
		expection += "\t当幸福来敲门\t12.0\n";
		expection += "Amount owed is 19.5\n";
		expection += "You earned 3 frequent renter points";
		System.out.println(result);
		System.out.println(expection);
		Assert.assertEquals(result, expection);
	}

	@Test
	public void testGetChargeForNewRelease() {
		Movie movie = new Movie("Spider-Man", MovieType.NEW_RELEASE);
		Rental rental = new Rental(movie, 3);
		double result = rental.getCharge();
		Assert.assertEquals(result, 9.0);
	}

	@Test
	public void testGetChargeForChildren() {
		Movie movie = new Movie("Big-Hero-6", MovieType.CHILDREN);
		Rental rental = new Rental(movie, 4);
		double result = rental.getCharge();
		Assert.assertEquals(result, 3.0);

		Rental rental2 = new Rental(movie, 3);
		double result2 = rental2.getCharge();
		Assert.assertEquals(result2, 1.5);
	}

	@Test
	public void testGetChargeForRegular() {
		Movie movie = new Movie("Iron-Man", MovieType.REGULAR);
		Rental rental = new Rental(movie, 5);
		double result = rental.getCharge();
		Assert.assertEquals(result, 6.5);

		Rental rental2 = new Rental(movie, 1);
		double result2 = rental2.getCharge();
		Assert.assertEquals(result2, 2.0);
	}

	@Test
	public void testGetFrequentRenterPoints() {
		Movie movie = new Movie("Iron-Man", MovieType.REGULAR);
		Rental rental = new Rental(movie, 5);
		int result = rental.getFrequentRenterPoints();
		Assert.assertEquals(result, 1);
	}
}
