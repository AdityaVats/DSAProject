package rev1;

/**
 * Created by libsys on 3/7/2023.
 */
public class MinTimeToCompleteTrips {
    public static int minTime(int[] time,int totalTrips){
        int low = 1;
        int min = Integer.MAX_VALUE;
        for(int el:time)    min = Math.max(min,el);
        int high = min*totalTrips;

        while(low <= high){
            int mid = low + (high-low)/2;
            int timeAlloted = mid;
            int trips = 0;
            for(int el:time){
                trips += timeAlloted/el;
            }
            if(trips >= totalTrips) high = mid - 1;
            else                    low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args){
        System.out.println(minTime(new int[]{1,2,3},5));
        System.out.println(minTime(new int[]{2}, 1));
    }

}
