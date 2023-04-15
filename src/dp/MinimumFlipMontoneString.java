package dp;

/**
 * Created by libsys on 1/17/2023.
 */
public class MinimumFlipMontoneString {

    public static int minFlips(String str){
        int n = str.length();
        int[][] dp = new int[n][2];
        String[][] strDP = new String[n][2];
        /**0 ==> keep same
         * 1 ==> flip bit**/

        dp[n-1][0] = 0;
        strDP[n-1][0] = str.charAt(n-1)+"";
        strDP[n-1][1] = str.charAt(n-1)=='0' ? "1" : "0";
        dp[n-1][1] = 1;

        for(int i=n-2;i>=0;i--){
            /**Case 1 : keep bit same**/
            int smallAns1 = Integer.MAX_VALUE;
            if(str.charAt(i) <= strDP[i+1][0].charAt(0) && dp[i+1][0]!=-1) smallAns1 = dp[i+1][0];


            int smallAns2 = Integer.MAX_VALUE;
            if(str.charAt(i) <= strDP[i+1][1].charAt(0) && dp[i+1][1]!=-1) smallAns2 = dp[i+1][1];

            if(smallAns1 < smallAns2){
                dp[i][0] = smallAns1 == Integer.MAX_VALUE ? -1 : smallAns1;
                strDP[i][0] = str.charAt(i) + strDP[i+1][0];
            } else {
                dp[i][0] = smallAns2 == Integer.MAX_VALUE ? -1 : smallAns2;
                strDP[i][0] = str.charAt(i) + strDP[i+1][1];
            }

            /**Case 1 : flip bit**/

            smallAns1 = Integer.MAX_VALUE;
            char flipped = str.charAt(i) == '0' ? '1' : '0';
            if(flipped  <= strDP[i+1][0].charAt(0) && dp[i+1][0]!=-1) smallAns1 = dp[i+1][0];


            smallAns2 = Integer.MAX_VALUE;
            if(flipped <= strDP[i+1][1].charAt(0) && dp[i+1][1]!=-1) smallAns2 = dp[i+1][1];

            if(smallAns1 < smallAns2){
                dp[i][1] = smallAns1 == Integer.MAX_VALUE ? -1 : 1+smallAns1;
                strDP[i][1] = flipped + strDP[i+1][0];
            } else {
                dp[i][1] = smallAns2 == Integer.MAX_VALUE ? -1 : 1+smallAns2;
                strDP[i][1] = flipped + strDP[i+1][1];
            }

        }
        int ans = -1;
        if(dp[0][0] == -1 && dp[0][1]==-1)  return -1;
        if(dp[0][0] == -1)                  return dp[0][1];
        if(dp[0][1] == -1)                  return dp[0][0];
        return Math.min(dp[0][0],dp[0][1]);

    }
    public static void main(String[] args){
        System.out.println(minFlips("111010"));
        System.out.println(minFlips("00110"));
        System.out.println(minFlips("010110"));
        System.out.println(minFlips("00011000"));
    }


}
