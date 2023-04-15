package general;

/**
 * Created by libsys on 2/14/2023.
 */
public class BinarySum {
    public static String binarySum(String a,String b){
        if(Long.parseLong(b) ==0 )    return a;
        if(Long.parseLong(a) == 0)     return b;

        StringBuilder sum = new StringBuilder();
        StringBuilder carry = new StringBuilder();
        if(a.length() < b.length()){
            int extra = b.length()-a.length();
            for(int i=0;i<extra;i++)    a = '0' + a;
        } else {
            int extra = a.length()-b.length();
            for(int i=0;i<extra;i++)    b = '0' + b;
        }
        System.out.println(a+" "+ b);
        for (int i=0;i<a.length();i++){
            int  v1 = a.charAt(i)-'0';
            int  v2 = b.charAt(i)-'0';
            sum.append((char)((v1^v2)+'0'));
            carry.append((char)((v1&v2)+'0'));
        }
        carry.append('0');
        String result =  binarySum(sum.toString(),carry.toString());
        int extraZeroes = 0;
        for(int i=0;i<result.length() && result.charAt(i)=='0';i++) extraZeroes++;
        return result.substring(extraZeroes);
    }
    public static void main(String[] args){
        System.out.println(binarySum("1101","111"));
    }
}
