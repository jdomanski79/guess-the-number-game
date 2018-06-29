package pl.jdomanski;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    //== fields ==
    private final Random random = new Random();
    
    private int maxNumber = 100;
    
    // == public methods ==
    public int next() {
        return random.nextInt(maxNumber);
    }

    public int getMaxNumber() {
        return this.maxNumber;
    }
}
