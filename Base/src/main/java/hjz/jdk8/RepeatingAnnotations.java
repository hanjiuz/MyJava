package hjz.jdk8;
 
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
public class RepeatingAnnotations {
	
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }
     
    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };
     
    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {        
    }
     
    public static void main(String[] args) {
    	
    	Filters filters = Filterable.class.getAnnotation( Filters.class );
    	System.out.println( filters.value().length );
    	
    	Filter aFilter = Filterable.class.getAnnotation( Filter.class );
    	if (aFilter == null) {
    		System.out.println( "got no any Filter" );
    	} else {
    		System.out.println( aFilter.value() );
    	}
    	
    	
    	
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
    }
}