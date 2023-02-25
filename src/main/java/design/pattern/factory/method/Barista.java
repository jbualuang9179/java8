package design.pattern.factory.method;

public class Barista {

    public Beverage order(String beverageType) {

        if (beverageType.equals("coffee")) {
            return new Coffee();
        } else if (beverageType.equals("greentea")) {
            return new Greentea();
        } else if (beverageType.equals("cola")) {
            return new Cola();
        }

        return null;
    }
}
