import types.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws ParserException {
        Factor expr = new Token().parseExpr();
    }
    public void postOrderTraversal(Factor factor){
        Stack<Factor> stack = new Stack<>();
        List<Factor> result = new ArrayList<>();

        stack.push(factor);
        while(!stack.empty()){
            Factor node = stack.pop();
            result.add(node);
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
