import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TobbogganTrajectory {


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(countTreeCollisions());
    }

    private static int countTreeCollisions() throws FileNotFoundException {
        int collisionCounter = 0;
        int xCoordinate = 0;

        Scanner scanner = new Scanner(new FileReader("/git_clones/AdventOfCode/TobboganMap"));
        while(scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            if(detectCollision(currentLine, xCoordinate)) {
                collisionCounter++;
            }
            xCoordinate += 3;
            if(xCoordinate >= 31) {
                xCoordinate -= 31;
            }
        }

        return collisionCounter;
    }

    private static boolean detectCollision(String currentLevel, int xCoordinate) {
        if(currentLevel.charAt(xCoordinate) == '#' ) {
            return true;
        }
        return false;
    }
}
