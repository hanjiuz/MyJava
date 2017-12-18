package hjz.jdk8;

public class DefaultableTest {

	public static void main(String[] args) {
		Defaultable defaulable = DefaultableFactory.create( DefaultableImpl::new );
	    System.out.println( defaulable.notRequired() );
	         
	    defaulable = DefaultableFactory.create( OverridableImpl::new );
	    System.out.println( defaulable.notRequired() );
	}

}
