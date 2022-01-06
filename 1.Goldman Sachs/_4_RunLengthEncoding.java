package goldman_sachs;

public class _4_RunLengthEncoding {
	
	public static String encode(String str){
	      //Your code here
	      int n = str.length();
	      int i=0,j=0;
	      String ans = "";
	      while(j<n){
	          while(j<n && str.charAt(i)==str.charAt(j)) j++;
	          ans += str.charAt(i);
	          ans += j-i;
	          i=j;
	      }
	      return ans;
		}

	public static void main(String[] args) {
		String s = "abbbcdddd";
		System.out.println(encode(s));
	}

}
