package _4_adobe;

public class _8_ImplementAtoi {
	
	public static int atoi(String str) {
	    // Your code here
	    int i=0;
	    int ans = 0;
	    boolean check = false;
	    if(str.charAt(i)=='-'){
	        check = true;
	        i++;
	    }
	    while(i<str.length() && Character.isDigit(str.charAt(i))){
	        ans = ans*10 + (str.charAt(i)-'0');
	        i++;
	    }
	    if(check) ans*=-1;
	    return i==str.length()?ans:-1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12345";
		System.out.println(atoi(s));
	}
}
