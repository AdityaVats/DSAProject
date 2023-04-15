package rev1;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by libsys on 11/28/2022.
 */
public class MyCalender1 {
    TreeSet<int[]> bookings;
    public MyCalender1(){
        bookings = new TreeSet<>( (b1,b2) -> b1[0] - b2[0] );
    }
    public boolean book(int start,int end){
        int[] booking = new int[]{start,end};
        if(bookings.isEmpty()){
            bookings.add(booking);
            return true;
        }
        int[] beforeBooking = bookings.ceiling(booking);
        int[] afterBooking = bookings.floor(booking);

        if((beforeBooking==null || beforeBooking[1] < booking[0]) && (afterBooking==null || booking[1] < afterBooking[0])){
            bookings.add(booking);
            return true;
        }
        return false;

    }
}
