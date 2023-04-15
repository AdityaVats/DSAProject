package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 7/25/2022.
 */
public class PascalTriangle2 {

    public static List<Integer> getRow(int rowIndex){

        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex == 1) return res;
        res.add(1);
        if(rowIndex == 2) return res;


        rowIndex -= 2;
        while(rowIndex-->0){
            int i = 1;
            int prevVal = 1;
            while (i<res.size()){
                int newVal = prevVal + res.get(i);
                prevVal = res.get(i);
                res.set(i,newVal);
                i++;
            }
            res.add(1);
        }
        return res;


    }
    public static void main(String[] args){
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow(5));
        System.out.println(getRow(6));
    }
}
