package Currency;

import java.math.BigDecimal;

/**
 * @author kozlov_ya
 * @created 23.05.19
 */

/*
 Интерфейс определяющий принадлежность к нему всех валют (классов валют)
 */

public interface Currency {
    public String currencyName();
    public String currencyAbbreviation();
    public String currencySign();
    public BigDecimal currencyToUsd();
}
