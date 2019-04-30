package exchange;

import currency.Currency;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 29.05.19
 */

class ExchangeValidation {

    private String confirmRepeat;
    private BigDecimal currencyAmount;

    // метод для вопроса типа ответь "y" или "n"
    void yesOrNO() {

        Scanner scanner = new Scanner(System.in); // создаём сканнер
        String confirm;
        do {
            System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
            confirm = scanner.next().toLowerCase(); // ввод подтверждения с переводом с нужный регистр
            if (!confirm.equals("y") && !confirm.equals("n")) {
                System.out.println("Неверный ввод, повторите попытку.");
            }
        } while (!confirm.equals("y") && !confirm.equals("n"));
        this.confirmRepeat = confirm;
    }
    // метод для возврата ответа "y" или "n"
    String getConfirmRepeat() {
        return confirmRepeat;
    }

    // метод валидации вводимой суммы
    void validateAmount() {

        Scanner scanner = new Scanner(System.in);
        BigDecimal amount = null;
        // вводим сумму, которую хотим обменять
        System.out.println("Введите сумму:");
        // проверяем вводимый формат
        if (scanner.hasNextBigDecimal()) {
            amount = scanner.nextBigDecimal();
        } else {
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        }
        if (amount.scale() > 2) {
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        }

        this.currencyAmount = amount;
    }

    void validateNull() {
        if (getCurrencyAmount().scale() > 2) {
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        }
        this.currencyAmount = getCurrencyAmount();
    }
    // метод возврата введённой суммы
    BigDecimal getCurrencyAmount() {
        return currencyAmount;
    }
}
