package validate;

import currency.Currency;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 30.05.19
 */

// метод валидации вводимой суммы
public class ValidateAmount {

    private BigDecimal currencyIsNum;
    private BigDecimal currencyIsNotNull;
//    private BigDecimal currencyIsPositive;
    private BigDecimal currencyAmount;

    // основной публичный метод, где собраны все приватные
    public void validateAmount() {
        System.out.println("Введите сумму:");
        validateAmountIsNum();
        validateAmountNotNull(currencyIsNum);
//        validateAmountPositive(currencyIsNotNull);
        validateLessDecimalValue(currencyIsNotNull);
    }

    // проверяем, что вводимое значение является суммой нужного формата
    private void validateAmountIsNum() {
        // вводим сумму, которую хотим обменят
        Scanner scanner = new Scanner(System.in);
        BigDecimal amountIsNum = null;
        // проверяем вводимый формат
        if (scanner.hasNextBigDecimal()) {
            amountIsNum = scanner.nextBigDecimal();
        } else {
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        }
        this.currencyIsNum = amountIsNum;
        System.out.println(amountIsNum);
    }

    // проверяем, что вводимое значение не является нулевым
    private void validateAmountNotNull (@NotNull BigDecimal amountNotNull) {
        if (amountNotNull.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        }
        this.currencyIsNotNull = amountNotNull;
        System.out.println(amountNotNull);
    }

//    private void validateAmountPositive(@NotNull BigDecimal amountPositive) {
//        if (amountPositive.compareTo(BigDecimal.ZERO) < 0) {
//            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
//            validateAmount();
//        }
//        this.currencyIsPositive = amountPositive;
//        System.out.println(amountPositive);
//    }

    private void validateLessDecimalValue(@NotNull BigDecimal amountLessDecimalValue) {
        if (amountLessDecimalValue.scale() > 2) {
            System.out.println(amountLessDecimalValue.scale());
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        }
        this.currencyAmount = amountLessDecimalValue;
        System.out.println(amountLessDecimalValue);
    }
    // метод возврата введённой суммы
    public BigDecimal getCurrencyAmount() {
        return currencyAmount;
    }
}
