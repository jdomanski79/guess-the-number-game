package pl.jdomanski;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    //== fields ==
    private final Random random = new Random();
    
    @Autowired
    @MaxNumber
    private int maxNumber;
    
    @Autowired
    @MinNumber
    private int minNumber;
    
    // == public methods ==
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    public int getMaxNumber() {
        return this.maxNumber;
    }
    
    public int getMinNumber() {
        return this.minNumber;
    }
}
