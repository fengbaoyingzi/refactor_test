package step;

public class NewReleasePrice extends Price {
    MovieType getMovieType() {
        return MovieType.NEW_RELEASE;
    }

    double getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getFrequentRenterPoints(int daysRented){
        return (daysRented > 1) ? 2 : 1;
    }
}
