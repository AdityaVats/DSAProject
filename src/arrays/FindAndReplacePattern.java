package arrays;

import java.util.*;

/**
 * Created by libsys on 7/29/2022.
 */
public class FindAndReplacePattern {


    public static List<String> findAndReplace(String[] words,String pattern){

        List<String> res = new ArrayList<>();
        pattern = normaliseString(pattern);
        for(String word:words){
            String tempWord = normaliseString(word);
            System.out.println(tempWord);
            if(tempWord.equals(pattern))    res.add(word);



        }
        //System.out.print(pattern);
        return  res;


    }

    public static String normaliseString(String s){

        Map<Character,List<Integer>>  map =new LinkedHashMap<>();

        // map created
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(c,indexList);
            }
        }

        int newC = 97;
        char[] charArr  = s.toCharArray();
        for(Character c:map.keySet()){
            for(Integer i:map.get(c)){
                charArr[i] =(char)newC;
            }
            newC++;
        }
        return new String(charArr);
    }

    public static void main(String[] args){
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String[] words2 = {"igousumygb","snfxmxyink","qwzbdbaowe","gmbdtdoimp","alpfwfcmlj"};
        System.out.println(findAndReplace(words,"xyy"));
        System.out.println(findAndReplace(words2, "rdzkpkbmda"));
    }
}
