package _6_walmart;

public class _8_MaximumHeightTree {
	
	static int height(int n){
        // code here
        int i=1;
        while((i*(i+1))/2<=n) i++;
        return i-1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(height(7));
	}

}
