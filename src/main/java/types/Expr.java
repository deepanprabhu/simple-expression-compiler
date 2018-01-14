package types;

import lombok.Getter;
import lombok.Setter;

public class Expr extends Term {
    @Getter
    @Setter
    Factor expr;

    @Getter
    @Setter
    Factor term;
}
