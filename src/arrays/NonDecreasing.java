package arrays;

/**
 * Created by libsys on 6/29/2022.
 */
public class NonDecreasing {

    /**           O(n) O(1)
     *            fault point is i

     *            lower limit nums[i-2]
     *            upper limit nums[i+1]

     *            if nums[i-1] OR nums[i] lie within the limit  return true
     *            else false

     * **/
    public static boolean possibleNonDecreasing(int[] nums){

        int faultIndex = -1;
        int faultCount = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                if(faultCount == 1) return false;
                faultIndex=i;
                faultCount++;
            }
        }
        if(faultCount == 0 || faultIndex-2<0 || faultIndex+1>nums.length-1){
            return true;
        }
        int lowerLimit = nums[faultIndex-2];
        int upperLimit = nums[faultIndex+1];
        if( lowerLimit > upperLimit ) return false;
        if((lowerLimit<= nums[faultIndex-1] && nums[faultIndex-1]<=upperLimit) || (lowerLimit<= nums[faultIndex] && nums[faultIndex]<=upperLimit))
            return true;
        return false;

    }
    public static void main(String arg[]){
        int[] arr = {5,7,5,10};
        System.out.println(possibleNonDecreasing(arr));
    }
}
