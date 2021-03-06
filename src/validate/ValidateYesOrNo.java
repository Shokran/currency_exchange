package validate;

import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 29.04.19
 */

/*
 Класс валидирующий вопросы для пользователя да/нет
 Основной метод ничего не возвращает, отвечает за ввод и валидацию
 Для возврата интересующего значения создан специальный метод-getter
 */

public class ValidateYesOrNo {

    private String confirmRepeat;

    // метод для вопроса типа ответь "y" или "n"
    public final void yesOrNO() {

        Scanner scanner = new Scanner(System.in); // создаём сканнер
        String confirm; // внутренняя переменная
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
    public String getConfirmRepeat() {
        return confirmRepeat;
    }
}
