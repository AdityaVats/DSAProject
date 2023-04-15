package lld;

/**
 * Created by libsys on 3/17/2022.
 */
public class User {
    private String name;
    private int score;
    public User(String name){
        this.name = name;
        /**Default Value**/
        this.score = 1500;
        MainDriver.userMap.put(name,this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
