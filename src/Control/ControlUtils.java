package Control;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Optional;

import Currency.Currency;
import Currency.CurrencyFactory;

/**
 * @author kozlov_ya
 * @created 25.05.19
 */

/*
 Данный класс освобождает исполняемый от хаоса
 Здесь разбиты по методам все основные шаги
 */
public class ControlUtils {

    private Scanner scanner = new Scanner(System.in);

    public void enterCurrencyFrom() {
        // вводим валюту, которую хотим обменять
        System.out.println("Введите валюту которую хотите обменять:");
        Optional<Currency> currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
        while (!currencyConvertFrom.isPresent()) {
            System.out.println("Не верно введена валюта, повторите ввод");
            currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
        }
    }

    public void enterCurrencyAmmount() {
        // вводим сумму, которую хотим обменять
        System.out.println("Введите сумму:");
        BigDecimal amountConvertFrom = scanner.nextBigDecimal(); // вводим сумму которую хотим обменять
    }

    public final void enterCurrencyTo() {
        // вводим валюту, которую хотим купить
        System.out.println("Введите валюту для обмена:");
        Optional<Currency> currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
        while (!currencyConvertTo.isPresent()) {
            System.out.println("Не верно введена валюта, повторите ввод");
            currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
        }
    }

    public final void waitingForUser() throws InterruptedException {
        // фраза из условия задачи
        System.out.println("Немного терпения...");
        Thread.sleep(2000); // ожидание (для вида)
    }

    public final void approveConvert() {

        System.out.println("Вы действительно хотите купить 1.50"
                + CurrencyFactory.getCurrency(enterCurrencyFrom()) +
                " за " + amountConvertFrom
                + currencyConvertTo.get().currencySign());
        System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
        confirmConvert = scanner.next().toLowerCase(); // ввод подтверждения
        }
    }
}
