package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by libsys on 1/16/2023.
 */
public class InsertInterval {
    //O(nlogn) sol.
    public static int[][] insertIntervals(int[][] intervals,int[] newInterval){
        TreeSet<int[]> points = new TreeSet<>(
                (p1,p2) -> {
                    return p1[0] == p2[0] ? (p1[2]==0 ? 0 : 1) : p1[0]-p2[0];
                }
        );
        int n = intervals.length;
        for(int i=0;i<intervals.length;i++){
            int[] interval = intervals[i];
            points.add(new int[]{interval[0],i,0});
            points.add(new int[]{interval[1],i,1});
        }
        int[] s = new int[]{newInterval[0],-1,0};
        int[] e = new int[]{newInterval[1],-1,1};
        int[] prevPoint = points.lower(s);
        int[] nextPoint = points.higher(e);

        int i = prevPoint == null ? -1 : prevPoint[1];
        int j = nextPoint == null ? n : nextPoint[1];
        /**         [0------------i-1]  [i                [new interval]                                  j]  [j+1------------------n-1]
         *              P1                                      P2                                                    P3                    **/
        int countP1 = i==-1 ? 0 : i-1-0+1;

        boolean isLeftOverlap = prevPoint!=null && (prevPoint[2] == 0);
        boolean isRightOverlap = nextPoint!=null && (nextPoint[2] == 1);
        int countP2 = 1;
        if(isLeftOverlap && isRightOverlap) countP2 = 1;
        else if(isLeftOverlap)  countP2 = 1 + (nextPoint==null ? 0 : 1);
        else if(isRightOverlap) countP2 = (prevPoint==null ? 0 : 1) + 1;
        else                    countP2 = (prevPoint==null ? 0 : 1) + 1 + (nextPoint==null ? 0 : 1);

        int countP3 = j==n ? 0 : n-j-1;


        int[][] ans = new int[countP1+countP2+countP3][2];
        int ansItr = 0;
        for(int itr=0;itr<i;itr++)  ans[ansItr++] = intervals[itr];
        if(isLeftOverlap && isRightOverlap){
            ans[ansItr++] = new int[]{prevPoint[0],nextPoint[0]};
        }
        else if(isLeftOverlap){
            ans[ansItr++] = new int[]{prevPoint[0],newInterval[1]};
            if(nextPoint!=null) ans[ansItr++] = intervals[j];
        }
        else if(isRightOverlap){
            if(prevPoint!=null) ans[ansItr++] = intervals[i];
            ans[ansItr++] = new int[]{newInterval[0],nextPoint[0]};
        }
        else{
            if(prevPoint!=null) ans[ansItr++] = intervals[i];
            ans[ansItr++] = new int[]{newInterval[0],nextPoint[0]};
            if(nextPoint!=null) ans[ansItr++] = intervals[j];
        }

        for(int itr=j+1;itr<n;itr++)  ans[ansItr++] = intervals[itr];

        return ans;
    }
    public static void main(String[] args){
        System.out.println(Arrays.deepToString(insertIntervalsInOn(
                new int[][]{
                        {1, 3},
                        {6, 9}
                }
                , new int[]{2, 5}

        )));

        System.out.println(Arrays.deepToString(insertIntervalsInOn(
                new int[][]{
                        {1,2},
                        {3,5},
                        {6,7},
                        {8,10},
                        {12,16}
                }
                , new int[]{4,8}

        )));
    }
    public static int[][] insertIntervalsInOn(int[][] intervals,int[] newInterval){
        //List<List<Integer>> intervals = new ArrayList<>();
        int pos = intervals.length;
        int n = intervals.length;
        for(int i=0;i<n;i++){
            if(intervals[i][0] > newInterval[0]){
                pos = i;
                break;
            }
        }
        int l = 0,h=n-1;
        pos = intervals.length;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(intervals[mid][0] > newInterval[0]){
                pos = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int itr = 0;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<=intervals.length;i++){
            if(pos == i)    list.add(newInterval);
            else            list.add(intervals[itr++]);
        }
        List<int[]> ans = new ArrayList<>();
        ans.add(list.get(0));
        for(int i=1;i< list.size();i++){
            int[] prevInterval = ans.get(ans.size()-1);
            int[] currInterval = list.get(i);
            if(prevInterval[1] < currInterval[0]){
                ans.add(currInterval);
            } else {
                ans.set(ans.size()-1,new int[]{Math.min(prevInterval[0],currInterval[0]),Math.max(prevInterval[1],currInterval[1])});
            }
        }
        int[][] ansArr = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++)   ansArr[i] = ans.get(i);
        return ansArr;

    }
}
