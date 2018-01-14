package types;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class MulTerm extends Term{

    @Getter
    @Setter
    public Factor term;

    @Getter
    @Setter
    public Factor factor;

    public MulTerm(Factor term, Factor factor){
        this.term = term;
        this.factor = factor;
    }
}
