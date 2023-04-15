package Strings;

/**
 * Created by libsys on 11/9/2022.
 */
public class KthPermutation {



    public static String getKthPerm(int n,int k){
        String str = "";
        for(int i=1;i<=n;i++)   str += i;
        return helper(str,n,k-1);
    }
    public static String helper(String str,int n,int k){
        if(n==0)    return "";

        int index = k / factorail(n-1);

        String ans = str.charAt(index) + "";

        int newK = k - (index*factorail(n-1));
        int newN = n-1;
        String newStr = str.substring(0,index) + (index == str.length() ? "" : str.substring(index+1));
        String smallAns = helper(newStr,newN,newK);
        ans += smallAns;
        return ans;
    }
    public static int factorail(int n){
        return n==0 || n==1 ? 1 : n*factorail(n-1);
    }
    public static void main(String[] args){
        System.out.println(getKthPerm(3,4));
    }

}
