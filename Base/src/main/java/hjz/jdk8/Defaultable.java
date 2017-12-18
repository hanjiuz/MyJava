package hjz.jdk8;

public interface Defaultable {
	// Interfaces now allow default methods, the implementer may or 
    // may not implement (override) them.
    default String notRequired() { 
        return "Default implementation"; 
    } 

}
