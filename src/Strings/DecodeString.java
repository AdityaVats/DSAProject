package Strings;

import java.util.Stack;

/**
 * Created by libsys on 12/23/2022.
 */
public class DecodeString {
    public static String decode(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                StringBuilder numBuilder = new StringBuilder();
                while (i < n && Character.isDigit(ch)) {
                    numBuilder.append(ch + "");
                    ch = str.charAt(++i);
                }
                int num = Integer.parseInt(numBuilder.toString());
                StringBuilder ssb = new StringBuilder();
                Stack<Character> stack = new Stack<>();
                stack.push(ch);
                int j = i+1;
                while(true){
                    if(str.charAt(j) == '['){
                        stack.push('[');
                    } else if(str.charAt(j) == ']'){
                        stack.pop();
                        if(stack.isEmpty()) break;
                    }
                    ssb.append(str.charAt(j));
                    j++;
                }
                String smallAns = decode(ssb.toString());
                while(num-->=1){
                    sb.append(smallAns);
                }
                i = j;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(decode("3[ab]a2[3[ak]a]"));
    }
}
