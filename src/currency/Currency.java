package currency;

/**
 * @author kozlov_ya
 * @created 23.04.19
 */

/*
 Интерфейс определяющий принадлежность к нему всех валют (классов валют)
 */

public interface Currency {
    String currencyName();
    String currencyAbbreviation();
    String currencySign();
}
