package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by libsys on 9/29/2022.
 */
public class KClosestElements {
    public static int[] kClosest(int[] nums,int k,int x){
        Comparator<Pair> comp = (p1,p2) -> Math.abs(p2.v-x)-Math.abs(p1.v-x)==0? p2.i-p1.i : Math.abs(p2.v-x)-Math.abs(p1.v-x);
        PriorityQueue<Pair> pq = new PriorityQueue<>(comp);

        int l = 0;
        int h = 0;
        while(l<=h){
            int mid= l+(h-l)/2;
            pq.offer(new Pair(mid,nums[mid]));
            if(pq.size()==k+1)  pq.poll();
            if(x<nums[mid]){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        int[] ans = new int[k];
        while(!pq.isEmpty()){
            System.out.println(pq.poll().v);
        }
        //for(int i=0;i<k;i++)    ans[i] = pq.poll().v;
        return ans;
    }


    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(kClosest(nums,4,3)));
    }
}
class Pair{
    int i;
    int v;
    public Pair(int i,int v){
        this.i = i;
        this.v = v;
    }
}