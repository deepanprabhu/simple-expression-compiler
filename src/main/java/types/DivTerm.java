package types;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class DivTerm extends Term {
    public DivTerm(Factor term, Factor factor){
        this.term = term;
        this.factor = factor;
    }
    public void mintCode(){
        StringBuilder tSection = new StringBuilder();
        tSection.append("mov rax,").append(factor.getRepresentation()).append("\n");
        tSection.append("mov rdx,0\n");
        tSection.append("idiv qword ").append(term.getRepresentation()).append("\n");
        tSection.append("mov ").append(this.getRepresentation()).append(",rax ").append("\n");
        super.addTS(tSection.toString());
    }

    public void create(){
        StringBuilder snippet = new StringBuilder();
        snippet.append("number").append(ordinalValue).append(":");
        snippet.append(" resq 1 ").append("\n");
        super.addBS(snippet.toString());
    }
}
