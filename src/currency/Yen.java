package currency;

public class Yen implements Currency {

    public String currencyName() {
        return "yen";
    }

    public String currencyAbbreviation() {
        return "YEN";
    }

    public String currencySign() {
        return "\u00A5";
    }
}
