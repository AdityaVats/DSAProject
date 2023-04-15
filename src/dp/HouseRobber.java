package dp;

/**
 * Created by libsys on 11/7/2022.
 */
public class HouseRobber {

    public static int maxRobbing(int[] houses){
        //return helper(houses,0,true);
        return helperDP(houses);
    }
    public static int helper(int[] houses,int index,boolean canRob){
        if(index == houses.length)  return 0;

        if(canRob){
            int robNow = houses[index] + helper(houses,index+1,false);
            int robLater = helper(houses,index+1,true);
            return Math.max(robNow,robLater);
        } else {
            int robLater = helper(houses,index+1,true);
            return robLater;
        }
    }
    public static int helperDP(int[] houses){
        int n = houses.length;
        int[][] dp = new int[n][2];
        // 0 -> not rob curr house
        // 1 -> rob curr house
        dp[0][0] = 0;
        dp[0][1] = houses[0];

        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1] = houses[i]+dp[i-1][0];
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
    public static void main(String[] args){
        int[] houses = new int[]{5,5,10,100,10,5};
        System.out.println(maxRobbing(houses));
    }
}
