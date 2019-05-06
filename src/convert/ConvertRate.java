package convert;

import org.jetbrains.annotations.Contract;

import java.math.BigDecimal;

/**
 * @author kozlov_ya
 * @created 26.04.19
 */

/*
 Класс-enum хранящий соотношения валют к доллару
 */

public enum ConvertRate {

    RUB(BigDecimal.valueOf(0.015)),
    USD(BigDecimal.valueOf(1)),
    EUR(BigDecimal.valueOf(1.11)),
    GBP(BigDecimal.valueOf(1.29)),
    YEN(BigDecimal.valueOf(0.009));

    public final BigDecimal value;

    @Contract(pure = true)
    ConvertRate(BigDecimal value) {
        this.value = value;
    }

    @Contract(pure = true)
    public BigDecimal getValue() {
        return value;
    }
}
