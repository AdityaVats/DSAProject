package arrays;

import java.util.Arrays;

/**
 * Created by libsys on 9/13/2022.
 */
public class UTF8 {

    public static boolean validateUTF(int[] data){
        int n = data.length;
        String[] binaryData = new String[n];

        for(int i=0;i<n;i++)    binaryData[i] = Integer.toBinaryString(data[i]);

        for(int i=0;i<n;i++){
            while(binaryData[i].length()<8) binaryData[i] = '0'+binaryData[i];
            if(binaryData[i].length()>8) binaryData[i] = binaryData[i].substring(binaryData[i].length()-8);
        }
        int search = 1;

        for(int i=n-1;i>=0;i--){

            if(search == 1 && binaryData[i].charAt(0)=='0'){
                continue;
            }

            if(binaryData[i].startsWith("10")){
                search++;
                continue;
            }
            if(search == 2){
                if( binaryData[i].startsWith("110"))
                search=2;
                continue;
            }
            if(search == 3 && binaryData[i].startsWith("110")){
                search=1;
                continue;
            }

            if(search == 4 && binaryData[i].startsWith("110")){
                search=1;
                continue;
            }

        }

        System.out.print(Arrays.toString(binaryData));
        return false;
    }

    public static void main(String[] args){
        int[] data = new int[]{237,197,130,1};
        validateUTF(data);
    }
}
