import Control.ControlUtils;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 16.05.19
 */

public class Exchange {

    private Scanner scanner = new Scanner(System.in); // создаём сканнер для

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in); // создаём сканнер для

        String confirmConvert, confirmRepeat;
        BigDecimal amountConvertFrom;

        ControlUtils exchange = new ControlUtils();

        System.out.println("Добро пожаловать в раздел обмена валют");
        System.out.println("Для обмена Вам доступны: " + "Список в разработке...");

        do {
            do {

                exchange.enterCurrencyFrom();
                exchange.enterCurrencyAmmount();
                exchange.enterCurrencyTo();
                exchange.waitingForUser();
                exchange.approveConvert();


            } while (confirmConvert.equals("n"));


//            System.out.println("Вы совершили обмен: Купили 1.50 "
//                    + currencyConvertFrom.get().currencySign() +
//                    " за " + amountConvertFrom
//                    + currencyConvertTo.get().currencySign());

            System.out.println("Хотите обменять еще?");
            System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
            confirmRepeat = scanner.next().toLowerCase();
        } while (confirmRepeat.equals("y"));

        System.out.println("Спасибо за посещение нашего банкомата");

    }
}