package types;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class AddExpr extends Expr {
    Factor expr;
    Factor term;
    public AddExpr(Factor expr, Factor term){
        this.expr = expr;
        this.term = term;
    }
}
