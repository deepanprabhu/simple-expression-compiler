package types;

import lombok.Getter;
import lombok.Setter;

public class Term extends Factor {

    @Getter
    @Setter
    public Factor term;

    @Getter
    @Setter
    public Factor factor;
}
