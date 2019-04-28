import currency.CurrencyFactory;
import currency.Currency;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 16.05.19
 */

public class Exchange {

    private static Scanner scanner = new Scanner(System.in); // создаём сканнер

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Добро пожаловать в раздел обмена валют");
        System.out.println("Для обмена Вам доступны: " + "Список в разработке...");

        do {
            do {
                Optional<Currency> currencyFrom = getCurrencyFrom();
                BigDecimal currencyAmount = getCurrencyAmount();
                Optional<Currency> currencyTo = getCurrencyTo();
                waitingForUser();
                String approveConvert = getApproveConvert(currencyFrom, currencyTo, currencyAmount);
            } while (approveConvert.equals("y"));
            String processedConvert = getProcessedConvert(currencyFrom, currencyTo, currencyAmount);
        } while (processedConvert.equals("n"));

        System.out.println("Спасибо за посещение нашего банкомата");
    }

    private static Optional<Currency> getCurrencyFrom() {
        // вводим валюту, которую хотим обменять
        System.out.println("Введите валюту которую хотите обменять:");
        Optional<Currency> currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
        while (!currencyConvertFrom.isPresent()) {
            System.out.println("Не верно введена валюта, пожалуйста, повторите ввод");
            currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
        }
        return currencyConvertFrom;
    }

    private static BigDecimal getCurrencyAmount() {
        // вводим сумму, которую хотим обменять
        System.out.println("Введите сумму:");
        return scanner.nextBigDecimal(); // вводим сумму которую хотим обменять
    }

    private static Optional<Currency> getCurrencyTo() {
        // вводим валюту, которую хотим купить
        System.out.println("Введите валюту для обмена:");
        Optional<Currency> currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
        while (!currencyConvertTo.isPresent()) {
            System.out.println("Не верно введена валюта, пожалуйста, повторите ввод");
            currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
        }
        return currencyConvertTo;
    }

    private static void waitingForUser() throws InterruptedException {
        // фраза из условия задачи
        System.out.println("Немного терпения...");
        Thread.sleep(2000); // ожидание (для вида)
    }

    @NotNull
    private static String getApproveConvert(Optional<Currency> currencyFrom,
                                            Optional<Currency> currencyTo,
                                            BigDecimal currencyAmount) {

        currencyFrom.ifPresent(currencyF ->
                currencyTo.ifPresent(
                        currencyT -> System.out.println(
                                "Вы действительно хотите купить 1.50" +
                                        currencyF.currencySign() +
                                        " за " + currencyAmount
                                        + currencyT.currencySign()
                                        + "?"
                        )));
        System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
        return scanner.next().toLowerCase(); // ввод подтверждения
    }

    @NotNull
    private static String getProcessedConvert(Optional<Currency> currencyFrom,
                                              Optional<Currency> currencyTo,
                                              BigDecimal currencyAmount) {

        currencyFrom.ifPresent(currencyF ->
                currencyTo.ifPresent(
                        currencyT -> System.out.println("Вы совершили обмен: Купили 1.50 " +
                                currencyF.currencySign() +
                                " за " + currencyAmount
                                + currencyT.currencySign()
                        )));
        System.out.println("Хотите обменять еще?");
        System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
        return scanner.next().toLowerCase(); // ввод подтверждения
    }

}