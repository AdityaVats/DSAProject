package Strings;

/**
 * Created by libsys on 11/2/2022.
 */
public class CountSubstringHavingAllThreeCharacters {
    /***Logic Dump
     * At each point i want to know the next a b and c (inlcuidn my index on whihc they may occur)
     * The furthest index of these three will be the endpoint where my smallest substring starting from my index will end
     * Since i need to count all substrings , if i keep adding any elements after the furthest index it will just be a newer subtring satisfying the condition
     * I just need to do this for every point
     * (Note: If i am unable to find any one a or b or c i do not have a substring from my index)
     *
     *
     * 1) O(n)   Space O(n)
     * iterate from end to start to keep track of next A B C
     * Maintain all three indices and get the furthest for each point and the total substrings starting from my index will be (n-max[index])
     *
     *
     * 2) O(n)  Space O(1)
     * No need to maintain every indice
     * you just need the three field nextIndex of A B C at each point
     *
     * **/
    public static int count(String s){
        int n = s.length();
        int prevIndexA = -1;
        int prevIndexB = -1;
        int prevIndexC = -1;
        int ans = 0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == 'a')
                prevIndexA = i;
            else if(s.charAt(i) == 'b')
                prevIndexB = i;
            else if(s.charAt(i) == 'c')
                prevIndexC = i;
            if(prevIndexA == -1 || prevIndexB == -1 || prevIndexC == -1)    continue;
            int max = Math.max(prevIndexA,Math.max(prevIndexB,prevIndexC));
            ans += n-max;
        }
        return ans;
    }
    public static int slidingWindowCount(String s){
        int n = s.length();
        int i = 0;
        int j = 0;

        int[] freq = new int[3];
        int ans = 0;
        while(j<n){
            freq[s.charAt(j)-'a']++;
            j++;
            while(i<j && valid(freq)){
                freq[s.charAt(i)-'a']--;
                i++;
            }
            /** when j changing only then consider i number of substrings for ans **/
            /** if i do this inner while loop also it will cause duplicae counting as j wont change but i will change hence common substring becinging from 0 will be counted again and again **/
            ans += i;

        }
        return ans;

    }
    public static boolean valid(int[] freq){
        return freq[0]>0 && freq[1]>0 && freq[2]>0;
    }
    public static void main(String[] args){
        System.out.println(slidingWindowCount("abcabc"));
        System.out.println(slidingWindowCount("aaacb"));
        System.out.println(slidingWindowCount("abc"));
        System.out.println(slidingWindowCount("aaaccbabb"));
    }
}
