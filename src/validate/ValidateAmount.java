package validate;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 30.04.19
 */

/*
 Класс валидирующий вводимое значение суммы обмена
 Основные методы ничего не возвращает, отвечают за ввод и валидацию
 Для возврата интересующего значения создан специальный метод-getter
 */

public class ValidateAmount {

    private BigDecimal currencyIsNum, currencyNotNull, currencyAmount; // переменные валидируемых сумм

    // основной публичный метод, где собраны все приватные
    public void validateAmount() {
        System.out.println("Введите сумму:");
        validateAmountIsNum();
        validateAmountNotNull(currencyIsNum);
        validateLessDecimalValue(currencyNotNull);
    }

    // проверяем, что вводимое значение является суммой нужного формата
    private void validateAmountIsNum() {
        // вводим сумму, которую хотим обменят
        Scanner scanner = new Scanner(System.in);
        BigDecimal amountIsNum = null;
        // проверяем вводимый формат
        if (scanner.hasNextBigDecimal()) {
            amountIsNum = scanner.nextBigDecimal();
            // присваиваем провалидированное значение переменной
            this.currencyIsNum = amountIsNum;
        } else {
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        }
    }

    // проверяем, что вводимое значение не является нулевым или отрицательным
    private void validateAmountNotNull(@NotNull BigDecimal amountNotNull) {
        if (amountNotNull.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        } else {
            // присваиваем провалидированное значение переменной
            this.currencyNotNull = amountNotNull;
        }
    }

    // проверяем, что вводимое значение имеет не более двух знаков после десятичной запятой
    private void validateLessDecimalValue(@NotNull BigDecimal amountLessDecimalValue) {
        if (amountLessDecimalValue.scale() > 2) {
            System.out.println("Не верно введена сумма, пожалуйста, повторите ввод.");
            validateAmount();
        } else {
            // присваиваем провалидированное значение переменной
            this.currencyAmount = amountLessDecimalValue;
        }
    }

    // метод возврата введённой суммы
    public BigDecimal getCurrencyAmount() {
        return currencyAmount;
    }
}
