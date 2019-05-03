package exchange;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 29.05.19
 */

class ExchangeValidation {

    private String confirmRepeat;
    private BigDecimal currencyAmount;

//    // метод для вопроса типа ответь "y" или "n"
//    void yesOrNO() {
//
//        Scanner scanner = new Scanner(System.in); // создаём сканнер
//        String confirm;
//        do {
//            System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
//            confirm = scanner.next().toLowerCase(); // ввод подтверждения с переводом с нужный регистр
//            if (!confirm.equals("y") && !confirm.equals("n")) {
//                System.out.println("Неверный ввод, повторите попытку.");
//            }
//        } while (!confirm.equals("y") && !confirm.equals("n"));
//        this.confirmRepeat = confirm;
//    }
//    // метод для возврата ответа "y" или "n"
//    String getConfirmRepeat() {
//        return confirmRepeat;
//    }

//    // метод валидации вводимой суммы
//    void validateAmount() {
//        System.out.println("Введите сумму:");
//        validateAmountIsNum();
//        validateLessDecimalValue();
//    }
//
//    private void validateAmountIsNum() {
//        // вводим сумму, которую хотим обменят
//        Scanner scanner = new Scanner(System.in);
//        BigDecimal amount = null;
//        // проверяем вводимый формат
//        if (scanner.hasNextBigDecimal()) {
//            amount = scanner.nextBigDecimal();
//        } else {
//            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
//            validateAmount();
//        }
//        this.currencyAmount = amount;
//    }
//
//    private void validateLessDecimalValue() {
//        if (getCurrencyAmount().scale() > 2) {
//            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
//            validateAmount();
//        }
//        this.currencyAmount = getCurrencyAmount();
//    }
//    // метод возврата введённой суммы
//    BigDecimal getCurrencyAmount() {
//        return currencyAmount;
//    }
}
