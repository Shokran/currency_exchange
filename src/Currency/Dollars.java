package Currency;

import java.math.BigDecimal;

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

    public BigDecimal currencyToUsd() {
        return BigDecimal.valueOf(1);
    }
}