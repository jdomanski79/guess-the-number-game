package pl.jdomanski;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator{
    // == constants ==
    private final Game game;
    
    // == constructors ==
    @Autowired
    public MessageGeneratorImpl(Game game){
        this.game = game;
    }
    
    // == init ==
    @PostConstruct
    public void init(){
        log.info("MessageGeneratorImpl constructed. Game number is {}", game);

    // == public methods == 
       }

    public String getMainMessage() {
        return "Number is between " + 
                game.getSmallest() + 
                " and " +
                game.getBiggest() + 
                ". Can you guess it? You have "+
                game.getRemainingGuesses()+ " guesses left.";
    }


    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guessed it! The number was " + game.getNumber() + ". ";
        } else if(game.isGameLost()){
            return "You lost. The number was " + game.getNumber() + ".";
        } else if (!game.isValidNumberRange()){
            return "Invalid number range!";
        } else if(game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess?";
        } else {
            
            String direction = "Lower";
            
            if (game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses() + " guess left";
            
        }
    }
}
