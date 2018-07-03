package pl.jdomanski;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GameImpl implements Game{
    
    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);
  
    private final NumberGenerator numberGenerator;
    private final int guessCount;
    
    // == fields ==
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;
    
    // == constructors ==
    
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount){
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }
    
    // == public methods ==
    @PostConstruct
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);
    }
    
    public int getNumber() {
        return number;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;        
    }

    public int getSmallest() {
        return smallest;
    }

    public int getBiggest() {
        return biggest;
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }
    
    public int getGuessCount(){
        return guessCount;
    }

    public void check() {
        
        checkValidNumberRange();
        
        if (validNumberRange) {
            if (guess > number){
                biggest = guess - 1;
            }
            
            if (guess < number) {
                smallest = guess + 1;
            }
        }
        
        remainingGuesses--;
        
    }

    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    public boolean isGameWon() {
        return guess == number;
    }

    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }
    
    // == private methods ==
    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
