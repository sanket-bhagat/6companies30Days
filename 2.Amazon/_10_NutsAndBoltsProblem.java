package amazon;

public class _10_NutsAndBoltsProblem {
	
	public static void swap(char arr[], int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
    
    public static int partition(char arr[], int l, int r, char pivot){
        int i=l-1,j=r+1;
		while(true) {
			do i++;
			while(arr[i]<pivot);
			do j--;
			while(arr[j]>pivot);
			if(i>=j) return j;
			swap(arr,i,j);
			i--;
			j++;
		}
    }
    
    public static void matchPairs(char nuts[], char bolts[], int l, int r){
        if(l<r){
            int pivot = partition(nuts, l, r, bolts[r]);
            partition(bolts,l,r,nuts[pivot]);
            matchPairs(nuts,bolts,l,pivot-1);
            matchPairs(nuts,bolts,pivot+1,r);
        }
    }
    
    public static void matchPairs(char nuts[], char bolts[], int n) {
        // code here
        matchPairs(nuts,bolts,0,n-1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		char nuts[] = {'^', '&', '%', '@', '#', '*', '$', '~', '!'};
		char bolts[] = {'~', '#', '@', '%', '&', '*', '$' ,'^', '!'};
		matchPairs(nuts,bolts,n);
		for(char c: nuts) System.out.print(c+" ");
		System.out.println();
		for(char c: bolts) System.out.print(c+" ");
		System.out.println();
	}

}
