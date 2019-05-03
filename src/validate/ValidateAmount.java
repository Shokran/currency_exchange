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

    private BigDecimal currencyAmount;
    private BigDecimal currencyIsNum;

    public void validateAmount() {
        System.out.println("Введите сумму:");
        validateAmountIsNum();
        validateLessDecimalValue(currencyIsNum);
    }

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
        this.currencyAmount = amountIsNum;
    }

    private void validateLessDecimalValue(@NotNull BigDecimal amountLessDecimalValue) {
        if (amountLessDecimalValue.scale() > 2) {
            System.out.println(amountLessDecimalValue.scale());
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        }
        this.currencyAmount = amountLessDecimalValue;
    }
    // метод возврата введённой суммы
    public BigDecimal getCurrencyAmount() {
        return currencyAmount;
    }
}
