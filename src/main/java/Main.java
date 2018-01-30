import types.*;


public class Main {
    public static void main(String[] args) throws ParserException {
        Factor expr = new Token().parseExpr();
        postOrderTraversal(expr);
        System.out.println(expr.prologueSection);
        System.out.println(expr.dataSection);
        System.out.println(expr.bssSection);
        System.out.println(expr.textSection);

        expr.epilogueSection.append("mov rdi,format\nmov rsi,").append(expr.getRepresentation()).append("\n");
        expr.epilogueSection.append("mov rax,0\ncall _printf\nxor rdi,rdi\ncall _exit\nret\n");
        System.out.println(expr.epilogueSection);
    }

    public static void postOrderTraversal(Factor factor) {
        if (factor instanceof Expr) {
            postOrderTraversal(((Expr) factor).getExpr());
            postOrderTraversal(((Expr) factor).getTerm());
            if (factor instanceof AddExpr) {
                //System.out.println("+");
                ((AddExpr) factor).create();
                ((AddExpr) factor).mintCode();
            } else if (factor instanceof SubExpr) {
                //System.out.println("-");
                ((SubExpr) factor).create();
                ((SubExpr) factor).mintCode();
            }
        } else if (factor instanceof Term) {
            postOrderTraversal(((Term) factor).getTerm());
            postOrderTraversal(((Term) factor).getFactor());
            if (factor instanceof DivTerm) {
                //System.out.println("/");
                ((DivTerm) factor).create();
                ((DivTerm) factor).mintCode();
            } else if (factor instanceof MulTerm) {
                //System.out.println("*");
                ((MulTerm) factor).create();
                ((MulTerm) factor).mintCode();
            }
        } else if (factor instanceof NumberFactor) {
            //System.out.println(((NumberFactor) factor).getValue());
            ((NumberFactor) factor).create();
        }
    }

    public void printFactor(Factor node) {
        if (node instanceof NumberFactor) {
            System.out.println(((NumberFactor) node).getValue());
        } else if (node instanceof AddExpr) {
            AddExpr addExpr = (AddExpr) node;
            printFactor(addExpr.getExpr());
            printFactor(addExpr.getTerm());
        } else if (node instanceof SubExpr) {
            SubExpr subExpr = (SubExpr) node;
            printFactor(subExpr.getExpr());
            printFactor(subExpr.getTerm());
        } else if (node instanceof DivTerm) {
            DivTerm divTerm = (DivTerm) node;
            printFactor(divTerm.getFactor());
            printFactor(divTerm.getTerm());
        } else if (node instanceof MulTerm) {
            MulTerm mulTerm = (MulTerm) node;
            printFactor(mulTerm.getFactor());
            printFactor(mulTerm.getTerm());
        }
    }
}
