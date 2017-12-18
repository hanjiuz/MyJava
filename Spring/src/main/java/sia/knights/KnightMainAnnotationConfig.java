package sia.knights;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightMainAnnotationConfig {

  public static void main(String[] args) throws Exception {
    
    AnnotationConfigApplicationContext context = 
    	new AnnotationConfigApplicationContext(sia.knights.config.KnightConfig.class);
    
    //if bean is unique for given Class, can get it by Class. 
    Quest quest = context.getBean(Quest.class);
    quest.embark();
    
    Knight knight = context.getBean(Knight.class);
    knight.embarkOnQuest();
    
    context.close();
  }

}
