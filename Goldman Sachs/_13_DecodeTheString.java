package goldman_sachs;
import java.util.*;

public class _13_DecodeTheString {
	
	static String decodedString(String s){
        // code here
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String ans = "";
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int count = 0;
                while(Character.isDigit(s.charAt(i))){
                    count = count*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                counts.push(count);
            }else if(s.charAt(i)=='['){
                result.push(ans);
                ans = "";
            }else if(s.charAt(i)==']'){
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                for(int j=0;j<count;j++) temp.append(ans);
                ans = temp.toString();
            }else{
                ans += s.charAt(i);
            }
        }
        return ans;
	}

	public static void main(String[] args) {
		String endoced = "3[b2[ca]]";
		System.out.println(decodedString(endoced));
	}

}
