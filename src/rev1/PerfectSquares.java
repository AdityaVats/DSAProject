package rev1;

/**
 * Created by libsys on 12/9/2022.
 */
public class PerfectSquares {
    public static int getCount(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int ans = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                if(i-j*j<0) continue;
                if(dp[i-j*j]==Integer.MAX_VALUE)    continue;
                ans = Math.min(ans,1+dp[i-j*j]);
            }
            dp[i] = ans;
        }

        return  dp[n];
    }


    public static void main(String[] args){
        System.out.println(getCount(12));
        System.out.println(getCount(13));
    }

}
