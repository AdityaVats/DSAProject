package arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by libsys on 8/18/2022.
 */
public class ReduceArraySizeToHalf {
    public static int reduce(int[] arr){
        int max = arr[0];
        for(int num:arr)    max = Math.max(max,num);

        int[] freq = new int[max+1];

        for(int num:arr)    freq[num]++;
        Arrays.sort(freq);


        int n = arr.length;
        int setSize = 0;
        int count = 0;

        for(int i=freq.length-1;i>=0;i--){
            setSize++;
            count += freq[i];
            if(count >= n/2)    return setSize;
        }

        return -1;

    }
    public static void main(String[] args){
        int[] arr = new int[]{7,7,7,7};
        System.out.println(reduce(arr));
    }
}
