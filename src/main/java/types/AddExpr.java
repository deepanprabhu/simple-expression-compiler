package types;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class AddExpr extends Expr {
    public AddExpr(Factor expr, Factor term){
        this.expr = expr;
        this.term = term;
    }
}
