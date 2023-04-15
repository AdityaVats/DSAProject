package builderPattern;

/**
 * Created by libsys on 6/8/2022.
 */
public class MainDriver {
    public static void main(String[] args){
        NYPizza nyPizza = new NYPizza.Builder(NYPizza.Size.LARGE).addTopping(Pizza.Topping.ONION).build();
        Calzone calzone = new Calzone.Builder().hasSauce(true).addTopping(Pizza.Topping.CORN).addTopping(Pizza.Topping.ONION).build();
    }
}
