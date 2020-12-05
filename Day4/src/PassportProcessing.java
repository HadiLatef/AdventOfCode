import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class PassportProcessing {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(countValidPassports());
    }

    private static int countValidPassports() throws FileNotFoundException {
        int count = 0;
        ArrayList<HashMap<String, String>> passports = PassportReader.retrieveIndividualPassportsFromBatchData();
        for (HashMap<String, String> passport : passports) {
            if(/*PassportValidator.isPassportValidSimple(passport)*/
               PassportValidator.isPassportValidComplex(passport)) {
                count++;
            }
        }
        return count;
    }

}
