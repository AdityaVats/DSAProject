package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by libsys on 2/15/2023.
 */
public class AddToArrayForm {
    public static int[] sum(int[] nums,int k){
        int n = nums.length;
        int carry = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            int v1 = nums[i];
            int v2 = k%10;
            int smallAns = (v1+v2+carry)%10;
            carry = (v1+v2+carry)/10;
            ans.add(smallAns);
            k /= 10;
        }
        if(carry != 0)  ans.add(carry);
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++)   res[i] = ans.get(ans.size()-i-1);
        return res;
    }
    public static void main(String[] args){
        System.out.print(Arrays.toString(sum(new int[]{9,9,0,9},9946)));
    }
}
