import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arabi = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rom = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        System.out.println("Введите выражение");
        String meow = sc.nextLine();
        meow = meow.replaceAll(" ", "");
        if (!meow.contains("-") && !meow.contains("+") && !meow.contains("*") && !meow.contains("/")) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
        } else {
            String[] gaf = meow.split("[+-/*]");
            if (gaf.length == 2) {
                String a = gaf[0];
                String s = gaf[1];
                boolean found1 = Arrays.asList(arabi).contains(a);
                boolean found2 = Arrays.asList(arabi).contains(s);
                boolean found3 = Arrays.asList(rom).contains(a);
                boolean found4 = Arrays.asList(rom).contains(s);
                if ((!found1 || !found2) && (!found3 || !found4)) {
                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления или числа больше 10");
                }

                int x;
                int y;
                String rez;
                if (found1 && found2) {
                    x = Integer.parseInt(a);
                    y = Integer.parseInt(s);
                    rez = calc(meow, x, y);
                    System.out.println(rez);
                }

                if (found3 && found4) {
                    x = romarab(rom, a);
                    y = romarab(rom, s);
                    rez = calc(meow, x, y);
                    if (Integer.parseInt(rez) < 1) {
                        System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    } else {
                        arabrom(rez);
                    }
                }
            } else {
                System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }

    }

    static String calc(String meow, int x, int y) {
        boolean value1 = meow.contains("+");
        boolean value2 = meow.contains("-");
        boolean value3 = meow.contains("/");
        boolean value4 = meow.contains("*");
        int rez = 0;
        if (value1) {
            rez = x + y;
        }

        if (value2) {
            rez = x - y;
        }

        if (value3) {
            rez = x / y;
        }

        if (value4) {
            rez = x * y;
        }

        return Integer.toString(rez);
    }

    static int romarab(String[] rom, String a) {
        int x = 0;

        for(int i = 0; i < rom.length; ++i) {
            if (rom[i].equals(a)) {
                ++i;
                x = i;
            }
        }

        return x;
    }

    static void arabrom(String rez) {
        String[] arab = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        System.out.println(arab[Integer.parseInt(rez) - 1]);
    }
}
