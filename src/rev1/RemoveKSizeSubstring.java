package rev1;

import java.util.Stack;

/**
 * Created by libsys on 2/16/2023.
 */
public class RemoveKSizeSubstring {
    public static String remove(String s,int k){
        Stack<int[]> stack = new Stack<>();
        int n = s.length();

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek()[0] != c) stack.push(new int[]{c,1});
            else{
                stack.peek()[1]++;
                if(stack.peek()[1] == 3){
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            int[] val = stack.pop();
            for(int i=0;i<val[1];i++)   sb.append((char)val[0]);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        System.out.println(remove("aabbbacdddcceff",3));
    }
}
