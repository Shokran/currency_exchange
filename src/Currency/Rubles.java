package Currency;

public class Rubles implements Currency {

    public String currencyName() {
        return "rubles";
    }

    public String currencyAbbreviation() {
        return "RUB";
    }

    public String currencySign() {
        return "\u20BD";
    }
}
