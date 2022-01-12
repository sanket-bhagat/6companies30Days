package _3_microsoft;
import java.util.*;

public class _5_StockSpanProblem {
	
	public static class Pair{
        int val,span;
        Pair(int val, int span){
            this.val = val;
            this.span = span;
        }
    }
    
    //Function to calculate the span of stock’s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Pair> st = new Stack<>();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            int span = 0;
            while(!st.isEmpty() && st.peek().val<=price[i]){
                span += st.pop().span;
            }
            st.push(new Pair(price[i],span+1));
            ans[i] = span+1;
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7; 
		int price[] = {100, 80, 60, 70, 60, 75, 85};
		int span[] = calculateSpan(price, n);
		for(int i: span) System.out.print(i+" ");
	}

}
