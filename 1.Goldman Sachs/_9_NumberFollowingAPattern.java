package goldman_sachs;
import java.util.*;

public class _9_NumberFollowingAPattern {
	
	public static String printMinNumberForPattern(String s){
        // code here
        s+='I';
        Stack<Integer> st = new Stack<>();
        String ans = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='D') st.push(i+1);
            else{
                ans += ""+(i+1);
                while(!st.isEmpty()){
                    ans += ""+st.pop();
                }
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		System.out.println(printMinNumberForPattern("DDIIIDID"));
	}

}
