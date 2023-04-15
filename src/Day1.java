import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by libsys on 2/21/2022.
 */
public class Day1 {
    public static String removeOuterParanthesis(String s) {
        boolean outer = false;
        String result = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (!outer) {
                    outer = true;
                    continue;
                } else {
                    result += s.charAt(i);
                    stack.push(s.charAt(i) + "");
                }

            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty() && outer) {
                    outer = false;
                    continue;
                } else {
                    result += ')';
                    stack.pop();

                }
            }

        }
        return result;
    }

    public static boolean equalVowels(String s) {
        String v = "aeiouAEIOU";
        int c = 0;
        int i = 0, j = s.length() / 2;
        while (i < s.length() / 2 && j < s.length()) {
            if (v.contains(s.charAt(i) + ""))
                c++;
            if (v.contains(s.charAt(j) + ""))
                c--;
            i++;
            j++;
        }
        if (c == 0)
            return true;
        return false;
    }

    public static int[] closestOccurence(String s, char c) {
        int length = -1;
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            int lC = 0, rC = 0;
            while (true) {
                if (left >= 0) {
                    if (s.charAt(left) == c)
                        break;
                    left--;
                    lC++;
                }
                if (right < s.length()) {
                    if (s.charAt(right) == c)
                        break;
                    right++;
                    rC++;
                } else {
                    break;
                }
            }
            if (left >= 0 && s.charAt(left) == c) {
                if (right < s.length() && s.charAt(right) == c)
                    result[i] = Math.min(lC, rC);
                else
                    result[i] = lC;

            } else if (right < s.length() && s.charAt(right) == c)
                result[i] = rC;
            else
                result[i] = -1;
        }
        return result;
    }

    public static int makeSorted() {
        String[] strs = {"cba","daf","ghi"};
        int c = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            String checkStr = "";
            for (int j = 0; j < strs.length; j++) {
                checkStr += strs[j].charAt(i)+"";
            }
            if (!isSorted(checkStr))
                c++;
        }
        return c;
    }

    public static boolean isSorted(String s) {
        for(int i=0;i<s.length()-1;i++){
            if((int)s.charAt(i)>(int)s.charAt(i+1))
                return false;
        }
        return true;
    }
    /**l is number of friends**/
    /**k is time**/
    public static List<Integer> passBaton(int l,long k){

        long round = k/(l-1);
        long extra = k%(l-1);
        List<Integer> result = new ArrayList<>();
        if(extra !=0){
            if(round%2!=0){

                result.add(l-(int)extra+1);
                result.add(l-(int)extra);
            }else{

                result.add((int)extra);
                result.add((int)extra+1);
            }
        }else{
            if(round%2!=0){
                result.add(l-1);
                result.add(l);

            }else{
                result.add(2);
                result.add(1);
            }
        }
        return result;
    }



    public static void main(String[] args){


    System.out.println(passBaton(5,7));

        System.out.println(removeOuterParanthesis("(()())(())"));
    }
}
