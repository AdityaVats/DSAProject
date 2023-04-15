import javax.xml.bind.DatatypeConverter;

/**
 * Created by libsys on 9/14/2022.
 */
public class ISOWrite {
    public static void main(String[] args){
        int[][] data = null;
        String itemTypeAsString,callNo;
        int i,j;
        if(false){
            byte[] blockIdTemp = DatatypeConverter.parseHexBinary("0001");


            //length
            data[8][1] = 5;

            //blockID
            data[8][0] = blockIdTemp[1];
            data[9][3] = blockIdTemp[0];


            data[9][2] = 0x00;

            char itemType = itemTypeAsString.charAt(0);
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

        }

        if(false){
            //String callNo ="ekAurRandoString";
            byte[] blockIdTemp = DatatypeConverter.parseHexBinary("0003");

            //length
            data[9][0] = (byte)(4+callNo.length());

            //blockID
            data[10][3] = blockIdTemp[1];
            data[10][2] = blockIdTemp[0];
            int callNoBlockChecksum = data[9][0] ^ data[10][3] ^ data[10][2];

            i=10;
            j=0;
            for(char ch:callNo.toCharArray()){
                if (j<0){
                    j=3;i++;
                }
                data[i][j]= (byte) ch;
                callNoBlockChecksum = callNoBlockChecksum ^ data[i][j];
                j--;
            }
            data[10][1] = (byte) callNoBlockChecksum;

        }

    }
}
