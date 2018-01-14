package types;

import lombok.Getter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class NumberFactor extends Factor {
    @Getter
    String value;
    public NumberFactor(String value){
        this.value = value;
    }
}
