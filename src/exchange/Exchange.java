package exchange;

import convert.Convert;
import convert.ConvertRate;
import currency.Currency;
import currency.CurrencyFactory;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 25.05.19
 */

/*
 Данный класс освобождает исполняемый от хаоса
 Здесь разбиты по методам все основные шаги
 */

public class Exchange {

    private Scanner scanner;

    private Currency currencyConvertFrom, currencyConvertTo;
    private BigDecimal currencyAmount;

    public Exchange() {

        scanner = new Scanner(System.in); // создаём сканнер

        System.out.println("Добро пожаловать в раздел обмена валют");
    }

    public void process() throws InterruptedException {

        availableCurrencies();
        currencyFrom();
        currencyAmount();
        System.out.println(currencyAmount.scale());
        currencyTo();
        waitingForUser();
        convert(currencyConvertFrom, currencyConvertTo, currencyAmount);
        approveConvert();
        approveRepeat();
    }

    private void availableCurrencies() {
        System.out.println("Для обмена Вам доступны: ");
        System.out.println(Arrays.toString(ConvertRate.values())
                .replace("[", "")
                .replace("]", ""));
    }

    private void currencyFrom() {
        // вводим валюту, которую хотим обменять
        System.out.println("Введите валюту которую хотите обменять:");
        Optional<Currency> currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
        while (!currencyConvertFrom.isPresent()) {
            System.out.println("Не верно введена валюта, пожалуйста, повторите ввод");
            currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
        }
        this.currencyConvertFrom = currencyConvertFrom.get();
    }

    private void currencyAmount() {
        ExchangeValidation validationAmount = new ExchangeValidation();
        validationAmount.validateAmount();
        validationAmount.validateNull();
        currencyAmount = validationAmount.getCurrencyAmount();

    }

    private void currencyTo() {
        // вводим валюту, которую хотим купить
        System.out.println("Введите валюту для обмена:");
        Optional<Currency> currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
        while (!currencyConvertTo.isPresent()) {
            System.out.println("Не верно введена валюта, пожалуйста, повторите ввод");
            currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
        }
        this.currencyConvertTo = currencyConvertTo.get();
        // валидируем момент того что клиент мог ввести две одинаковые валюты
        if (currencyConvertFrom.currencyName().equals(this.currencyConvertTo.currencyName())) {
            System.out.println("Валюту нельзя обменять саму на себя!");
            currencyTo();
        }
    }

    private void waitingForUser() throws InterruptedException {
        // фраза из условия задачи
        System.out.println("Немного терпения...");
        Thread.sleep(2000); // ожидание (для вида)
    }

    private void convert(@NotNull Currency currencyFrom,
                         @NotNull Currency currencyTo,
                         BigDecimal currencyAmount) throws InterruptedException {

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

    private void approveConvert() {

        ExchangeValidation validationConvert = new ExchangeValidation();
        validationConvert.yesOrNO();
        if (validationConvert.getConfirmRepeat().equals("y")) {
            processedConvert(currencyConvertFrom, currencyConvertTo, currencyAmount);
        }
    }

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

    private void approveRepeat() throws InterruptedException {

        System.out.println("Хотите обменять еще?");
        ExchangeValidation validationRepeat = new ExchangeValidation();
        validationRepeat.yesOrNO();
        if (validationRepeat.getConfirmRepeat().equals("y")) {
            process();
        } if (validationRepeat.getConfirmRepeat().equals("n")) {
            System.out.println("Спасибо за посещение нашего банкомата");
        }
    }
}