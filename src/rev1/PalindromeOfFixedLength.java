package rev1;

import java.util.Arrays;

/**
 * Created by libsys on 3/10/2023.
 */
public class PalindromeOfFixedLength {

    public static int[] getValue(int intLength,int[] queries){
        int num = (intLength+1)/2;
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            queries[i]--;
            int val = (int) Math.pow(9,num-1);
            int quo =  queries[i]/val;
            int rem =  queries[i]%val;
            String smallAns = (quo+1) + "" +helper(num-1,rem);
            String ansStr = "";
            if(intLength % 2 == 0)  ansStr = smallAns+new StringBuilder(smallAns).reverse().toString();
            else                    ansStr = smallAns + new StringBuilder(smallAns.substring(0,smallAns.length()-1)).reverse().toString();
            ans[i] = Integer.parseInt(ansStr);
        }
        return ans;
    }
    public static String helper(int num,int k){
        if(num == 0){
            return "";
        }
        int val = (int) Math.pow(10,num-1);
        int quo =  k/val;
        int rem =  k%val;

        return quo + "" + helper(num-1,rem);
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(getValue(4,new int[]{1,2,3,7})));
    }

}
