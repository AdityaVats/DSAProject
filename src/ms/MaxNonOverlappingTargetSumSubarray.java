package ms;

import java.util.*;

/**
 * Created by libsys on 2/21/2023.
 */
public class MaxNonOverlappingTargetSumSubarray {

    public static int maxCount(int[] nums,int target){
        List<Pair> intervals = subarraysWithTargetSum(nums,target);
        return getCount(intervals);
    }

    public static int getCount(List<Pair> intervals){

        // find all subarrays;
        Collections.sort(intervals, (p1,p2) -> p1.start == p2.start ? p1.end-p2.end : p1.start - p2.start);
        int minEnd = Integer.MIN_VALUE;
        int count = 0;
        for(Pair interval:intervals){
            int start = interval.start;
            int end = interval.end;
            if(start > minEnd){
                count++;
                minEnd = end;
            } else {
                minEnd = Math.min(minEnd,end);
            }
        }

        return count;
    }
    public static void main(String[] args){
        System.out.println(getCount(Arrays.asList(new Pair(1,9),
                                                    new Pair(2,15),
                                                    new Pair(3,5),
                                                    new Pair(4,7),
                                                    new Pair(6,8),
                                                    new Pair(10,11),
                                                    new Pair(12,13)
                        )));
        System.out.println(maxCount(new int[]{1, 1, 1, 1, 1}, 2));
        System.out.println(maxCount(new int[]{-1,3,5,1,4,2,-9},6));
    }
    public static List<Pair> subarraysWithTargetSum(int[] nums,int target){
        List<Pair> pairs = new ArrayList<>();
        Map<Integer,List<Integer>> prefixSum = new HashMap<>();
        prefixSum.put(0,new ArrayList<>(Arrays.asList(-1)));
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            //O(n.n)    BAD
            if(prefixSum.containsKey(sum-target)){
                for(int start:prefixSum.get(sum-target))    pairs.add(new Pair(start+1,i));
            }
            if(!prefixSum.containsKey(sum))                 prefixSum.put(sum,new ArrayList<>());
            prefixSum.get(sum).add(i);
        }
        return pairs;
    }
}
class Pair{
    int start;
    int end;
    public Pair(int start,int end){
        this.start = start;
        this.end = end;
    }
}
