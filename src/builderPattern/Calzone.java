package builderPattern;

/**
 * Created by libsys on 6/8/2022.
 */
public class Calzone extends Pizza {
    final boolean hasSauce;
    static class Builder extends Pizza.Builder<Builder>{
        boolean hasSauce = false;
        public Builder hasSauce(boolean hasSauce){
            this.hasSauce = hasSauce;
            return this;
        }
        @Override
        public Calzone build(){
            return new Calzone(this);
        }
        @Override
        public Builder self(){
            return this;
        }
    }
     Calzone(Builder builder){
         super(builder);
         this.hasSauce = builder.hasSauce;
     }
}
