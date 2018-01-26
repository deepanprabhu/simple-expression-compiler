package types;

import lombok.Getter;
import lombok.Setter;

public class Term extends Factor {
    static int ordinal = 0;

    @Getter
    @Setter
    public Factor term;

    @Getter
    @Setter
    public Factor factor;
}
