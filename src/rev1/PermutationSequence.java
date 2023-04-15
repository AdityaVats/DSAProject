package rev1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by libsys on 12/13/2022.
 */
public class PermutationSequence {
    public static String getKthPermutation(int n,int k){
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++)   sb.append(i);
        //return helper(n,k-1,sb);
        return helperOptimal(n,k-1,sb);
    }
    public static String helper(int n,int k,StringBuilder sb){
        if(n==0)    return "";
        if(n==1)    return sb.charAt(0)+"";
        int fac = factorial(n-1);
        int quo =  k/fac;
        int rem = k%fac;

        String ans = "";
        ans = (sb.charAt(quo)) + "";
        sb.deleteCharAt(quo);
        return ans + helper(n-1,rem,sb);


    }
    public static String helperOptimal(int n,int k,StringBuilder sb){
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for(int i=1;i<=n;i++)   factorial[i] = i*factorial(i-1);
        String ans = "";
        for(int i=n;i>0;i--){
            int index = k/factorial[i-1];
            k = k%factorial[i-1];
            ans += sb.charAt(index);
            sb.deleteCharAt(index);
        }
        return ans;
    }
    public static int factorial(int n){
        return n<=1 ? 1 : n*factorial(n-1);
    }
    public static void main(String[] args){
        System.out.println(rev2(5,28));
    }


    public static String rev2(int n,int k){
        String s = Stream.iterate(1,i -> i+1)
                         .limit(n)
                         .map(i -> String.valueOf(i))
                         .collect(Collectors.joining());
        return helperRev2(s,k-1);
    }
    public static String helperRev2(String s,int k){
        if(k<=1)    return s;
        int n = s.length();
        int factN = factorial(n-1);
        int quo = factN/k;
        int rem = factN%k;
        String res = s.charAt(quo)+"";
        String smallProblem = s.substring(0,quo) + s.substring(quo+1);
        String smallAns = helperRev2(smallProblem,rem);
        return res+smallAns;
    }
}
