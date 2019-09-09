package step;

public class ChildrenPrice extends Price {
    MovieType getMovieType() {
        return MovieType.CHILDREN;
    }

    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
