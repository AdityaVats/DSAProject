package dp;

import java.util.Arrays;

/**
 * Created by libsys on 1/6/2023.
 */
public class MaxIceCreamBar {

    /**
     * Memory Limit Exceeded
     *
     * Prefer greeedy because distribution is uniform (unlike knapsack)
     * **/
    public static int maxBars(int[] cost,int coins){
        int[][] dp = new int[cost.length][coins+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i-1<0){
                    if(j>=cost[i])  dp[i][j] = 1;
                    continue;
                }
                dp[i][j] =
                        Math.max(
                            dp[i-1][j],
                            j-cost[i]>=0 ? dp[i-1][j-cost[i]] + 1 : 0
                        );
            }
        }
        return dp[cost.length-1][coins];
    }

    /**Greedy**/
    public static int maxBarsGreedy(int[] costs,int coins){
        int count = 0;
        Arrays.sort(costs);
        for(int cost:costs){
            if(coins < cost)   break;
            coins -= cost;
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(maxBarsGreedy(new int[]{1, 3, 2, 4, 1}, 7));
        System.out.println(maxBarsGreedy(new int[]{10, 6, 8, 7, 7, 8}, 5));
        System.out.println(maxBarsGreedy(new int[]{1,6,3,1,2,5},20));
    }
}
