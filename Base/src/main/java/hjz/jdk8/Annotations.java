package hjz.jdk8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
 
public class Annotations {
	
	//which case is USE, which case is PARAMETER? seems all USE
	
    @Retention( RetentionPolicy.RUNTIME )
    @Target( { ElementType.TYPE_USE, ElementType.TYPE_PARAMETER } )
    public @interface NonEmpty {        
    }
         
    public static class Holder< @NonEmpty T > extends @NonEmpty Object {
        public void method(@NonEmpty String arg) throws @NonEmpty Exception {           
        }
    }
         
    @SuppressWarnings( "unused" )
    public static void main(String[] args) throws @NonEmpty Exception {
        final Holder< String > holder = new @NonEmpty Holder< String >();
        holder.method("Hello Annotations!");
        
        @NonEmpty Collection< @NonEmpty String > strings = new ArrayList<>();       
    }
}