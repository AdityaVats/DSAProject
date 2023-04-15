package rev1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by libsys on 2/28/2023.
 */
public class SlidingWindowMax {
    public static int[] getMax(int[] nums,int k){
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int[] ans = new int[n-k];
        int itr = 0;
        for(int i=0;i<n;i++){

            if(deque.isEmpty() || nums[deque.pollLast()] <= nums[i]) deque.offer(i);
            while(deque.isEmpty() || deque.peekFirst() < i-k)       deque.pollFirst();
            // elements remaining in deque are all in range and greater than current element
            // use the smallest of these as the max
            if(i>=k)
                ans[itr++] = deque.peekFirst();
            deque.offerLast(i);

        }
        return ans;
    }
}
