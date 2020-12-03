import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReportRepair {
    public static void main(String[] args) throws FileNotFoundException {
        //findResultSimple();
        findResultComplex();
    }

    private static void findResultSimple() throws FileNotFoundException {
        ArrayList<Integer> reportList = readFile();
        for (int i = 0; i < reportList.size()-1; i++) {
            for (int j = i + 1; j < reportList.size(); j++ ) {
                if (reportList.get(i) + reportList.get(j) == 2020) {
                    System.out.println(reportList.get(i) * reportList.get(j));
                }
            }
        }
    }
    //TODO: There has to be a better way to do this than brute force, work it out?
    private static void findResultComplex() throws FileNotFoundException {
        ArrayList<Integer> reportList = readFile();
        for (int i = 0; i < reportList.size()-2; i++) {
            for (int j = i + 1; j < reportList.size() - 1; j++) {
                for (int k = j + 1; k < reportList.size(); k++) {
                    if(reportList.get(i) + reportList.get(j) + reportList.get(k) == 2020) {
                        System.out.println(reportList.get(i) * reportList.get(j) * reportList.get(k));
                    }
                }
            }
        }
    }

    private static ArrayList<Integer> readFile() throws FileNotFoundException {
        ArrayList<Integer> reportList = new ArrayList<Integer>();
        try (Scanner scanner = new Scanner(new FileReader("/git_clones/AdventOfCode/ReportRepairInput"))) {
            while(scanner.hasNext()) {
                reportList.add(Integer.parseInt(scanner.next()));
            }
        }
        return reportList;
    }
}
