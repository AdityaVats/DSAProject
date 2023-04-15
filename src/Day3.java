/**
 * Created by libsys on 2/23/2022.
 */
public class Day3 {
    public static int[] pixelLineCount(String s,int[] width){
        int[] result=new int[2];int l=0,p=0;
        for(char c:s.toCharArray()){
            p += width[(int)c-95];
            if(p==100){
                p=0;
                l++;
            }
        }
        result[0]=l;
        result[1]=p;
        return result;
    }
}
