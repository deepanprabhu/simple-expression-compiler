package types;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class ExprFactor extends Factor{
    Expr expr;
    public ExprFactor(Expr expr){
        this.expr = expr;
    }
}
