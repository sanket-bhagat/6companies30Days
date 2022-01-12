package _3_microsoft;
import java.util.*;

public class _6_PossibleWordsFromPhoneDigits {
	
	public static String getKeys(int n){
        if(n==2){
            return "abc";
        }else if(n==3){
            return "def";
        }else if(n==4){
            return "ghi";
        }else if(n==5){
            return "jkl";
        }else if(n==6){
            return "mno";
        }else if(n==7){
            return "pqrs";
        }else if(n==8){
            return "tuv";
        }else if(n==9){
            return "wxyz";
        }
        return "";
    }
    
    public static void solve(int arr[], int s, String ans, ArrayList<String> list){
        if(s==arr.length){
            list.add(ans);
            return;
        }
        String key = getKeys(arr[s]);
        for(int i=0;i<key.length();i++){
            solve(arr,s+1,ans+key.charAt(i),list);
        }
    }
    
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N){
        // your code here
        ArrayList<String> list = new ArrayList<>();
        solve(a,0,"",list);
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,4};
		System.out.println(possibleWords(arr, arr.length));
		
	}

}
