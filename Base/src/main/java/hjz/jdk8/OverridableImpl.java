package hjz.jdk8;

public class OverridableImpl implements Defaultable {
	@Override
    public String notRequired() {
        return "Overridden implementation";
    }

}
