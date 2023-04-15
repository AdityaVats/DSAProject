package singletonPattern;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 6/8/2022.
 */
public class Singleton implements Cloneable,Serializable{

    private static Singleton singleton;
    private Singleton(){
        if(singleton != null) throw new AssertionError();
    }
    public static Singleton getInstance(){

            if(singleton == null){
                synchronized (singleton){
                    if(singleton == null){
                        singleton = new Singleton();
                    }
                }
        }
        return singleton;
    }

    protected  Object readResolve(){
        return getInstance();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{ throw new CloneNotSupportedException(); }

}
