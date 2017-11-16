package types;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class MulTerm extends Term{

    public Factor term;
    public Factor factor;

    public MulTerm(Factor term, Factor factor){
        this.term = term;
        this.factor = factor;
    }
}
