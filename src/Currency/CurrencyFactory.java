package Currency;

import java.util.Optional;

/**
 * @author kozlov_ya
 * @created 24.05.19
 */

/*
 Класс представляющий из себя вспомогательный
 Основан на одноименном паттерне проектирования
 фабрика (по-русски так се звучит) в оригинале factory
 */

public class CurrencyFactory {

    public static Optional<Currency> getCurrency (String type) {

        type = type.toUpperCase(); // дополнительная придаём данным нужный регистр
        Currency toReturn = null;
        switch (type) {
            case "RUB":
                toReturn = new Rubles();
                break;
            case "USD":
                toReturn = new Dollars();
                break;
            case "EUR":
                toReturn = new Euros();
                break;
            case "GBP":
                toReturn = new Pounds();
                break;
            case "YEN":
                toReturn = new Yen();
                break;
        }
        return Optional.ofNullable(toReturn);
    }
}
