import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReportRepair {
    public static void main(String[] args) throws FileNotFoundException {
        findResult();
    }

    private static void findResult() throws FileNotFoundException {
        ArrayList<Integer> reportList = new ArrayList<Integer>();
        try (Scanner scanner = new Scanner(new FileReader("/git_clones/AdventOfCode/ReportRepairInput"))) {
            while(scanner.hasNext()) {
                reportList.add(Integer.parseInt(scanner.next()));
            }
        }
        for (int i = 0; i < reportList.size()-1; i++) {
            for (int j = i + 1; j < reportList.size(); j++ ) {
                if (reportList.get(i) + reportList.get(j) == 2020) {
                    System.out.println(reportList.get(i) * reportList.get(j));
                }
            }
        }
    }
}
