package arrays;

import java.util.Stack;

/**
 * Created by libsys on 3/23/2023.
 */
public class MaxOfMinProductArray {

    public static int getMax(int[] nums){
        int n = nums.length;
        Stack<int[]> stack = new Stack<>();
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        int prevMin = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()[1] < nums[i]) stack.push(new int[]{ i,nums[i]});
            while(!stack.isEmpty() && stack.peek()[1] < nums[i]){
                int [] curr = stack.pop();
                if(curr[1] )
                sum += curr[1];
                int prod = curr[1] * sum;
                ans = Math.max(ans,prod);
            }
        }
    }
}
