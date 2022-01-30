package _5_intuit;

public class _15_KokoEatingBananas {

	static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canEatInTime(piles, mid, h)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    static boolean canEatInTime(int piles[], int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            int div = pile / k;
            hours += div;
            if (pile % k != 0) hours++;
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }

}
