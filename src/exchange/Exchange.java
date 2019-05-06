package exchange;

import convert.Convert;
import convert.ConvertRate;
import currency.Currency;
import org.jetbrains.annotations.NotNull;
import validate.ValidateAmount;
import validate.ValidateCurrency;
import validate.ValidateYesOrNo;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author kozlov_ya
 * @created 25.04.19
 */

/*
 Данный класс освобождает исполняемый от хаоса
 Здесь разбиты по методам все основные шаги
 Валидации вводимых значений унесены в собственные классы
 */

public class Exchange {

    private Currency currencyConvertFrom, currencyConvertTo; // переменные вводимых валют
    private BigDecimal currencyAmount; // переменная суммы

    private ValidateCurrency validateCurrency = new ValidateCurrency(); // объявление валидации валют

    public Exchange() {

        System.out.println("Добро пожаловать в раздел обмена валют");
    }

    public void process() throws InterruptedException {

        availableCurrencies();
        currencyFrom();
        currencyAmount();
        currencyTo();
        waitingForUser();
        convert(currencyConvertFrom, currencyConvertTo, currencyAmount);
        approveConvert();
        approveRepeat();
    }

    // метод перечисления доступных для обмена валют
    private void availableCurrencies() {
        System.out.println("Для обмена Вам доступны: ");
        System.out.println(Arrays.toString(ConvertRate.values())
                .replace("[", "")
                .replace("]", ""));
    }

    // метод ввода валюты продажи
    private void currencyFrom() {

        validateCurrency.validateCurrencyFrom();
        currencyConvertFrom = validateCurrency.getCurrencyConvertFrom();
    }

    // метод ввода продаваемой суммы
    private void currencyAmount() {

        ValidateAmount validationAmount = new ValidateAmount();
        validationAmount.validateAmount();
        currencyAmount = validationAmount.getCurrencyAmount();
    }

    // метод ввода валюты конвертации
    private void currencyTo() {

        validateCurrency.validateCurrencyTo();
        currencyConvertTo = validateCurrency.getCurrencyConvertTo();
    }

    // вспомогательный метод из условия задачи
    private void waitingForUser() throws InterruptedException {
        // фраза из условия задачи
        System.out.println("Немного терпения...");
        Thread.sleep(2000); // ожидание (для вида)
    }

    // метод вывода вопроса о желании обменять вводимые валюты и суммы
    private void convert(@NotNull Currency currencyFrom,
                         @NotNull Currency currencyTo,
                         BigDecimal currencyAmount) {

        System.out.println("Вы действительно хотите купить "
                        + new Convert(currencyConvertFrom,
                        currencyConvertTo,
                        currencyAmount).getSumCurrencyConvert()
                        + currencyTo.currencySign()
                        + " за "
                        + currencyAmount
                        + currencyFrom.currencySign()
                        + " ?");
    }

    // метод подтверждения вопроса об обмене
    private void approveConvert() {

        ValidateYesOrNo validationConvert = new ValidateYesOrNo();
        validationConvert.yesOrNO();
        if (validationConvert.getConfirmRepeat().equals("y")) {
            processedConvert(currencyConvertFrom, currencyConvertTo, currencyAmount);
        }
    }

    // метод констатирующий факт покупки
    private void processedConvert(@NotNull Currency currencyFrom,
                                  @NotNull Currency currencyTo,
                                  BigDecimal currencyAmount) {

        System.out.println("Вы совершили обмен: Купили "
                + new Convert(currencyConvertFrom,
                currencyConvertTo,
                currencyAmount).getSumCurrencyConvert()
                + currencyTo.currencySign()
                + " за "
                + currencyAmount
                + currencyFrom.currencySign());
    }

    // метод предложения повторного обмена
    private void approveRepeat() throws InterruptedException {

        System.out.println("Хотите обменять еще?");
        ValidateYesOrNo validationRepeat = new ValidateYesOrNo();
        validationRepeat.yesOrNO();
        if (validationRepeat.getConfirmRepeat().equals("y")) {
            process();
        } if (validationRepeat.getConfirmRepeat().equals("n")) {
            System.out.println("Спасибо за посещение нашего банкомата");
        }
    }
}