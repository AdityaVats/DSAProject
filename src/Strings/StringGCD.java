package Strings;

/**
 * Created by libsys on 2/1/2023.
 */
public class StringGCD {
    public static String gcd(String str1,String str2){

        int m = str1.length();
        int n = str2.length();

        for(int i=n;i>=0;i--){
            String candidate = str2.substring(0,i);
            int l = candidate.length();
            boolean isGCD = true;
            for(int j=0;j<m;j+=l){
                if(j+l>m || !candidate.equals(str1.substring(j,j+l))){
                    isGCD = false;
                    break;
                }
            }
            if(!isGCD)  continue;
            for(int j=0;j<n;j+=l){
                if(j+l>n  || !candidate.equals(str1.substring(j,j+l))){
                    isGCD = false;
                    break;
                }
            }
            if(!isGCD)  continue;
            return candidate;
        }
        return "";
    }
    public static void main(String[] args){
        System.out.println(gcd("ABCABC","ABC"));
        System.out.println(gcd("ABABAB","ABAB"));
        System.out.println(gcd("ABABABA","ABAB"));
        System.out.println(gcd("LEET","CODE"));
    }
}
