package ms;

import java.util.Stack;

/**
 * Created by libsys on 1/5/2023.
 */
public class RevSubstringBetweenParanthesis {
    /** s1 and s2
     *  (   x   k   (   i   m   (   l   o   v   e   )   z   k   )   o   p   )

     *
     *  (   x   k   (   i   m   (   l   o   v   e
     *
     *  Found ')' ===> pop until '(' and keep in a string and then push it back again
     *
     *  (   x   k   (   i   m
     *  evol
     *
     *  (   x   k   (   i   m   e   v   o   l   z   k
     *
     *  x   k
     *
     *  kzlovemi
     *
     *
     *  (   x   k   k   z   l   o   v   e   m   i   o   p
     *
     *
     *  p   o   i   m   e   v   o   l   z   k   k   x
     *
     *  result is  ===> pomevolzkkx
     *
     * **/
    public static String rev(String s){

        int n = s.length();

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<n;i++){
            if(s.charAt(i)==')'){
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
                for(int j=0;j<sb.length();j++){
                    stack.push(sb.charAt(j));
                }

            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty())  sb.append(stack.pop());

        return sb.reverse().toString();
    }
    public static void main(String[] args){
        System.out.println(rev("(xk(im(love)zk)op)"));
    }
}
