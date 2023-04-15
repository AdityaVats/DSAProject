package rev1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 11/21/2022.
 */
public class MajorityElement3 {
    public static int getMajorityElementN2(int[] nums){
        int el = -1;
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(count==0){
                el = nums[i];
                count=0;
            }
            if(nums[i] == el)    count++;
            else    count--;
        }
        return el;
    }
    /**more than one candidate possible
     * Make sure they both never have same val (reason of using else if
     * After iteration it may be elmenet found may not have > N/3 so it antoher iterations**/
    public static List<Integer> getMajorityElementN3(int[] nums){
        int el1 = -1;
        int el2 = -1;
        int count1 = 0;
        int count2 = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int num = nums[i];
            if(el1 == num)  count1++;
            else if(el2 == num) count2++;
            else if(count1 == 0)    el1=num;
            else if(count2 == 0)    el2=num;
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0;i<n;i++){
            int num = nums[i];
            if(el1 == num)  count1++;
            else if(el2 == num)  count2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(count1>n/3)  ans.add(el1);
        if(count2>n/3)  ans.add(el2);
        return ans;

    }
    public static void main(String[] args){
        System.out.print(getMajorityElementN2(new int[]{2,3,3,3,3,1,2}));
    }
}
