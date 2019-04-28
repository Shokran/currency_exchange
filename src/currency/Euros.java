package currency;

public class Euros implements Currency {

    public String currencyName() {
        return "euro";
    }

    public String currencyAbbreviation() {
        return "EUR";
    }

    public String currencySign() {
        return "\u20AC";
    }
}
