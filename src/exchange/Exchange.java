package exchange;

import currency.Currency;
import currency.CurrencyFactory;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
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
    private String confirmConvert, confirmRepeat;

    public Exchange() {
        scanner = new Scanner(System.in); // создаём сканнер
        System.out.println("Добро пожаловать в раздел обмена валют");
        System.out.println("Для обмена Вам доступны: " + "Список в разработке...");
    }

    public void process() throws InterruptedException {

        currencyFrom();
        currencyAmount();
        currencyTo();
        waitingForUser();
        approveConvert(currencyConvertFrom, currencyConvertTo, currencyAmount);

        processedConvert(currencyConvertFrom, currencyConvertTo, currencyAmount);


        System.out.println("Спасибо за посещение нашего банкомата");
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
        // вводим сумму, которую хотим обменять
        System.out.println("Введите сумму:");
        currencyAmount = scanner.nextBigDecimal(); // вводим сумму которую хотим обменять
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
    }

    private void waitingForUser() throws InterruptedException {
        // фраза из условия задачи
        System.out.println("Немного терпения...");
        Thread.sleep(2000); // ожидание (для вида)
    }

    private void approveConvert(@NotNull Currency currencyFrom,
                                @NotNull Currency currencyTo,
                                BigDecimal currencyAmount) throws InterruptedException {
        String confirmConvert;

        System.out.println("Вы действительно хотите купить 1.50"
                + currencyFrom.currencySign()
                + " за "
                + currencyAmount
                + currencyTo.currencySign()
                + " ?");
        do {
            System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
            confirmConvert = scanner.next().toLowerCase(); // ввод подтверждения
            if (!confirmConvert.equals("y") && !confirmConvert.equals("n")) {
                System.out.println("Неверный ввод, повторите попытку");
            }
        } while (!confirmConvert.equals("y") && !confirmConvert.equals("n"));

        if (confirmConvert.equals("n")) {
            process();
        }
    }

    private void processedConvert(@NotNull Currency currencyFrom,
                                  @NotNull Currency currencyTo,
                                  BigDecimal currencyAmount) throws InterruptedException {
        String confirmRepeat;

        System.out.println("Вы совершили обмен: Купили 1.50"
                + currencyFrom.currencySign()
                + " за "
                + currencyAmount
                + currencyTo.currencySign());
        System.out.println("Хотите обменять еще?");
        System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
        confirmRepeat = scanner.next().toLowerCase(); // ввод подтверждения
        if (confirmRepeat.equals("y")) {
            process();
        }
    }
}