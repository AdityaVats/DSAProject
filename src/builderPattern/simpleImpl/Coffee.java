package builderPattern.simpleImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libsys on 6/8/2022.
 */
public class Coffee {
    public enum AddOn {CREAM,ExtraShot,MOCHA};
    public enum Size {SMALL,MEDIUM,LARGE};
    public enum BaseType {DECAF,NONDECAF};
    final private Size size;
    final private BaseType baseType;
    final private List<AddOn> addOns;

    public static class Builder{
        private Size size;
        private BaseType baseType;
        private List<AddOn> addOns;
        public Builder(BaseType baseType,Size size){
            addOns = new ArrayList<>();
            this.size = size;
            this.baseType = baseType;

        }
        public Builder add(AddOn addOn){
            addOns.add(addOn);
            return this;
        }
        public Coffee build(){
            return new Coffee(this);
        }
    }
    private Coffee(Builder builder){
        this.addOns = builder.addOns;
        this.size = builder.size;
        this.baseType = builder.baseType;

    }
    public String toString(){
        return this.baseType+"\t"+this.size+"\t"+this.addOns;
    }
}
