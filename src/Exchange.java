import java.math.BigDecimal;
import java.util.Scanner;

public class Exchange {
    public static void main (String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in); // создаём сканнер для

        String currencyConvertFrom, currencyConvertTo, confirmConvert, confirmRepeat;
        BigDecimal amountConvertFrom;

        do {
            System.out.println("Введите валюту которую хотите обменять:");
            currencyConvertFrom = scanner.next(); // вводим валюту которую хотим обменять
            System.out.println("Введите сумму:");
            amountConvertFrom = scanner.nextBigDecimal(); // вводим сумму которую хотим обменять
            System.out.println("Введите валюту для обмена:");
            currencyConvertTo = scanner.next(); // вводим
            System.out.println("Немного терпения...");
            Thread.sleep(2000);
            System.out.println("Вы действительно хотите купить 1.50 $ за " + amountConvertFrom + " \u20BD ?");
            System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
            confirmConvert = scanner.next(); // ввод подтверждения
            System.out.println("Вы совершили обмен: Купили 1.50 $ за " + amountConvertFrom + " \u20BD.");
            System.out.println("Хотите обменять еще?");
            System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
            confirmRepeat = scanner.next();
            if (confirmRepeat.equals(confirmRepeat.toLowerCase())) {
                confirmRepeat = confirmRepeat;
            }
            if (confirmRepeat.equals(confirmRepeat.toUpperCase())) {
                confirmRepeat = confirmRepeat.toLowerCase();
            } else {throw new RuntimeException("По-другому ввести невозможно");}
            // Ожидание ввода
        } while (confirmRepeat.equals("y"));
        System.out.println("Спасибо за посещение нашего банкомата");


    }
}

//System.out.println("€\n" +
//        "¥\n" +
//        "$");