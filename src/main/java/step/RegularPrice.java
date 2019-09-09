package step;

public class RegularPrice extends Price{
    MovieType getMovieType() {
        return MovieType.REGULAR;
    }

    double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}
