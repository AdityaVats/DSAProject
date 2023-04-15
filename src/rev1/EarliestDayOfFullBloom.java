package rev1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by libsys on 11/18/2022.
 */
public class EarliestDayOfFullBloom {

    public static int fullBloom(int[] plantTime,int[] growTime){
        List<Pair> list = new ArrayList<>();
        int n = plantTime.length;
        for(int i=0;i<n;i++){
            list.add(new Pair(plantTime[i],growTime[i]));
        }

        Collections.sort(list,(o1,o2) -> o2.grow - o1.grow);
        int days = 0;
        int plantTimeSum = 0;
        for(Pair pair:list){
            int plant = pair.plant;
            int grow = pair.grow;
            plantTimeSum += plant;
            days = Math.max(days,plantTimeSum+grow);
        }
        return days;
    }
    public static void main(String[] args){
        int[] plant = new int[] {1,4,3};
        int[] grow = new int[] {2,3,1};
        System.out.println(fullBloom(plant,grow));
    }
}
class Pair{
    int plant;
    int grow;
    public
    Pair(int plant,int grow){
        this.plant = plant;
        this.grow = grow;
    }
}
