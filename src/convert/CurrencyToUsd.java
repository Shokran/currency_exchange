//package convert;
//
//import currency.Dollars;
//import currency.Euros;
//import currency.Pounds;
//import currency.Yen;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//
//public class CurrencyToUsd {
//
//    public static double getConvert (String type) {
//
//        Double toReturn = new BigDecimal();
//        switch (type) {
//            case "RUB":
//                toReturn = 64.64;
//                break;
//            case "USD":
//                toReturn = new Dollars();
//                break;
//            case "EUR":
//                toReturn = new Euros();
//                break;
//            case "GBP":
//                toReturn = new Pounds();
//                break;
//            case "YEN":
//                toReturn = new Yen();
//                break;
//        }
//        return Optional.ofNullable(toReturn);
//    }
//}