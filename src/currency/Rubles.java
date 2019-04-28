package currency;

public class Rubles implements Currency {

    public String currencyName() {
        return "ruble";
    }

    public String currencyAbbreviation() {
        return "RUB";
    }

    public String currencySign() {
        return "\u20BD";
    }
}
