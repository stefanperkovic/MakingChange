import java.util.ArrayList;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Stefan Perkovic
 */

public class MakingChange {
    public static long countWays(int target, int[] coins) {
        long[][] arr = new long[target + 1][coins.length];

        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < coins.length; j++) {
                arr[i][j] = -1;
            }
        }

        return recursiveCall(target, coins, 0, arr);
    }


    private static long recursiveCall(int target, int[] coins, int index, long[][] arr) {

        if (target == 0){
            return 1;
        }
        if(index >= coins.length || target < 0){
            return 0;
        }

        if (arr[target][index] != -1) {
            return arr[target][index];
        }
        long count  = 0;
        // Includes coin
        count += recursiveCall(target - coins[index], coins, index, arr);
        // Excludes coin
        count += recursiveCall(target, coins, index + 1, arr);

        arr[target][index] = count;
        return count;

    }


}