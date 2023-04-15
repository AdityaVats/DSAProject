package general;

import javax.xml.bind.DatatypeConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by libsys on 7/18/2022.
 */
public class RomanToInteger {



    public static int convertRomanToInteger(String roman){

        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);


        int res = 0;


        int prevVal = -1;
        for(int i=roman.length()-1;i>=0;i--){
            int currVal = map.get(roman.charAt(i));
            if(prevVal == -1)   res += currVal;
            else{
                if(currVal>=prevVal)    res += currVal;
                else                    res -= currVal;
            }

            prevVal = currVal;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(convertRomanToInteger("LXXIV"));


        int[][] data = new int[12][4];


/**** NEW CODE item type ***/
        if(false) {


            byte[] blockIdTemp = DatatypeConverter.parseHexBinary("0001");


            //length
            data[8][1] = 5;

            //blockID
            data[8][0] = blockIdTemp[1];
            data[9][3] = blockIdTemp[0];


            data[9][2] = 0x00;

            char itemType = 'B';
            byte itemHexVal;
            switch (itemType) {
                /**Book**/
                case 'B':
                    itemHexVal = 0x01;
                    break;
                /**Other IIPS**/
                case 'O':
                    itemHexVal = 0x04;
                    break;
                /**DVD NID**/
                case 'D':
                    itemHexVal = 0x02;
                    break;
                default:
                    itemHexVal = 0x01;//Book Tag
            }
            data[9][1] = itemHexVal;
            //checksum
            data[9][2] = (byte) (data[8][1] ^ data[8][0] ^ data[9][3] ^ data[9][2] ^ data[9][1]);


            /**** NEW CODE ***/
        }



        if(false) {

            String callNo ="randoString";
            byte[] blockIdTemp = DatatypeConverter.parseHexBinary("0003");

            //length
            data[9][0] = 4+callNo.length();

            //blockID
            data[10][3] = blockIdTemp[1];
            data[10][2] = blockIdTemp[0];
            int callNoBlockChecksum = data[9][0] ^ data[10][3] ^ data[10][2];

            int i=10,j=0;
            for(char ch:callNo.toCharArray()){
                if (j<0){
                    j=3;i++;
                }
                data[i][j]= (byte) ch;
                callNoBlockChecksum = callNoBlockChecksum ^ data[i][j];
                j--;
            }
            data[10][1] = (byte) callNoBlockChecksum;

            /**** NEW CODE ***/
        }

    }
    public static void writeISO(){
        int[][] data = new int[12][4];


/**** NEW CODE item type ***/
        if(false) {


            byte[] blockIdTemp = DatatypeConverter.parseHexBinary("0001");


            //length
            data[8][1] = 5;

            //blockID
            data[8][0] = blockIdTemp[1];
            data[9][3] = blockIdTemp[0];


            data[9][2] = 0x00;

            char itemType = 'B';
            byte itemHexVal;
            switch (itemType) {
                /**Book**/
                case 'B':
                    itemHexVal = 0x01;
                    break;
                /**Other IIPS**/
                case 'O':
                    itemHexVal = 0x04;
                    break;
                /**DVD NID**/
                case 'D':
                    itemHexVal = 0x02;
                    break;
                default:
                    itemHexVal = 0x01;//Book Tag
            }
            data[9][1] = itemHexVal;
            //checksum
            data[9][2] = (byte) (data[8][1] ^ data[8][0] ^ data[9][3] ^ data[9][2] ^ data[9][1]);


            /**** NEW CODE ***/
        }



        if(false) {

            String callNo ="randoString";
            byte[] blockIdTemp = DatatypeConverter.parseHexBinary("0003");

            //length
            data[9][0] = 4+callNo.length();

            //blockID
            data[10][3] = blockIdTemp[1];
            data[10][2] = blockIdTemp[0];
            int callNoBlockChecksum = data[9][0] ^ data[10][3] ^ data[10][2];

            int i=10,j=0;
            for(char ch:callNo.toCharArray()){
                if (j<0){
                    j=3;i++;
                }
                data[i][j]= (byte) ch;
                callNoBlockChecksum = callNoBlockChecksum ^ data[i][j];
                j--;
            }
            data[10][1] = (byte) callNoBlockChecksum;

            /**** NEW CODE ***/
        }
    }
    public static void readISO(){

    }
}
