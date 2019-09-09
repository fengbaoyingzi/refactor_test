package step;

public class Movie {
	private String _title;
	private Price _price;

	public Movie(String title, MovieType movieType) {
		_title = title;
		setMovieType(movieType);
	}

	public MovieType getMovieType() {
		return _price.getMovieType();
	}

	public String getTitle() {
		return _title;
	}

	public void setMovieType(MovieType movieType) {
		switch (movieType){
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
		return _price.getFrequentRenterPoints(daysRented);
	}

}