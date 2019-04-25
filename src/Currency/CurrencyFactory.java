package Currency;

public class CurrencyFactory {

    public Currency getCurrency (CurrencyList type) {
        Currency toReturn = null;
        switch (type) {
            case RUB:
                toReturn = new Rubles();
                break;
            case USD:
                toReturn = new Dollars();
                break;
            case EUR:
                toReturn = new Euros();
                break;
            case GBP:
                toReturn = new Pounds();
                break;
            case YEN:
                toReturn = new Yen();
                break;
            default:
                throw new IllegalArgumentException("Неправильный тип валюты: " + type);
        }
        return toReturn;
    }
}
