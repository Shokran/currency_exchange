package convert;

import currency.Currency;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author kozlov_ya
 * @created 28.05.19
 */

public class Convert {

    private BigDecimal sumCurrencyConvert;

    public Convert(@NotNull Currency currencyConvertFrom,
                   @NotNull Currency currencyConvertTo,
                   @NotNull BigDecimal currencyAmount) {

        BigDecimal rateConvertFrom;
        BigDecimal rateConvertTo;

        rateConvertFrom = ConvertRate.valueOf(currencyConvertFrom.currencyAbbreviation()).getValue();
        rateConvertTo = ConvertRate.valueOf(currencyConvertTo.currencyAbbreviation()).getValue();

        BigDecimal currencyAmountToUsd;
        BigDecimal sumCurrencyConvert;

        currencyAmountToUsd = currencyAmount.multiply(rateConvertFrom);
        sumCurrencyConvert = currencyAmountToUsd.divide(rateConvertTo, 2, RoundingMode.HALF_UP);
        this.sumCurrencyConvert = sumCurrencyConvert;
    }

    public BigDecimal getSumCurrencyConvert() {
        return sumCurrencyConvert;
    }
}
