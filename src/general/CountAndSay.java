package general;

/**
 * Created by libsys on 10/18/2022.
 */
public class CountAndSay {
    public static String countAndSay(int n){
        if(n == 1)  return "1";
        String smallAns = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int count = 0;
        for(int j=0;j<smallAns.length();j++){
            if(smallAns.charAt(i) != smallAns.charAt(j)){
                sb.append(count);
                sb.append(smallAns.charAt(i));
                i=j;
                count = 0;
            }
            count++;
        }
        sb.append(count);
        sb.append(smallAns.charAt(i));
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(countAndSay(7));
    }

}
