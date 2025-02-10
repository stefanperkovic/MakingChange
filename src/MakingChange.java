import java.util.ArrayList;

/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Stefan Perkovic
 */

public class MakingChange {
//    // Memoization solution to the problem set
//    public static long countWays(int target, int[] coins) {
//        long[][] arr = new long[target + 1][coins.length];
//        for (int i = 0; i <= target; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                arr[i][j] = -1;
//            }
//        }
//        return recursiveCall(target, coins, 0, arr);
//    }
//    private static long recursiveCall(int target, int[] coins, int index, long[][] arr) {
//        if (target == 0){
//            return 1;
//        }
//        if(index >= coins.length || target < 0){
//            return 0;
//        }
//        if (arr[target][index] != -1) {
//            return arr[target][index];
//        }
//        long count  = 0;
//        // Includes coin
//        count += recursiveCall(target - coins[index], coins, index, arr);
//        // Excludes coin
//        count += recursiveCall(target, coins, index + 1, arr);
//        arr[target][index] = count;
//        return count;
//    }
//
//    // Tabulation Solution
//    public static long countWays(int target, int[] coins) {
//        long[][] dynamic = new long[target + 1][coins.length + 1];
//        // Base case as there is one way to make 0 amount with any number of coins
//        for (int j = 0; j <= coins.length; j++) {
//            dynamic[0][j] = 1;
//        }
//        // Building the dynamic table
//        for(int i = 1; i <= target; i++){
//            for(int j = 1; j <= coins.length; j++){
//                // Number of ways without considering the current coin
//                dynamic[i][j] = dynamic[i][j - 1];
//                if (i - coins[j - 1] >= 0){
//                    dynamic[i][j] += dynamic[i - coins[j - 1]][j];
//                }
//            }
//        }
//        return dynamic[target][coins.length];
//    }
//}
    public static long countWays(int target, int[] coins) {
        // Create a 1D array to store the number of ways to make each amount
        long[] dynamic = new long[target + 1];
        dynamic[0] = 1;
        // Iterate through each coin
        for (int coin : coins) {
            // For each coin update the dynamic array
            for (int i = coin; i <= target; i++) {
                // Number of ways to make 'i' is increased by number of ways to make 'i - coin'
                dynamic[i] += dynamic[i - coin];
            }
        }
        return dynamic[target];

    }
}