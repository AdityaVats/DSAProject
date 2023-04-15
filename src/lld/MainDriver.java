package lld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by libsys on 3/17/2022.
 */
public class MainDriver {
    public static Map<Object,User>  userMap;

    public static Map<Integer,Question>  quesMap;

    public static Map<Integer,Contest>  contestMap;
    public  static String LOW = "LOW";
    public  static String MEDIUM = "MEDIUM";
    public static String HARD = "HARD";


    public static void main(String[] args){

    }
    public  static void attendContest(int contestId,String contestantName){
        Contest contest = MainDriver.contestMap.get(contestId);
        if(contest != null){
            User contestant = MainDriver.userMap.get(contestantName);

            if(contest!=null){
                System.out.print("USER ADDED TO CONTEST");
                contest.addParticipant(contestant);
                return;
            }
            System.out.print("USER "+contestantName+" DOES NOT EXIST");
            return;
        }
        System.out.print("CONTEST ID "+contestId+" DOES NOT EXIST");


    }
    public static List<Question> listQuestions(){
        List<Question>  list = new ArrayList<>();
        for(int key:MainDriver.quesMap.keySet())
            list.add(MainDriver.quesMap.get(key));
        return list;
    }
    public static List<Question> listQuestions(String level){
        List<Question> list = listQuestions();
        list =  list.stream().filter((o)->o.getLevel().equals(level)).collect(Collectors.toList());
        return list;
    }
    public static void runContest(int contestId,String creatorName){
        Contest contest = MainDriver.contestMap.get(contestId);
        if(contest != null){
           if(contest.getCreator().getName().equals(creatorName)){
               contest.setIsLive(true);
               System.out.print("CONTEST HAS BEEN STARTED");
               return;
           }else{
               System.out.print("PERMISSION DENIED!! YOU ARE NOT THE CREATOR");
               return;
           }


        }
        System.out.print("CONTEST ID "+contestId+" DOES NOT EXIST");


    }
}
