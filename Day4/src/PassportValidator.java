import java.util.HashMap;
import java.util.regex.Pattern;

public class PassportValidator {


    public static boolean isPassportValidSimple(HashMap<String, String> passport) {
        if (passport.containsKey("byr") && passport.containsKey("iyr")
                && passport.containsKey("eyr") && passport.containsKey("hgt")
                && passport.containsKey("hcl") && passport.containsKey("ecl")
                && passport.containsKey("pid")) {
            return true;
        }
        return false;
    }

    public static boolean isPassportValidComplex(HashMap<String, String> passport) {
        if(validateByr(passport) && validateEyr(passport) && validateHgt(passport) && validateIyr(passport)
        && validateEcl(passport) && validateHcl(passport) && validatePid(passport)) {
            return true;
        }
        return false;
    }

    private static boolean validateByr(HashMap<String, String> passport) {
        if(!passport.containsKey("byr")) {
            return false;
        }
        if(Integer.parseInt(passport.get("byr")) >= 1920 && Integer.parseInt(passport.get("byr")) <= 2002 ) {
            return true;
        }
        return false;
    }

    private static boolean validateIyr(HashMap<String, String> passport) {
        if(!passport.containsKey("iyr")) {
            return false;
        }
        if(Integer.parseInt(passport.get("iyr")) >= 2010 && Integer.parseInt(passport.get("iyr")) <= 2020 ) {
            return true;
        }
        return false;
    }

    private static boolean validateEyr(HashMap<String, String> passport) {
        if(!passport.containsKey("eyr")) {
            return false;
        }
        if(Integer.parseInt(passport.get("eyr")) >= 2020 && Integer.parseInt(passport.get("eyr")) <= 2030 ) {
            return true;
        }
        return false;
    }

    private static boolean validateHgt(HashMap<String, String> passport) {
        final Pattern cmPattern = Pattern.compile("[0-9][0-9][0-9]cm");
        final Pattern inPattern = Pattern.compile("[0-9][0-9]in");

        if(!passport.containsKey("hgt")) {
            return false;
        }

        if(cmPattern.matcher(passport.get("hgt")).find()) {
            int heightNumber = Integer.parseInt(passport.get("hgt").substring(0,3));
            if(heightNumber >= 150 && heightNumber <= 193) {
                return true;
            }
        }

        if(inPattern.matcher(passport.get("hgt")).find()) {
            int heightNumber = Integer.parseInt(passport.get("hgt").substring(0,2));
            if(heightNumber >= 59 && heightNumber <= 76) {
                return true;
            }
        }

        return false;
    }

    private static boolean validateHcl(HashMap<String, String> passport) {
        final Pattern hclPattern = Pattern.compile("#[0-9abcdef]{6}");
        if(!passport.containsKey("hcl")) {
            return false;
        }
        if(hclPattern.matcher(passport.get("hcl")).find()) {
            return true;
        }
        return false;
    }

    private static boolean validateEcl(HashMap<String, String> passport) {
        if(!passport.containsKey("ecl")) {
            return false;
        }
        if(passport.get("ecl").equals("amb") || passport.get("ecl").equals("blu") || passport.get("ecl").equals("brn")
        || passport.get("ecl").equals("gry") || passport.get("ecl").equals("grn") || passport.get("ecl").equals("hzl")
        || passport.get("ecl").equals("oth")) {
            return true;
        }

        return false;
    }

    private static boolean validatePid(HashMap<String, String> passport) {
        final Pattern pidPattern = Pattern.compile("[0-9]{9}");
        if(!passport.containsKey("pid")) {
            return false;
        }

        if(pidPattern.matcher(passport.get("pid")).find()) {
            return true;
        }
        return false;
    }
}
