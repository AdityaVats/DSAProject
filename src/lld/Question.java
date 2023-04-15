package lld;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by libsys on 3/17/2022.
 */
public class Question {
    private int id;
    private String level;
    private int score;
    public Question(String level,int score){
        this.level = level;
        this.score = score;
        if(MainDriver.quesMap.isEmpty()){
            MainDriver.quesMap.put(1,this);
        }else{
            this.id = MainDriver.quesMap.size()+1;
            MainDriver.quesMap.put(MainDriver.quesMap.size()+1,this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
