import types.*;


public class Main {
    public static void main(String[] args) throws ParserException {
        Factor expr = new Token().parseExpr();
        postOrderTraversal(expr);
    }

    public static void postOrderTraversal(Factor factor){
        if(factor instanceof Expr){
            postOrderTraversal(((Expr) factor).getExpr());
            postOrderTraversal(((Expr) factor).getTerm());
            if(factor instanceof AddExpr){
                System.out.println("+");
            }
            else if(factor instanceof SubExpr){
                System.out.println("-");
            }
        }
        else if(factor instanceof Term){
            postOrderTraversal(((Term) factor).getTerm());
            postOrderTraversal(((Term) factor).getFactor());
            if(factor instanceof DivTerm){
                System.out.println("/");
            }
            else if(factor instanceof MulTerm){
                System.out.println("*");
            }
        }
        else if(factor instanceof NumberFactor){
            System.out.println(((NumberFactor) factor).getValue());
        }
    }

    public void printFactor(Factor node){
        if(node instanceof NumberFactor) {
            System.out.println(((NumberFactor) node).getValue());
        }
        else if(node instanceof AddExpr){
            AddExpr addExpr = (AddExpr) node;
            printFactor(addExpr.getExpr());
            printFactor(addExpr.getTerm());
        }
        else if(node instanceof SubExpr){
            SubExpr subExpr = (SubExpr) node;
            printFactor(subExpr.getExpr());
            printFactor(subExpr.getTerm());
        }
        else if(node instanceof DivTerm){
            DivTerm divTerm = (DivTerm) node;
            printFactor(divTerm.getFactor());
            printFactor(divTerm.getTerm());
        }
        else if(node instanceof MulTerm){
            MulTerm mulTerm = (MulTerm) node;
            printFactor(mulTerm.getFactor());
            printFactor(mulTerm.getTerm());
        }
    }
}
