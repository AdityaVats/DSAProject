package Strings;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by libsys on 2/3/2023.
 */
public class ZigZagConversion {



    public static String convert(String s,int numRows){
        if(numRows == 1)    return s;
        int groupSize = 2*(numRows-1);
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int el=0;el<groupSize && sb.length()<s.length() ;el++) {
            for (int g = 0; groupSize * g < n && sb.length()<s.length(); g++) {
                if (el == 0) {
                    int index1 = g * groupSize + el;
                    sb.append(s.charAt(index1));
                    continue;
                }
                int index1 = g * groupSize + el;
                if (index1 >= n) continue;
                sb.append(s.charAt(index1));
                int index2 = g * groupSize + groupSize - el;
                if (index1 != index2 && index2 < n) {
                    sb.append(s.charAt(index2));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(convert("ABCDEFGHIJKLM",4));
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("AB",1));
    }
}
class A{
    protected A method() throws IOException{
        return null;
    }
}

class B extends A{
    public B method() throws NumberFormatException {
        return null;
    }
}