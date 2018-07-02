package pl.jdomanski;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {
    
    //== fields ==
    @Value("${game.guessCount:10}")
    private int guessCount;
    
    @Value("${game.maxNumber:20}")
    private int maxNumber;
    
    @Value("${game.minNumber:0}")
    private int minNumber;
    
    //== bean methods ==
    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
    
    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
    
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }
}
