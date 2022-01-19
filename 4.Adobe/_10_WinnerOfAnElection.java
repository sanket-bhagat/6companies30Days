package _4_adobe;
import java.util.*;

public class _10_WinnerOfAnElection {
	
	public static String[] winner(String arr[], int n){
        // add your code
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        for(String s: arr){
            map.put(s,map.getOrDefault(s,0)+1);
            if(map.get(s)>max){
                max = map.get(s);
                ans = s;
            }
        }
        for(Map.Entry<String,Integer> e: map.entrySet()){
            if(e.getValue()==max && ans.compareTo(e.getKey())>0) ans = e.getKey();
        }
        String ar[] = new String[2];
        ar[0] = ans;
        ar[1] = Integer.toString(max);
        return ar;
    }

	public static void main(String[] args) {
		int n = 13;
		String Votes[] = {"john","johnny","jackie","johnny","john","jackie","jamie","jamie","john","johnny","jamie","johnny","john"};
		String ans[] = winner(Votes, n);
		System.out.println(ans[0]+" "+ans[1]);
	}

}
