package step;

public class ChildrenPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}
