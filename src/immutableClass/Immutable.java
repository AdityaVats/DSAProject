package immutableClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 2/9/2023.
 */
/** make final so that no can change implementation of methods  **/
public final class Immutable{
    /** optional to makefields final        **/
    List<Integer> list;
    String name;

    public Immutable(String name ,List<Integer> list){
        this.list = new ArrayList<>(list);
        this.name = name;
    }


    /**
       no setter methods
       only getters

       never return reference
       but a deep copy
     **/
    public List<Integer> getList() {
        return new ArrayList<>(list);
    }

    public String getName() {
        return name;
    }
    /** highly discouraged and not needed
        if mutating function is needed they would return a new instanc
     **/
    public Immutable update(int index,int newValue){
        List<Integer> newList = new ArrayList<>(list);
        newList.set(index,newValue);
        return new Immutable(this.name,newList);
    }
}