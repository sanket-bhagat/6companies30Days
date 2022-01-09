package amazon;
import java.util.*;

public class _7_FirstNonRepeatingCharacterInAStream {
	
	public static String firstNonRepeating(String s){
        // code here
        Map<Character,Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))) q.offer(s.charAt(i));
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            while(!q.isEmpty() && map.getOrDefault(q.peek(),0)>1) q.poll();
            if(q.isEmpty()) sb.append('#');
            else sb.append(q.peek());
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabc";
		System.out.println(firstNonRepeating(s));
	}
}
