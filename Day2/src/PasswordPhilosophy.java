import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordPhilosophy {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(countSuccesses());
    }

    private static long countSuccesses() throws FileNotFoundException {
        long successCount = 0;
        try (Scanner scanner = new Scanner(new FileReader("/git_clones/AdventOfCode/PasswordPhilosophyInput"))) {
            while(scanner.hasNextLine()) {
                String[] input = scanner.nextLine().split(" ");
                if (compliesWithRuleComplex(input)/*compliesWithRuleSimple(input)*/) {
                    successCount++;
                }
            }
        }
        return successCount;
    }

    private static boolean compliesWithRuleSimple(String[] input) {
        int maxOccurences = Integer.parseInt(input[0].split("-")[1]);
        int minOccurences = Integer.parseInt(input[0].split("-")[0]);
        char targetLetter = input[1].substring(0,1).charAt(0);
        char[] password = input[2].toCharArray();
        long letterCount = 0;

        for(int i = 0; i < password.length; i++) {
            if(password[i] == targetLetter) {
                letterCount++;
            }
        }

        if (letterCount <= maxOccurences && letterCount >= minOccurences) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean compliesWithRuleComplex(String[] input) {
        int firstTargetSpot = Integer.parseInt(input[0].split("-")[0]) -1;
        int secondTargetSpot = Integer.parseInt(input[0].split("-")[1]) -1;
        char targetLetter = input[1].substring(0,1).charAt(0);
        char[] password = input[2].toCharArray();

        boolean foundInFirstSpot = password[firstTargetSpot] == targetLetter;
        boolean foundInSecondSpot = password[secondTargetSpot] == targetLetter;

        return foundInFirstSpot ^ foundInSecondSpot;

    }
}
