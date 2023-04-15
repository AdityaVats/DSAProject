package arrays;

import java.util.*;

/**
 * Created by libsys on 10/7/2022.
 */
class P{
    int point;
    boolean isStart;
    public P(int point,boolean isStart){
        this.point = point;
        this.isStart = isStart;
    }
    public String toString(){
        return point+" "+isStart;
    }
}

public class MyCalender3 {
    List<P> list;
    Map<Integer,Integer> pointToDiff;
    public MyCalender3(){
        list = new ArrayList<>();
        // maintain in asc points order
        pointToDiff = new TreeMap<>();
    }
    // basic correct approach
    public int book1(int start,int end){
        list.add(new P(start,true));
        list.add(new P(end, false));
        Collections.sort(list,(p1,p2) -> {
            //
            if(p1.point != p2.point) return p1.point-p2.point;
            if(p1.isStart == p2.isStart)    return -1;
            if(p1.isStart)  return 1;
            return -1;
        });
        int k = 0;
        int curr = 0;
        for(P p:list){
            if(p.isStart)   curr++;
            else    curr--;
            k = Math.max(k,curr);
        }
        return k;
    }
    // better approach
    // maintain a hahsmap in place of array as input constraint is sparse over a wide range
    // you only need diff of each point
    // hence dont maitain ech point separately
    /**Sweep line algo**/
    public int book(int start,int end){
        pointToDiff.put(start,pointToDiff.getOrDefault(start,0)+1);
        pointToDiff.put(end,pointToDiff.getOrDefault(end,0)-1);
        int curr = 0;
        int k = 0;
        for(int point:pointToDiff.keySet()){
            curr += pointToDiff.get(point);
            k = Math.max(k,curr);
        }
        return k;

    }
}
