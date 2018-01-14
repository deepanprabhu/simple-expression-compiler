package types;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class ExprFactor extends Factor{
    @Getter
    @Setter
    Expr expr;
    public ExprFactor(Expr expr){
        this.expr = expr;
    }
}
