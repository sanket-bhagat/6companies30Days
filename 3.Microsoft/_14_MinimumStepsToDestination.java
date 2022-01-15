package _3_microsoft;

public class _14_MinimumStepsToDestination {
	
	public static int minSteps(int D){
        // code here
        int steps=0,sum=0;
        boolean check = true;
        while(check){
            sum += steps++;
            if(sum==D){
                check = false;
            }
            else if(sum>D && (sum-D)%2==0){
                check = false;
            }
        }
        return steps-1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d = 2;
		System.out.println(minSteps(d));
	}

}
