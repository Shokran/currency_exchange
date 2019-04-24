package Currency;

public class Dollars implements Currency {

    public String currencyName() {
        return "dollar";
    }

    public String currencyAbbreviation() {
        return "USD";
    }

    public String currencySign() {
        return "\u0024";
    }
}
