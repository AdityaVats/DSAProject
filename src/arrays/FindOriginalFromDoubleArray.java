package arrays;

import java.util.*;

/**
 * Created by libsys on 9/15/2022.
 */
public class FindOriginalFromDoubleArray {

    public static int[] getOriginalArray(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);

        Map<Integer,Integer> valueToFreqMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int c = 0;
        for(int e:arr){
            if(e%2 !=0){
                valueToFreqMap.put(e,valueToFreqMap.getOrDefault(e,0)+1);
                continue;
            }
            if(valueToFreqMap.containsKey(e/2)){
                ans.add(e / 2);
                valueToFreqMap.put(e/2,valueToFreqMap.get(e/2)-1);
                if(valueToFreqMap.get(e/2)==0)  valueToFreqMap.remove(e/2);
                c++;
            } else {
                valueToFreqMap.put(e,valueToFreqMap.getOrDefault(e,0)+1);
            }
        }
        System.out.println(ans);
        if(c==n/2)  System.out.println(ans);
        else    System.out.println("[]");
        return null;
    }
    public static void main(String[] args){
        int[] arr = new int[]{1,3,4,2,6,8};
        getOriginalArray(arr);
        int[] arr2 = new int[]{6,3,0,1};
        getOriginalArray(arr2);

    }
}
