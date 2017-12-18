package hjz.jdk8;

import java.util.function.Supplier;

public interface DefaultableFactory {
	
	// Interfaces now allow static methods
    static Defaultable create(Supplier<Defaultable> supplier) {
        return supplier.get();
    }
    
}
