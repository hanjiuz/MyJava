package sia.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MinstrelMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
		        new ClassPathXmlApplicationContext(
		            "META-INF/spring/minstrel.xml");
		
	    Knight knight = context.getBean(Knight.class);
	    knight.embarkOnQuest();
	    context.close();
	}

}
