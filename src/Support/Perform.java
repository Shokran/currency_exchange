package Support;

/**
 * Методы этого класса исправляют ошибки ввода
 * связанные с различием регистра букв
 * в ожидаемом результате и том, что ввёл пользователь
 *
 * зы. решил реализовать разные варианты для разных случаев
 */

public class Perform {

    public String performInputConfirm(String inputConfirm){
        if (inputConfirm.equals(inputConfirm.toUpperCase())) {
            inputConfirm = inputConfirm.toLowerCase();
        } else if (inputConfirm.equals(inputConfirm.toLowerCase())) {
            return inputConfirm;
        } else {
            throw new RuntimeException("По-другому ввести невозможно");
        }
        return inputConfirm;
    }

    public String performInputCurrency(String inputCurrency) {
        StringBuilder titleCase = new StringBuilder();

        for (char c : inputCurrency.toCharArray()) {
            c = Character.toUpperCase(c);
            titleCase.append(c);
        }
        return titleCase.toString();
    }
}
