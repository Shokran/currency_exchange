package validate;

import currency.Currency;
import currency.CurrencyFactory;

import java.util.Optional;
import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 01.05.19
 */

/*
 Класс валидирующий вводимые валюты
 Основные методы ничего не возвращает, отвечают за ввод и валидацию
 Для возврата интересующего значения создан специальный метод-getter
 */

public class ValidateCurrency {

    private Scanner scanner = new Scanner(System.in); // создаём сканнер

    private Currency currencyConvertFrom, currencyConvertTo; // переменные валют

    // метод валидации данных при вводе валюты продажи
    public final void validateCurrencyFrom() {
        // вводим валюту, которую хотим обменять
        System.out.println("Введите валюту которую хотите обменять:");
        Optional<Currency> currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
        while (!currencyConvertFrom.isPresent()) {
            System.out.println("Не верно введена валюта, пожалуйста, повторите ввод");
            currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
        }
        // присваиваем провалидированное значение переменной
        this.currencyConvertFrom = currencyConvertFrom.get();
    }

    // метод валидации данных при вводе валюты конвертации
    public final void validateCurrencyTo() {
        // вводим валюту, которую хотим купить
        System.out.println("Введите валюту для обмена:");
        Optional<Currency> currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
        while (!currencyConvertTo.isPresent()) {
            System.out.println("Не верно введена валюта, пожалуйста, повторите ввод");
            currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
        }
        // присваиваем провалидированное значение переменной
        this.currencyConvertTo = currencyConvertTo.get();
        // валидируем ввод двух одинаковых валют для обмена
        if (currencyConvertFrom.currencyName().equals(this.currencyConvertTo.currencyName())) {
            System.out.println("Валюту нельзя обменять саму на себя!");
            validateCurrencyTo();
        }
    }

    // метод возвращающий валюту продажи
    public Currency getCurrencyConvertFrom() {
        return currencyConvertFrom;
    }

    // метод возвращающий валюту конвертации
    public Currency getCurrencyConvertTo() {
        return currencyConvertTo;
    }
}
