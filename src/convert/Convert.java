package convert;

import currency.Currency;

import java.math.BigDecimal;

/**
 * @author kozlov_ya
 * @created 28.05.19
 */

public class Convert {

    private BigDecimal sumCurrencyConvert;

    public Convert(Currency currencyConvertFrom,
                   Currency currencyConvertTo,
                   BigDecimal currencyAmount) {

        BigDecimal rateConvertFrom;
        BigDecimal rateConvertTo;

        rateConvertFrom = ConvertRate.valueOf(currencyConvertFrom.currencyAbbreviation()).getValue();
        rateConvertTo = ConvertRate.valueOf(currencyConvertTo.currencyAbbreviation()).getValue();

        BigDecimal currencyAmountToUsd;
        BigDecimal sumCurrencyConvert;

        currencyAmountToUsd = currencyAmount.multiply(rateConvertFrom);
        sumCurrencyConvert = currencyAmountToUsd.divide(rateConvertTo, 2);
        this.sumCurrencyConvert = sumCurrencyConvert;
    }

    public BigDecimal getSumCurrencyConvert() {
        return sumCurrencyConvert;
    }
}
