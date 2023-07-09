import java.util.*;

public class Main {
    public static void main(String[] args) {
        showIntro();

        String[] exitArray = new String[] {"1"};
        
        while ("1".equals(exitArray[0])) {
            
            System.out.println("Enter a request:");
            System.out.println("");
            
            String[] input = enterAnInput();

            int inputArrayLength = outputArrayLength(input);

            if (inputArrayLength == 1) {
                showOutput1(input, exitArray);
            }

            if (inputArrayLength == 2) {
                showOutput2(input, exitArray);
            }
        } 
        
    }

    /* METHODS */

    public static void showIntro() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
    }

    /* ========== */
    
    public static int outputArrayLength(String[] input) {
        return input.length;
    }

    /* ========== */
    
    public static String[] enterAnInput() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        return input;
    }

    /* ========== */

    public static long convertStringToLong(String str) {
        long number = Long.parseLong(str);
        return number;
    }

    /* ========== */
    
    public static String convertLongToString(long number) {
        String str = Long.toString(number);
        return str;
    }

    /* ========== */
    
    public static boolean checkIfNumberIsNatural(long number) {
        boolean isNatural = true;
        isNatural = number > 0 ? true : false;
        return isNatural;
    }

    /* ========== */
    
    public static String checkNumberisEven(long number) {
        if (number % 2 == 0) {
            return "true";
        } else {
            return "false";
        }
    }

    /* ========== */
    
    public static String checkNumberisOdd(long number) {
        if (number % 2 != 0) {
            return "true";
        } else {
            return "false";
        }
    }

    /* ========== */
    
    public static String checkIfNumberIsBuzz(long number) {
        if (number % 7 == 0) {
            return "true";
        }

        if (number % 10 == 7) {
            return "true";
        }

        return "false";
    }

    /* ========== */
    
    public static String checkIfNumberIsDuck(long number) {
        boolean isDuck = false;

        while (number > 0) {
            if (number % 10 == 0) {
                isDuck = true;
                break;
            }
            number = number / 10;
        }

        if (isDuck) {
            return "true";
        } else {
            return "false";
        }
    }

    /* ========== */
    
    public static String checkIfNumberIsPalindrom(long number) {
        String numberStr = convertLongToString(number);
        String numberStrReverse = "";

        for (int i = 0; i < numberStr.length(); i++) {
            numberStrReverse = numberStr.charAt(i) + numberStrReverse;
        }

        if (numberStr.equals(numberStrReverse)) {
            return "true";
        } else {
            return "false";
        }
    }

    /* ========== */

    public static String checkIfNumberIsGapful(long number) {
        String numberStr = convertLongToString(number);

        if (numberStr.length() < 3) {
            return "false";
        }

        int lastDigitIndex = numberStr.length() - 1;
        String subStr = Character.toString(numberStr.charAt(0)) + 
            Character.toString(numberStr.charAt(lastDigitIndex));

        long num2 = Long.parseLong(subStr);

        if (number % num2 == 0) {
            return "true";
        } else {
            return "false";
        }
    }

    /* ========== */
    
    public static void showOutput1(String[] input, String[] exitArray) {
        if (input[0].isEmpty()) {
            showIntro();
            return;
        }

        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (letters.contains(input[0])) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;
        }

        long number = Long.parseLong(input[0]);
        
        boolean isNatural = checkIfNumberIsNatural(number);
        
        if (number == 0) {
            exitArray[0] = "0";
            System.out.println();
            System.out.println("Goodbye!");
            System.out.println();
            System.out.println("Process finished with exit code 0");
            return;
        }
        
        if (!isNatural) {
            System.out.println("");
            System.out.println("The first parameter should be a natural number or zero.");
            System.out.println("");
            return;
        }

        String even = checkNumberisEven(number);
        String odd = checkNumberisOdd(number);
        String buzz = checkIfNumberIsBuzz(number);
        String duck = checkIfNumberIsDuck(number);
        String palindromic = checkIfNumberIsPalindrom(number);
        String gapful = checkIfNumberIsGapful(number);
        
        String properties = String.format("Properties of %d\n", number);
        String evenString = String.format("        even: %s\n", even);
        String oddString = String.format("        odd: %s\n", odd);
        String buzzString = String.format("        buzz: %s\n", buzz);
        String duckString = String.format("        duck: %s\n", duck);
        String palindromicString = String.format(" palindromic: %s\n", palindromic);
        String gapfulString = String.format("      gapful: %s\n", gapful);

        String result = properties + buzzString + duckString +
            palindromicString + gapfulString + evenString + oddString;

        System.out.println(result);
    }

    /* ========== */

    public static void showOutput2(String[] input, String[] exitArray) {
        if (input[0].isEmpty()) {
            showIntro();
            return;
        }

        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (letters.contains(input[0])) {
            System.out.println("The first parameter should be a natural number or zero.");
            return;
        }

        long number1 = Long.parseLong(input[0]);
        boolean isNatural1 = checkIfNumberIsNatural(number1);
        
        if (number1 == 0) {
            exitArray[0] = "0";
            System.out.println();
            System.out.println("Goodbye!");
            System.out.println();
            System.out.println("Process finished with exit code 0");
            return;
        }
        
        if (!isNatural1) {
            System.out.println("");
            System.out.println("The first parameter should be a natural number or zero.");
            System.out.println("");
            return;
        }

        if (letters.contains(input[1])) {
            System.out.println("The second parameter should be a natural number.");
            return;
        }

        long number2 = Long.parseLong(input[1]);
        boolean isNatural2 = checkIfNumberIsNatural(number2);

        if (input[1].isEmpty()) {
            System.out.println();
            System.out.println("The second parameter should be a natural number.");
            System.out.println();
            return;
        }
        
        if (number2 == 0) {
            exitArray[0] = "0";
            System.out.println();
            System.out.println("The second parameter should be a natural number.");
            System.out.println();
            return;
        }
        
        if (!isNatural2) {
            System.out.println("");
            System.out.println("The second parameter should be a natural number.");
            System.out.println("");
            return;
        }

        for (int i = 0; i < number2; i++) {
            String result = formForOutput2(number1);
            System.out.println(result);
            number1++;
        }
    }

    /* ========== */

    public static String formForOutput2(long number) {
        
        String even = checkNumberisEven(number);
        String odd = checkNumberisOdd(number);
        String buzz = checkIfNumberIsBuzz(number);
        String duck = checkIfNumberIsDuck(number);
        String palindromic = checkIfNumberIsPalindrom(number);
        String gapful = checkIfNumberIsGapful(number);

        String result = "";

        if ("true".equals(even)) {result = result + "even" + ",";}
        if ("true".equals(odd)) {result = result + "odd" + ",";}
        if ("true".equals(buzz)) {result = result + "buzz" + ",";}
        if ("true".equals(duck)) {result = result + "duck" + ",";}
        if ("true".equals(palindromic)) {result = result + "palindromic" + ",";}
        if ("true".equals(gapful)) {result = result + "gapful" + ",";}

        return number + " is " + result;
    }

    /* ========== */
}
