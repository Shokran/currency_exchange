package Currency;

import java.math.BigDecimal;

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

    public BigDecimal currencyToUsd() {
        return BigDecimal.valueOf(1.11);
    }
}
