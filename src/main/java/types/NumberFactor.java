package types;

import lombok.Getter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class NumberFactor extends Factor {

    @Getter
    String value;

    public NumberFactor(String value) {
        this.value = value;

    }

    public void create() {
        StringBuilder snippet = new StringBuilder();
        snippet.append("number").append(ordinalValue).append(":");
        snippet.append(" dq ").append(Integer.parseInt(value)).append("\n");
        super.addDS(snippet.toString());
    }
}
