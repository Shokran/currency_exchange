//package Control;
//
//import java.math.BigDecimal;
//import java.util.Scanner;
//import java.util.Optional;
//
//import Currency.Currency;
//import Currency.CurrencyFactory;
//
///**
// * @author kozlov_ya
// * @created 25.05.19
// */
//
///*
// Данный класс освобождает исполняемый от хаоса
// Здесь разбиты по методам все основные шаги
// */
//public class ControlUtils {
//
//    private Scanner scanner = new Scanner(System.in);
//
//    private Optional<Currency> getCurrencyFrom() {
//        // вводим валюту, которую хотим обменять
//        System.out.println("Введите валюту которую хотите обменять:");
//        Optional<Currency> currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
//        while (!currencyConvertFrom.isPresent()) {
//            System.out.println("Не верно введена валюта, повторите ввод");
//            currencyConvertFrom = CurrencyFactory.getCurrency(scanner.next());
//        }
//        return currencyConvertFrom;
//    }
//
//    private BigDecimal getCurrencyAmount() {
//        // вводим сумму, которую хотим обменять
//        System.out.println("Введите сумму:");
//        return scanner.nextBigDecimal(); // вводим сумму которую хотим обменять
//
////        return amountConvertFrom;
//    }
//
//    private Optional<Currency> getCurrencyTo() {
//        // вводим валюту, которую хотим купить
//        System.out.println("Введите валюту для обмена:");
//        Optional<Currency> currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
//        while (!currencyConvertTo.isPresent()) {
//            System.out.println("Не верно введена валюта, повторите ввод");
//            currencyConvertTo = CurrencyFactory.getCurrency(scanner.next());
//        }
//        return currencyConvertTo;
//    }
//
//    public final void waitingForUser() throws InterruptedException {
//        // фраза из условия задачи
//        System.out.println("Немного терпения...");
//        Thread.sleep(2000); // ожидание (для вида)
//    }
//
//    public String getApproveConvert() {
//
//        Optional<Currency> currencyFrom = getCurrencyFrom();
//        Optional<Currency> currencyTo = getCurrencyTo();
//
//        currencyFrom.ifPresent( currencyF ->
//                currencyTo.ifPresent(
//                        currencyT -> System.out.println("Вы действительно хотите купить 1.50" +
//                                currencyF.currencySign() +
//                                "за " + getCurrencyAmount()
//                                + currencyT.currencySign()
//                        )));
//        System.out.println("Введите \"y\" если согласны, \"n\" для отмены.");
//        return  scanner.next().toLowerCase(); // ввод подтверждения
//    }
//}
