package convert;

import java.math.BigDecimal;

public enum ConvertRate {

    RUB(BigDecimal.valueOf(0.015)),
    USD(BigDecimal.valueOf(1)),
    EUR(BigDecimal.valueOf(1.11)),
    GBP(BigDecimal.valueOf(1.29)),
    YEN(BigDecimal.valueOf(0.0090));

    public final BigDecimal value;

    ConvertRate(BigDecimal value) {
        this.value = value;
    }
}
