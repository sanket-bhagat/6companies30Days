package _6_walmart;

public class _14_LargestNumberInKSwaps {
	
	static String max;
    
    public static String swap(String s, int i, int j){
        char arr[] = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
    
    public static void solve(String s, int k){
        
        if(s.compareTo(max)>0) max = s;
        if(k==0) return;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(j)>s.charAt(i)){
                    String swapped = swap(s,i,j);
                    solve(swapped,k-1);
                }
            }
        }
    }
    
    public static String findMaximumNum(String str, int k){
        //code here.
        max = str;
        solve(str,k);
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 4;
		String str = "1234567";
		System.out.println(findMaximumNum(str, k));
	}

}
