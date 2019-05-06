package convert;

import currency.Currency;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author kozlov_ya
 * @created 28.04.19
 */

/*
 Класс отвечающий за саму конвертацию валют
 */

public class Convert {

    private BigDecimal sumCurrencyConvert;

    public Convert(@NotNull Currency currencyConvertFrom,
                   @NotNull Currency currencyConvertTo,
                   @NotNull BigDecimal currencyAmount) {

        BigDecimal rateConvertFrom;
        BigDecimal rateConvertTo;

        // вычисляем курс валюты продажи к доллару
        rateConvertFrom = ConvertRate.valueOf(currencyConvertFrom.currencyAbbreviation()).getValue();
        // вычисляем курс доллара к валюте конвертации
        rateConvertTo = ConvertRate.valueOf(currencyConvertTo.currencyAbbreviation()).getValue();

        BigDecimal currencyAmountToUsd;
        BigDecimal sumCurrencyConvert;

        // переводим валюту продажи в доллары
        currencyAmountToUsd = currencyAmount.multiply(rateConvertFrom);
        // переводим доллары в валюту конвертации с выводом двух знаков после запятой и применением округления
        sumCurrencyConvert = currencyAmountToUsd.divide(rateConvertTo, 2, RoundingMode.HALF_UP);
        // присваиваем получившееся после арифметических действий значение переменной
        this.sumCurrencyConvert = sumCurrencyConvert;
    }

    // метод возвращающий отконвертированную сумму
    public BigDecimal getSumCurrencyConvert() {
        return sumCurrencyConvert;
    }
}
