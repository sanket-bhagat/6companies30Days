package _3_microsoft;
import java.util.*;

public class _4_SpirallyTraversingAMatrix {
	
	static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c){
        // code here 
        int top=0,bottom=r-1,left=0,right=c-1;
        ArrayList<Integer> list = new ArrayList<>();
        while(top<=bottom && left<=right){
            for(int j=left;j<=right;j++) list.add(matrix[top][j]);
            top++;
            for(int i=top;i<=bottom;i++) list.add(matrix[i][right]);
            right--;
            if(top<=bottom){
                for(int j=right;j>=left;j--) list.add(matrix[bottom][j]);
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--) list.add(matrix[i][left]);
                left++;
            }
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r=4,c=4;
		int arr[][] = {{1, 2, 3, 4},
		           	  {5, 6, 7, 8},
		           	  {9, 10, 11, 12},
		           	  {13, 14, 15,16}};
		System.out.println(spirallyTraverse(arr, r, c));
	}

}
