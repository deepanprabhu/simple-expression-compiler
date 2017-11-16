package types;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class DivTerm extends Term {
    Factor term;
    Factor factor;
    public DivTerm(Factor term, Factor factor){
        this.term = term;
        this.factor = factor;
    }
}
