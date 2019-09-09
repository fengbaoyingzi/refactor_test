import org.testng.Assert;
import org.testng.annotations.Test;
import step.Customer;
import step.Movie;
import step.Rental;

public class CustomerTest1 {

	@Test
	public void testStatement() {
		Customer customer = new Customer("xiaoqiang");
		Movie movie = new Movie("哪吒", 2);
		Rental rental = new Rental(movie, 7);
		Movie movie2 = new Movie("当幸福来敲门", 1);
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
		Movie movie = new Movie("Spider-Man", 1);
		Rental rental = new Rental(movie, 3);
		double result = rental.getCharge();
		double expection = 9.0;
		Assert.assertEquals(result, expection);
	}

	@Test
	public void testGetChargeForChildren() {
		Movie movie = new Movie("Big-Hero-6", 2);
		Rental rental = new Rental(movie, 4);
		double result = rental.getCharge();
		double expection = 3.0;
		Assert.assertEquals(result, expection);

		Rental rental2 = new Rental(movie, 3);
		double result2 = rental2.getCharge();
		double expection2 = 1.5;
		Assert.assertEquals(result2, expection2);
	}

	@Test
	public void testGetChargeForRegular() {
		Movie movie = new Movie("Iron-Man", 0);
		Rental rental = new Rental(movie, 5);
		double result = rental.getCharge();
		double expection = 6.5;
		Assert.assertEquals(result, expection);

		Rental rental2 = new Rental(movie, 1);
		double result2 = rental2.getCharge();
		double expection2 = 2.0;
		Assert.assertEquals(result2, expection2);


	}
}
