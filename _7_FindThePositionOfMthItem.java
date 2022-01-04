package goldman_sachs;

public class _7_FindThePositionOfMthItem {
	
	static int findPosition(int N , int M , int K) {
        // code here
        int ans = (M%N+K-1)%N;
        return ans==0?N:ans;
    }

	public static void main(String[] args) {
		System.out.println(findPosition(5,8,2));
	}

}
