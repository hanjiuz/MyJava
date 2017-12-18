package hjz.jdk8;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class DateTimeTest {

	public static void main(String[] args) {
		
		

		final Clock defaultClock = Clock.systemDefaultZone();
		System.out.println( defaultClock.toString() );
		System.out.println( defaultClock.getZone().getId() );
		System.out.println( defaultClock.instant() );
		System.out.println( defaultClock.millis() );
		
		
		System.out.println( TimeZone.getDefault().getDisplayName() );
		System.out.println( TimeZone.getDefault().getID() );
		
		
		// Get the system clock as UTC offset 
		final Clock utcClock = Clock.systemUTC();	
		System.out.println( utcClock.instant() );
		
		//milliseconds since 1970-01-01UTC00:00:00
		System.out.println( System.currentTimeMillis() );
		System.out.println( utcClock.millis() );
		
		
		
		// Get the local date and local time
		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now( defaultClock );
		         
		System.out.println( date );
		System.out.println( dateFromClock );
		         
		// Get the local date and local time
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now( defaultClock );
		         
		System.out.println( time );
		System.out.println( timeFromClock );
		
		
		// Get the zoned date/time
		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( defaultClock );
		final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
		         
		System.out.println( zonedDatetime );
		System.out.println( zonedDatetimeFromClock );
		System.out.println( zonedDatetimeFromZone );
		
		
		// Get duration between two dates
		final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
		final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
		 
		final Duration duration = Duration.between( from, to );
		System.out.println( "Duration in days: " + duration.toDays() );
		System.out.println( "Duration in hours: " + duration.toHours() );
		
	}

}
