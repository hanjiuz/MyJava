package sia.knights;

import org.springframework.context.support.
                   ClassPathXmlApplicationContext;

public class KnightMain {

  public static void main(String[] args) throws Exception {
    ClassPathXmlApplicationContext context = 
        new ClassPathXmlApplicationContext(
            "META-INF/spring/knight.xml");
    
    //if bean is unique for given Class, can get it by Class. 
    Quest quest = context.getBean(Quest.class);
    quest.embark();
    
    //Knight knight = context.getBean(Knight.class);
    
    Knight knight = (Knight) context.getBean("knight");
    knight.embarkOnQuest();
    
    Knight drknight = (Knight) context.getBean("drknight");
    drknight.embarkOnQuest();
    
    context.close();
  }

}
