import exchange.Exchange;

import java.util.Scanner;

/**
 * @author kozlov_ya
 * @created 16.05.19
 */

public class Main {

    private static Scanner scanner = new Scanner(System.in); // создаём сканнер

    public static void main(String[] args) throws InterruptedException {

        new Exchange().process();

    }

}