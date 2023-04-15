package arrays;

import java.util.*;

/**
 * Created by libsys on 9/30/2022.
 */
class Trio{
    int point;
    int height;
    boolean isStart;
    public Trio(int point,int height,boolean isStart){
        this.point = point;
        this.height = height;
        this.isStart = isStart;
    }
}
public class SkyLineProblem {
    public static List<List<Integer>>  getSkyLineCorrect(int[][] buildings){
        List<List<Integer>> ans = new ArrayList<>();
        List<Trio> points = new ArrayList<>();
        for(int[] building:buildings){
            points.add(new Trio(building[0],building[2],true));
            points.add(new Trio(building[1],building[2],false));
        }
        Comparator<Trio> comp = (t1,t2) -> {
          if(t1.point == t2.point){
              if(t1.isStart == t2.isStart){
                  if(t1.isStart) return t2.height - t1.height;
                  else return t1.height - t2.height;
              } else if (t1.isStart)    return -1;
              else  return 1;
          }
          return t1.point - t2.point;

        };

        Queue<Integer> pq = new PriorityQueue<>(Comparator.<Integer>reverseOrder());
        int prevMax = 0;
        for(Trio trio:points){
            int height = trio.height;
            if(trio.isStart)   pq.offer(height);
            else    pq.remove((Integer) height);
            int currHeight = pq.peek();
            if(prevMax!=currHeight){
                List<Integer> list = new ArrayList<>();
                list.add(trio.point);
                list.add(currHeight);
                ans.add(list);
                prevMax = currHeight;
            }
        }
        return ans;
    }
    /**wrong impl
    */
    public static List<List<Integer>>  getSkyLine(int[][] buildings){
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> criticalPoints = new TreeSet<>();
        for(int[] building:buildings){
            criticalPoints.add(building[0]);
            criticalPoints.add(building[1]);
        }

        Map<Integer,List<Integer>> map = new HashMap<>();
        /**O(n.n)**/
        for(int point:criticalPoints){
            int max1 = 0;
            int max2 = 0;
            for(int[] building:buildings){
                if(building[0]<=point && point<=building[1]){
                    int height = building[2];
                    if(height>max1){
                        max2 = max1;
                        max1 = height;
                    } else if(height>max2){
                        max2 = height;
                    }

                }
            }
            List<Integer> list = new ArrayList<>();
            list.add(max1);
            if(max2>0)  list.add(max2);
            map.put(point,list);
        }
        Set<Integer> endPoints = new TreeSet<>();
        /**O(n)**/
        for(int[] building:buildings){
            int ep = building[1];
            int height = building[2];
            if(map.get(ep).get(0) == height)    endPoints.add(ep);
        }
        /**O(n)**/
        for(int[] building:buildings){
            int sp = building[0];
            if(endPoints.contains(sp))  endPoints.remove((Integer)sp);
        }
        int currH=0;
        /**O(n)**/
        for(int point:criticalPoints){
            List<Integer> list = new ArrayList<>();
            List<Integer> heights = map.get(point);
            // first element
            if(ans.size()==0){
                list.add(point);
                list.add(heights.get(0));
                ans.add(list);
                currH = heights.get(0);
                continue;
            }
            // take second max
            if(endPoints.contains(point)){
                if(heights.size()==2){

                    list.add(point);
                    list.add(heights.get(1));
                    currH = heights.get(1);
                    ans.add(list);
                } else {
                    list.add(point);
                    list.add(0);
                    currH = 0;
                    ans.add(list);
                }
                continue;

            }

            if(currH >= heights.get(0)) continue;

            list.add(point);
            list.add(heights.get(0));
            currH = heights.get(0);
            ans.add(list);


        }
        return ans;



    }
    public static void main(String[] args){
        int[][] buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        int[][] buildings2 = new int[][]{{0,2,3},{2,5,3}};
        System.out.println(getSkyLineCorrect(buildings));
    }
}
