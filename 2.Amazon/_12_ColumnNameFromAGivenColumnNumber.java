package amazon;

public class _12_ColumnNameFromAGivenColumnNumber {
	
	public static String colName (long n){
        // your code here
        String ans = "";
        boolean check = false;
        while(n>0){
            long d=n%26;
            if(d==0){
                d = 26;
                check = true;
            }else if(check){
                d--;
                check = false;
                if(d==0){
                    d = 26;
                    check = true;
                }
            }
            ans = (char)(d+'A'-1) + ans;
            n/=26;
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 28;
		System.out.println(colName(n));
	}

}
