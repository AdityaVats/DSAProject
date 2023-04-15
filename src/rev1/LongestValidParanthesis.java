package rev1;

import java.util.Stack;

/**
 * Created by libsys on 2/20/2023.
 */
/**
 *
 * X          X
 * ( ( ) ( ) ( ( ) ( ( ) )
 * 0 1 2 3 4 5 6 7
 *
 * 0 5
 *
 * extra ( or ) will act as barriers ==> from which valid paranthesis start
 *          X
 * ( ) ( ) ) ( ( ) )
 *
 *
 *
 *
 *
 * **/
public class LongestValidParanthesis {

    public static int getLongest(String s){
        int n = s.length();

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        stack.push(-1);
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            } else {
                if(stack.peek() == -1 || s.charAt(stack.peek()) == ')')  stack.push(i);
                else{
                    stack.pop();
                    ans = Math.max(ans,i-stack.peek());
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(getLongest("(()()(()))(()"));

        System.out.println(getLongest("(()()(()"));
        System.out.println(getLongest("()()))(()()(())"));
        System.out.println(getLongest("()()))(()()(())"));
    }
}
