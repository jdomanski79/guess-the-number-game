 package pl.jdomanski.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.jdomanski.AppConfig;
import pl.jdomanski.Game;
import pl.jdomanski.GameImpl;
import pl.jdomanski.MessageGenerator;
import pl.jdomanski.MessageGeneratorImpl;
import pl.jdomanski.NumberGenerator;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
   // private static final String CONFIG_LOCATION = "beans.xml";
    
    public static void main(String[] args) {
        log.info("Guess The Number Game");
        
        // create context (container)
        //ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        
        //call method next
        int number = numberGenerator.next();
        
        //log the result
        log.info("number = {}", number);
        
        // get game bean from content
        
        //Game game = context.getBean(GameImpl.class);
        
        //game.reset();
        
        //get messagegenerator bean
        MessageGenerator messageGenerator = context.getBean(MessageGeneratorImpl.class);
        
        //call methods
        log.info(messageGenerator.getMainMessage());
        log.info(messageGenerator.getResultMessage());
        //close context
        context.close();

    }
    
}
