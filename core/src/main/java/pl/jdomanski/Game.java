package pl.jdomanski;

public interface Game {
    
    int getNumber();
    
    int getGuess();
    
    void seGuess(int guess);
    
    int getSmallest();
    
    int getBiggest();
    
    int getRemainingGuesses();
    
    void reset();
    
    void check();
    
    boolean isValidNumberRange();
    
    boolean isGameWon();
    
    boolean isGameLost();
}