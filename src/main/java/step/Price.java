package step;

abstract class Price {
    abstract MovieType getMovieType();

    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
