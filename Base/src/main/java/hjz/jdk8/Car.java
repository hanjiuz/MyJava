package hjz.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Car {
	
	public Car (){
		System.out.println( "New " + this.toString() );
	}
	
    public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }              
         
    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }
    
    public static void collideWithoutArg() {
        System.out.println( "Collided " + "no car" );
    }
         
    public void follow( final Car another ) {
        System.out.println(this.toString() + " following the " + another.toString() );
    }
         
    public void repair() {   
        System.out.println( "Repaired " + this.toString() );
    }
    
    public static void main(String[] args) {
    	//refer to constructor
    	final Car car = Car.create( Car::new );
    	
    	
    	final List< Car > cars = Arrays.asList( car );
    	
    	//refer to class (static) method with a parameter
    	cars.forEach( Car::collide );
    	
    	//this line will cause compile error
    	//cars.forEach( Car::collideWithoutArg );
    	
    	//refer to instance method without parameters
    	cars.forEach( Car::repair );
    	
    	final Car police = Car.create( Car::new );
    	//refer to instance method with a parameter
    	cars.forEach( police::follow );
    	
    }
}