import types.*;

import java.util.LinkedList;
import java.util.Queue;

/*
    expr -> expr '+' term | expr '-' term | term
    term -> term '*' factor | term '/' factor | factor
    factor -> '(' expr ')' | identifier | number
*/

public class Token {
    Queue<Character> buffer = new LinkedList<>();
    private void getContents(){
        FileExpression f = new FileExpression("src/input.expr");
        for(char c : f.getContents().toCharArray()){
            buffer.add(new Character(c));
        }
    }
    public Token(){
        getContents();
    }
    public char peek(){
        if(buffer.peek() != null)
            return buffer.peek();
        return '\0';
    }
    public char next(){
        return buffer.poll();
    }
    public boolean isNext(char c){
        return peek() == c;
    }
    public void skipspace(){
        while(peek() == ' ')
            next();
    }
    public String parseNumber(){
        skipspace();
        StringBuilder sb = new StringBuilder();
        while(Character.isDigit(peek())){
            sb.append(next());
        }
        return sb.toString();
    }
    public Factor parseFactor() throws ParserException {
        skipspace();
        if(Character.isDigit(peek())){
            return new NumberFactor(parseNumber());
        }
        else if(isNext('(')) {
            next();
            skipspace();
            Factor expr = parseExpr();
            skipspace();
            isNext(')');
            next();
            return expr;
        }
        throw new ParserException("Error in parseFactor");
    }
    public Factor parseExpr() throws ParserException{
        Expr expr = null;
        Factor term = parseTerm();
        skipspace();

        if(isNext('+')){
            next();
            skipspace();
            expr = new AddExpr(parseExpr(), term);
        } else if(isNext('-')){
            next();
            skipspace();
            expr = new SubExpr(parseExpr(), term);
        }
        if(expr != null)
            return expr;

        return term;
    }
    public Factor parseTerm() throws ParserException {
        Term term = null;
        Factor factor = parseFactor();
        skipspace();

        if(isNext('/')){
            next();
            skipspace();
            term = new DivTerm(parseTerm(), factor);
        } else if(isNext('*')){
            next();
            skipspace();
            term = new MulTerm(parseTerm(), factor);
        }
        if(term != null)
            return term;

        return factor;
    }
}
