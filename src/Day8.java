import java.util.*;

/**
 * Created by libsys on 3/1/2022.
 */
public class Day8 {
    public static Comparator<Character> compare(String order){
        Map<Character,Integer> map = new HashMap<>();
        int i=0;
        for(char c: order.toCharArray()){
            map.put(c,i++);
        }
        return  (char1,char2) ->map.get(char1)-map.get(char2);

    }
    public static boolean allienDic(String[] words,String order){
        Comparator<Character>  comp = compare(order);
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int j=0;
            for (;j<word1.length()&&j<word2.length();j++){

                int v = comp.compare(word1.charAt(j),word2.charAt(j));
                System.out.print(v+" "+word1.charAt(j)+" "+word2.charAt(j));
                if(v == 0){
                    continue;
                }
                if(v<0)
                    break;
                if(v>0)
                    return false;

            }
            if(j==word2.length())
                return false;
        }
        return true;
    }
    public static String mostCommonWord(String paragraph,String[] banned){

        int prev= 0 ;
        String ans="";int ansMax = 0,count=0;
        for(int i=0;i<paragraph.length();i++){
            if(i==paragraph.length()-1) {
                String word = paragraph.substring(prev);
                for(String ban:banned) {
                    if (word.equals(banned)) {
                        continue;
                    }
                    count++;
                    if (ansMax < count) {
                        ans = word;
                        ansMax = count;
                    }
                    break;
                }

            }if(paragraph.charAt(i)== ' '){

                    String word = paragraph.substring(prev,i);
                    prev=i+1;
                    for(String ban:banned) {
                        if(word.equals(banned)){
                            continue;
                    }
                    count++;
                    if(ansMax<count){
                        ans = word;
                        ansMax = count;
                    }

                }
            }
        }
        return ans;
    }
}
