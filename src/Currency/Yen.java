package Currency;

import java.math.BigDecimal;

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

    public BigDecimal currencyToUsd() {
        return BigDecimal.valueOf(0.0090);
    }
}
