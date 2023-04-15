package rev1;

/**
 * Created by libsys on 12/5/2022.
 */

import java.util.Stack;

/**not able to do**/
public class VerifyPreOrderSerialization {
    /***stack approach***/
    public static boolean isValid(String s){
        Stack<String> stack = new Stack<>();
        String[] parts = s.split(",");
        for(String el:parts){
            if(el.equalsIgnoreCase("#")){
                /*** left child was null &&
                 *   I am the right child that is also null
                 *   meaning the subtree is over
                 *   need to clear that subtree and place a null for that complete sub tree
                 *
                 *   note:  doing extra work of putting parent and # and popping in later stage when subtree is over
                 */
               if(!stack.isEmpty() && stack.peek().equalsIgnoreCase("#")){
                   while(!stack.isEmpty() && stack.peek().equalsIgnoreCase("#")){
                       stack.pop();                             /** # is popped **/
                       if(stack.isEmpty())  return false;
                       stack.pop();                             /** el is popped**/
                   }

               }
               stack.push("#");
            } else {
                stack.push(el);
            }
        }
        if(stack.size()==1 && stack.peek().equalsIgnoreCase("#"))   return true;
        else                                                        return false;
    }
    public static boolean isValidUsingStack(String s){
        Stack<String> stack = new Stack<>();
        String[] parts = s.split(",");
        for(String el:parts){
            if(el.equals("#")){
                if(!stack.isEmpty() && stack.peek().equals("#"))    return false;
                if(stack.isEmpty()) stack.push(el);
                else stack.pop();
            } else {
                stack.push(el);
            }
        }
        return stack.size()==1 && stack.peek().equals("#");
    }
    public static void main(String[] args){
        System.out.println(isValidUsingStack("9,3,4,#,#,1,#,#,2,#,1,#,#"));

        System.out.println(isValidUsingStack("9,#,1,1"));
    }
}
