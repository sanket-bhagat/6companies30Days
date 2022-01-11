package _3_microsoft;

public class _3_RotateBy90Degree {
	
	public static void transpose(int arr[][]){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    
    public static void flip(int arr[][]){
        int n = arr.length;
        for(int i=0;i<n/2;i++){
            int temp[] = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
    }
    
    public static void rotate(int matrix[][]) 
    {
        // Code Here
        transpose(matrix);
        flip(matrix);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1, 2, 3},
		               {4, 5, 6},
		               {7, 8, 9}};
		rotate(arr);
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
