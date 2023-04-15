package binarySearch;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by libsys on 12/26/2022.
 */
public class PickRandomWeight {
    int[] weights;
    int totalSum;
    int[] prefixSum;
    public PickRandomWeight(int[] weights){
        this.weights = weights;
        prefixSum = new int[weights.length];
        for(int i=0;i<weights.length;i++){
            prefixSum[i] = this.totalSum;
            this.totalSum += weights[i];
        }
    }
    public int pickIndex(){
        int pickedWeight = ThreadLocalRandom.current().nextInt(0,this.totalSum+1);

        int low = 0;
        int high = this.prefixSum.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(weights[mid] == pickedWeight)    return mid-1;

            if(weights[mid] < pickedWeight)     low = mid + 1;
            else                                high = mid - 1;
        }
        return  high;
    }
    public static void main(String[] args){
        PickRandomWeight pickRandomWeight = new PickRandomWeight(new int[]{1,3,5,2});

        System.out.println(pickRandomWeight.pickIndex());

        System.out.println(pickRandomWeight.pickIndex());

        System.out.println(pickRandomWeight.pickIndex());
    }
}
