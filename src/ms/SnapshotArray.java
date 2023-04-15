package ms;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by libsys on 1/4/2023.
 */
public class SnapshotArray {

    TreeMap<Integer,TreeMap<Integer,Integer>>   snaps = new TreeMap<>();
    int lastSnapId = 0;

    public SnapshotArray(int length){
        TreeMap<Integer,Integer>    indexMap = new TreeMap<>();
        for(int i=0;i<length;i++)  indexMap.put(i,0);
        snaps.put(0,indexMap);
    }
    /**O(n)**/
    public void snap(){

        snaps.put(++lastSnapId,new TreeMap<Integer,Integer>());
    }
    /**O(log n)**/
    public void set(int index,int value){
        snaps.get(lastSnapId).put(index, value);
    }
    /**O(log n)**/
    public int get(int snapId,int index){
        int low = 0;
        int high = snapId;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(snaps.get(mid).containsKey(index)){
                ans = snaps.get(mid).get(index);
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0,5);
        snapshotArray.snap();
        snapshotArray.set(0, 6);
        System.out.println(snapshotArray.get(0,0));
    }
}
