package _3_microsoft;
import java.util.*;

public class _11_GenerateBinaryNumbers {
	
	public static String getBinary(int n){
        String ans = "";
        while(n>0){
            if(n%2==0) ans = '0'+ans;
            else ans = '1'+ans;
            n/=2;
        }
        return ans;
    }
    
    //Function to generate binary numbers from 1 to N using a queue.
    public static ArrayList<String> generate(int n){
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(getBinary(i));
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(5));
	}

}
