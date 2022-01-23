package _5_intuit;
import java.util.*;

public class _8_NumberOfBoomerangs {
	
	static int dist(int p1[], int p2[]){
        int dx = p1[0]-p2[0];
        int dy = p1[1]-p2[1];
        return dx*dx + dy*dy;
    }
    
    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int n = points.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                int d = dist(points[i],points[j]);
                map.put(d,map.getOrDefault(d,0)+1);
            }
            for(int count: map.values()){
                if(count>1) sum += count*(count-1);
            }
            map.clear();
        }
        return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int points[][] = {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(points));
	}

}
