package _4_adobe;

public class _9_NextHigherPalindromicNumberUsingTheSameSetOfDigits {
	
	public static void swap(char arr[], int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void reverse(char arr[], int i, int j){
        while(i<j) swap(arr,i++,j--);
    }
    
    public static String nextPalin(String s){ 
        //complete the function here
        char arr[] = s.substring(0,s.length()/2).toCharArray();
        int i=arr.length-1;
        while(i>0){
            if(arr[i-1]<arr[i]){
                for(int j=arr.length-1;j>=i;j--){
                    if(arr[j]>arr[i-1]){
                        swap(arr,i-1,j);
                        reverse(arr,i,arr.length-1);
                        StringBuilder sb = new StringBuilder("");
                        for(int k=0;k<arr.length;k++) sb.append(arr[k]);
                        if(s.length()%2!=0) sb.append(s.charAt(s.length()/2));
                        for(int k=arr.length-1;k>=0;k--) sb.append(arr[k]);
                        return sb.toString();
                    }
                }
            }
            i--;
        }
        return "-1";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "35435";
		System.out.println(nextPalin(s));
	}

}
