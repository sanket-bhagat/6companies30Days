package _4_adobe;
import java.util.*;

public class _6_GenerateParentheses {
	
	public static void solve(int open, int close, String ans, List<String> list){
        if(open+close==0){
            list.add(ans);
            return;
        }
        if(open==close) solve(open-1,close,ans+"(",list);
        else if(close>open){
            if(open>0) solve(open-1,close,ans+"(",list);
            solve(open,close-1,ans+")",list);
        }
    }
    
    public static List<String> AllParenthesis(int n){
        // Write your code here
        List<String> list = new ArrayList<>();
        solve(n,n,"",list);
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(String s: AllParenthesis(3)) System.out.println(s);
	}

}
