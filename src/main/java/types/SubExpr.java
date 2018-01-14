package types;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class SubExpr extends Expr {
    public SubExpr(Factor expr, Factor term){
        this.expr = expr;
        this.term = term;
    }
}
