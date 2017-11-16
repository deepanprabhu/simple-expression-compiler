package types;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class SubExpr extends Expr {
    Factor expr;
    Factor term;
    public SubExpr(Factor expr, Factor term){
        this.expr = expr;
        this.term = term;
    }
}
