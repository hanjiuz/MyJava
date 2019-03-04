package hjz.jdk8;

import java.util.function.Supplier;

public interface DefaultableFactory {
	
	// Interfaces now allow static methods
    static Defaultable create(Supplier<Defaultable> supplier) {
    	//Supplier is an functional interface, so supplier is presenting a method
    	//supplier.get() will execute that method and return result.
        return supplier.get();
    }
    
}
