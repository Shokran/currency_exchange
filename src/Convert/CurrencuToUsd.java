//package Convert;
//
//import Currency.Dollars;
//import Currency.Euros;
//import Currency.Pounds;
//import Currency.Yen;
//
//import java.util.Optional;
//
//public class CurrencuToUsd {
//
//    public static double getConvert (String type) {
//
//        Double toReturn = new Double;
//        switch (type) {
//            case "RUB":
//                toReturn = 64,64;
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