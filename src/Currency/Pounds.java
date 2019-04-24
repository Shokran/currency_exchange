package Currency;

public class Pounds implements Currency {

    public String currencyName() {
        return "pounds";
    }

    public String currencyAbbreviation() {
        return "GBP";
    }

    public String currencySign() {
        return "\u00A3";
    }
}
