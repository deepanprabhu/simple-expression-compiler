package types;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class MulTerm extends Term{
    private String representation;
    public MulTerm(Factor term, Factor factor){
        this.term = term;
        this.factor = factor;
    }
    public void mintCode(){
        StringBuilder tSection = new StringBuilder();
        if(factor instanceof NumberFactor && term instanceof NumberFactor){
            tSection.append("mov rax,").append(((NumberFactor) factor).get()).append("\n");
            tSection.append("imul rax,").append(((NumberFactor) term).get()).append("\n");
            tSection.append("mov ").append(representation).append(",rax ").append("\n");
        }
        super.addTS(tSection.toString());
    }

    public void create(){
        StringBuilder snippet = new StringBuilder();
        snippet.append("number").append(ordinalValue).append(":");
        snippet.append(" resq 1 ").append("\n");
        super.addBS(snippet.toString());
        representation = "[number" + ordinalValue + "]";
    }
}
