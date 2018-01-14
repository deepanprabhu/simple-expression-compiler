package types;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class DivTerm extends Term {
    @Getter
    @Setter
    Factor term;

    @Getter
    @Setter
    Factor factor;
    public DivTerm(Factor term, Factor factor){
        this.term = term;
        this.factor = factor;
    }
}