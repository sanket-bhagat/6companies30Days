package _6_walmart;
import java.util.*;

public class _11_MaximumPerformanceOfATeam {
	
	static class Engineer {
	    int speed;
	    int efficiency;

	    Engineer(int speed, int efficiency) {
	        this.speed = speed;
	        this.efficiency = efficiency;
	    }
	}

	static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

        List<Engineer> engineers = new ArrayList<Engineer>();

        for (int i = 0; i < n; i++) {
            engineers.add(new Engineer(speed[i], efficiency[i]));
        }
        // decreasing order
        engineers.sort((a, b) -> b.efficiency - a.efficiency);

        // minHeap
        PriorityQueue<Engineer> currentTeam = new PriorityQueue<>(Comparator.comparingInt(a -> a.speed));

        long teamSpeed = 0; // careful with the data types
        long maxPerformance = 0;

        for (Engineer newHire : engineers) {

            if (currentTeam.size() == k) {
                Engineer slowGuy = currentTeam.poll();

                teamSpeed = teamSpeed - slowGuy.speed;
            }
            currentTeam.add(newHire);
            teamSpeed += newHire.speed;

            long performanceWithNewGuy = teamSpeed * (long) newHire.efficiency;
            maxPerformance = Math.max(maxPerformance, performanceWithNewGuy);
        }
        return (int) (maxPerformance % 1000000007);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        System.out.println(maxPerformance(n, speed, efficiency, k));
    }

}
