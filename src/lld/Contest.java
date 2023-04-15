package lld;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 3/17/2022.
 */
public class Contest {
    private int id;
    private String name;
    private User creator;
    private String level;
    private List<User> participantList;
    private boolean isLive;

    public Contest(String name,String level,String creatorName){

        User creator = MainDriver.userMap.get(creatorName);
        List<User> participantList = new ArrayList<>();
        participantList.add(this.creator);

        this.name = name;
        this.creator = creator;
        this.level = level;
        this.participantList = participantList;
        this.isLive = false;
        if(MainDriver.contestMap.isEmpty()){
            this.id = 1;
            MainDriver.contestMap.put(1,this);
        }else{
            this.id = MainDriver.contestMap.size()+1;
            MainDriver.contestMap.put(MainDriver.contestMap.size()+1,this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getLevel() {
        return level;
    }
    public void addParticipant(User user){
        this.participantList.add(user);
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setIsLive(boolean isLive) {
        this.isLive = isLive;
    }
}
