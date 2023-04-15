package rev1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by libsys on 11/21/2022.
 */
public class LongestConsecutiveSubsequence {
    public static int getLongestConsecutiveSubsequence(int[] nums){
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int num:nums)   set.add(num);
        int ans = 0;
        for(int i=0;i<n;i++){
            if(/*!set.contains(nums[i]) ||*/ set.contains(nums[i]-1))  continue;

            int length = 1;
            Integer nextEl = nums[i]+1;
            while(set.contains(nextEl)){
                set.remove(nextEl);
                nextEl++;
                length++;
            }
            ans = Math.max(ans,length);
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.print(getLongestConsecutiveSubsequence(new int[]{100,6,200,7,8,9,66}));
    }
}
