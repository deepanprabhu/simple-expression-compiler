package types;

/**
 * Created by dpanprbu on 11/15/17.
 */
public class SubExpr extends Expr {
    public SubExpr(Factor expr, Factor term) {
        this.expr = expr;
        this.term = term;
    }

    public void mintCode() {
        StringBuilder tSection = new StringBuilder();
        tSection.append("mov rax,").append(term.getRepresentation()).append("\n");
        tSection.append("sub rax,").append(expr.getRepresentation()).append("\n");
        tSection.append("mov ").append(this.getRepresentation()).append(",rax ").append("\n");
        super.addTS(tSection.toString());
    }

    public void create() {
        StringBuilder snippet = new StringBuilder();
        snippet.append("number").append(ordinalValue).append(":");
        snippet.append(" resq 1 ").append("\n");
        super.addBS(snippet.toString());
    }
}
