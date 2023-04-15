package Strings;

/**
 * Created by libsys on 10/10/2022.
 */
public class BreakPalindrome {

    public static String breakPalidrome(String s){
        int n = s.length();
        char[] cArr = s.toCharArray();
        boolean canBreakP = false;
        for(int i=0;i<n;i++){
            // middle or odd length string
            if(n%2!=0 && i==n/2)    continue;
            // first half
            if(i<n/2){
                if(cArr[i]=='a')    continue;
                cArr[i] = 'a';
                canBreakP = true;
                break;
            }
            // second half
            else {
                if(cArr[i]=='a')    continue;
                cArr[i] = 'a';
                canBreakP = true;
                break;
            }
        }
        return  canBreakP ? new String(cArr) : "";

    }
    public static void main(String[] args){
        System.out.println(breakPalidrome("abccba"));

        System.out.println(breakPalidrome("dbccbd"));

        System.out.println(breakPalidrome("aaa"));
        System.out.println(breakPalidrome("abb"));
        System.out.println(breakPalidrome("aba"));
        System.out.println(breakPalidrome("a"));
    }
}
