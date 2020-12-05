import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TobbogganTrajectoryComplex {

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();
        long collisionSum = 1;
        for (TrajectoryCalculator trajectory : createTrajectories()) {
            int collisions = trajectory.countTreeCollisions();
            collisionSum*=collisions;
        }
        System.out.println(collisionSum);
    }

    private static ArrayList<TrajectoryCalculator> createTrajectories() throws FileNotFoundException {
        ArrayList<TrajectoryCalculator> trajectories = new ArrayList<>();

        TrajectoryCalculator t1 = new TrajectoryCalculator(1,1);
        TrajectoryCalculator t2 = new TrajectoryCalculator(3,1);
        TrajectoryCalculator t3 = new TrajectoryCalculator(5,1);
        TrajectoryCalculator t4 = new TrajectoryCalculator(7,1);
        TrajectoryCalculator t5 = new TrajectoryCalculator(1,2);

        trajectories.add(t1);
        trajectories.add(t2);
        trajectories.add(t3);
        trajectories.add(t4);
        trajectories.add(t5);

        return trajectories;
    }

}