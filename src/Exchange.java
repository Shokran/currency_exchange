import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import Currency.CurrencyList;
import Support.Perform;

public class Exchange {
    public static void main (String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in); // создаём сканнер для

        String currencyConvertFrom, currencyConvertTo, confirmConvert, confirmRepeat;
        BigDecimal amountConvertFrom;

        do {
            do {
                System.out.println("Введите валюту которую хотите обменять:");
                currencyConvertFrom = scanner.next(); // вводим валюту которую хотим обменять
                currencyConvertFrom = new Perform().performInputCurrency(currencyConvertFrom);
                System.out.println(currencyConvertFrom);
//                boolean contains = Arrays.stream(CurrencyList.values()).anyMatch(currencyConvertFrom::equals);
                boolean contains = Arrays.asList(CurrencyList.values()).contains(currencyConvertFrom);

                System.out.println("Введите сумму:");
                amountConvertFrom = scanner.nextBigDecimal(); // вводим сумму которую хотим обменять

                System.out.println("Введите валюту для обмена:");
                currencyConvertTo = scanner.next(); // вводим валюту которую хотим получить
                currencyConvertTo = new Perform().performInputCurrency(currencyConvertTo);
                System.out.println(currencyConvertTo);

                System.out.println("Немного терпения...");
                Thread.sleep(2000); // ожидание (для вида)

                System.out.println("Вы действительно хотите купить 1.50 $ за " + amountConvertFrom + " \u20BD ?");
                System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
                confirmConvert = scanner.next(); // ввод подтверждения
                confirmConvert = new Perform().performInputConfirm(confirmConvert);
            } while (confirmConvert.equals("n"));


            System.out.println("Вы совершили обмен: Купили 1.50 \u0024 за " + amountConvertFrom + " \u20BD.");

            System.out.println("Хотите обменять еще?");
            System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
            confirmRepeat = scanner.next();
            confirmRepeat = new Perform().performInputConfirm(confirmRepeat);
            System.out.println(confirmRepeat);
        } while (confirmRepeat.equals("y"));

        System.out.println("Спасибо за посещение нашего банкомата");


    }
}