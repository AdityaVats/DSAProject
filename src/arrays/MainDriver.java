package arrays;

/**
 * Created by libsys on 10/7/2022.
 */
public class MainDriver {

    public static  void main(String[] args){
        MyCalender3 myCalender3 = new MyCalender3();
        System.out.println(myCalender3.book(10, 20));
        System.out.println(myCalender3.book(50, 60));
        System.out.println(myCalender3.book(10, 40));
        System.out.println(myCalender3.book(5, 15));
        System.out.println(myCalender3.book(5, 10));
        System.out.println(myCalender3.book(25, 55));

    }
}
