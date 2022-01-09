package amazon;
import java.util.*;

public class _9_IsSudokuValid {

	public static boolean vertical(int arr[][], int i) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int j = 0; j < 9; j++) {
			if (!set.add(arr[i][j]) && arr[i][j] > 0)
				return false;
			sum += arr[i][j];
		}
		return sum <= 45;
	}

	public static boolean horizontal(int arr[][], int j) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			if (!set.add(arr[i][j]) && arr[i][j] > 0)
				return false;
			sum += arr[i][j];
		}
		return sum <= 45;
	}

	public static boolean check(int arr[][], int i, int j) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int l = i; l < i + 3; l++) {
			for (int m = j; m < j + 3; m++) {
				if (!set.add(arr[l][m]) && arr[l][m] > 0)
					return false;
				sum += arr[l][m];
			}
		}
		return sum <= 45;
	}

	static int isValid(int arr[][]) {
		// code here
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (!check(arr, i, j))
					return 0;
			}
		}
		for (int i = 0; i < 9; i++)
			if (!vertical(arr, i))
				return 0;
		for (int j = 0; j < 9; j++)
			if (!horizontal(arr, j))
				return 0;
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
						{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 8, 7, 0, 0, 0, 0, 3, 1 },
						{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
						{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
						{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
						{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
						{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		System.out.println(isValid(mat));
	}

}
