import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PassportReader {

    private static ArrayList<String> readPassportBatchToArrayList() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("/git_clones/AdventOfCode/PassportInput"));
        ArrayList<String> passports = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while(scanner.hasNextLine()) {
            String current = scanner.nextLine();
            if (!current.equals("")) {
                sb.append(current + " ");
            }
            if (current.equals("")) {
                passports.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        passports.add(sb.toString());
        return passports;
    }

    private static ArrayList<HashMap<String,String>> individualisePassports(ArrayList<String> passports) {
        ArrayList<HashMap<String, String>> passportsProcessed = new ArrayList<HashMap<String, String>>();
        for (String passport : passports) {
            HashMap<String,String> entryMap = new HashMap<String, String>();
            String[] entries = passport.split(" ");
            for (String entry : entries) {
                String[] entrySplit = entry.split(":");
                entryMap.put(entrySplit[0], entrySplit[1]);
            }
            passportsProcessed.add(entryMap);
        }
        return passportsProcessed;
    }

    public static ArrayList<HashMap<String, String>> retrieveIndividualPassportsFromBatchData() throws FileNotFoundException {
        return individualisePassports(readPassportBatchToArrayList());
    }
}
