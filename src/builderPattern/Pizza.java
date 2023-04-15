package builderPattern;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by libsys on 6/8/2022.
 */
public abstract class Pizza {
    public enum Topping {ONION,TOMATO,CAPSICUM,MUSHROOM,CORN};
    final Set<Topping> toppings;
    // Recursive generic used to makes it simulated self type idiom
    abstract static class Builder<T extends  Builder<T>>{
        EnumSet<Topping> toppings;

        public T addTopping(Topping topping){
            toppings.add(topping);
            return self();
        }
        public abstract T self();
        public abstract Pizza build();
    }
    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }
}
