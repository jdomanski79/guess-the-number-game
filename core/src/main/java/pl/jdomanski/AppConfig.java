package pl.jdomanski;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="pl.jdomanski")
public class AppConfig {

//    @Bean
//    public MessageGenerator messageGenerator(Game game){
//        return new MessageGeneratorImpl(game);
//    }
    
    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl();
    }
}
