package Currency;

import java.math.BigDecimal;

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

    public BigDecimal currencyToUsd() {
        return BigDecimal.valueOf(1.29);
    }
}
