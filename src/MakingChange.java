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
        return recursiveCall(target, coins, 0);
    }


    private static int recursiveCall(int target, int[] coins, int index) {

        if (target == 0){
            return 1;
        }
        if (target < 0){
            return 0;
        }
        if(index >= coins.length){
            return 0;
        }

        int count  = 0;
        // Includes coin
        count += recursiveCall(target - coins[index], coins, index);
        // Excludes coin
        count += recursiveCall(target, coins, index + 1);

        return count;

    }


}