package pl.jdomanski;

import java.util.Random;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberGeneratorImpl implements NumberGenerator{

    //== fields ==
    private final Random random = new Random();
    
    @Getter
    private final int maxNumber;
    
    @Getter
    private final int minNumber;
    
    // == constructor ==
    @Autowired
    public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber){
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }
    
    // == public methods ==
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

}
