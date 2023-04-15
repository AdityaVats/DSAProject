package trees;

/**
 * Created by libsys on 6/17/2022.
 */
public class UniqueBSTCount {
    public static int uniqueTrees(int n){
        if(n==0 || n==1)   return 1;
        int res =0;
        for(int i=0;i<n;i++) {
            res += uniqueTrees(i)*uniqueTrees(n-i-1);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.print(uniqueTrees(6));
    }
}
