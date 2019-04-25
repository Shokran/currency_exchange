package Currency;

import java.math.BigDecimal;

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

    public BigDecimal currencyToUsd() {
        return BigDecimal.valueOf(0.015);
    }
}
