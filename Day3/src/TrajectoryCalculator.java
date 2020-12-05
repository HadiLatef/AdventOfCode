import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TrajectoryCalculator {
    int xCoordinate;
    int rightBy;
    int downBy;
    ArrayList<String> map;

    public TrajectoryCalculator(int rightBy, int downBy) throws FileNotFoundException {
        this.rightBy = rightBy;
        this.downBy = downBy;
        int xCoordinate = 0;
        map = createMapForObject();
    }
    public int countTreeCollisions() throws FileNotFoundException {
        int collisionCounter = 0;

        for (int i = 0; i < map.size(); i+=downBy) {
            if(detectCollision(map.get(i), xCoordinate)) {
                collisionCounter++;
            }
            xCoordinate += rightBy;
            if(xCoordinate >= 31) {
                xCoordinate -= 31;
            }

        }

        return collisionCounter;
    }

    private boolean detectCollision(String currentLevel, int xCoordinate) {
        if(currentLevel.charAt(xCoordinate) == '#' ) {
            return true;
        }
        return false;
    }

    private static ArrayList<String> createMapForObject() throws FileNotFoundException {
        ArrayList<String> map = new ArrayList<String>();
        Scanner scanner = new Scanner(new FileReader("/git_clones/AdventOfCode/TobboganMap"));
        while (scanner.hasNextLine()) {
            map.add(scanner.nextLine());
        }
        return map;
    }
}
