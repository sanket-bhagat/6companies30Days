package _5_intuit;

public class _6_FindInMountainArray {
	
	interface MountainArray {
	    int get(int index);
	    int length();
	}

	static int mountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        int peak = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                start = mid + 1;
            else
                end = mid - 1;
        }

        peak = start;
        start = 0;
        end = peak;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (mountainArr.get(mid) > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        start = peak + 1;
        end = mountainArr.length() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) == target)
                return mid;
            else if (mountainArr.get(mid) > target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int target = 3;
        int[] nums = {1,2,3,4,5,3,1};
    }

}
