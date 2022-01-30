package _5_intuit;
import java.util.*;

public class _13_MinimumSwapsToArrangeABinaryGrid {
	
	static void swap(ArrayList<Integer> list, int i, int j){
        int temp = list.get(j);
        for(int k=j;k>i;k--){
            list.set(k,list.get(k-1));
        }
        list.set(i,temp);
        
    }
    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0) count++;
                else break;
            }
            list.add(count);
        }
        int ans = 0;
        for(int i=0;i<n-1;i++){
            int temp = -1;
            for(int j=i;j<n;j++){
                if(list.get(j)>=n-i-1){
                    temp = j-i;
                    swap(list,i,j);
                    break;
                }
            }
            if(temp==-1) return -1;
            ans += temp;
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{0,0,1},
						{1,1,0},
						{1,0,0}};
		System.out.println(minSwaps(grid));
	}

}
