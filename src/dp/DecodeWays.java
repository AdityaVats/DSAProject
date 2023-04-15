package dp;

/**
 * Created by libsys on 8/19/2022.
 */
public class DecodeWays {
    public static int decode(String s){
        if(s.isEmpty()) return 0;
        int[][] dp = new int[s.length()+1][2];

        if(s.charAt(s.length()-1)!='0') dp[s.length()-1][0] = 1;
        dp[s.length()][0] = 1;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i) == '0')  continue;

            dp[i][0] = dp[i+1][0]+dp[i+1][1];
            if(Integer.parseInt(s.substring(i,i+2))<27) dp[i][1] = dp[i+2][0] + dp[i+2][1];
        }

        return dp[0][0] + dp[0][1];
    }
    public static int optimised(String s){
        if(s.isEmpty()) return 0;
        if(s.charAt(0)=='0')    return 0;
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        if(s.charAt(s.length()-1) != '0')   dp[s.length()-1] = 1 + 0;

        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i) == '0')   continue;
            dp[i] = dp[i+1];
            if(Integer.parseInt(s.substring(i,i+2))<27) dp[i]+=dp[i+2];
        }
        return dp[0];
    }
    public static void main(String[] args){
        System.out.println(decode("306"));
        System.out.println(decode("26223"));
    }
}
