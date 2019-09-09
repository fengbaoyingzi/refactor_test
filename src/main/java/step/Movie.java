package step;

public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public String getTitle() {
		return _title;
	}

	public void setPriceCode(int priceCode) {
		switch (priceCode){
			case REGULAR:
				_price = new RegularPrice();
				break;
			case CHILDREN:
				_price = new ChildrenPrice();
				break;
			case NEW_RELEASE:
				_price = new NewReleasePrice();
				break;
		}
	}

	public double getCharge(int daysRented){
		return _price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented){
		if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			return 2;
		return 1;
	}

}