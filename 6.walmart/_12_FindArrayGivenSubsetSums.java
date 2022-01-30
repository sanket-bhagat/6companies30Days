package _6_walmart;
import java.util.*;

public class _12_FindArrayGivenSubsetSums {

	static int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int m = sums.length, zeroShift = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            int diff = sums[1] - sums[0], p = 0, k = 0, zpos = m;
            for (int j = 0; j < m; ++j) {
                if (k < p && sums[k] == sums[j])
                    k++;
                else {
                    if (zeroShift == sums[j]) zpos = p;
                    sums[p++] = sums[j] + diff;
                }
            }
            if (zpos >= m / 2) {
                res[i] = -diff;
            }
            else {
                res[i] = diff;
                zeroShift += diff;
            }
            m /= 2;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] sums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int[] ans = recoverArray(n, sums);
        System.out.println(Arrays.toString(ans));
    }

}
