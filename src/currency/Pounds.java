package currency;

public class Pounds implements Currency {

    public String currencyName() {
        return "pound";
    }

    public String currencyAbbreviation() {
        return "GBP";
    }

    public String currencySign() {
        return "\u00A3";
    }
}
