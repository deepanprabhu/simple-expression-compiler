package types;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class MulTerm extends Term{
    public MulTerm(Factor term, Factor factor){
        this.term = term;
        this.factor = factor;
    }
}
