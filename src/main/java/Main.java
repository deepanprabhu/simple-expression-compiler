import types.Factor;

public class Main {
    public static void main(String[] args) throws ParserException {
        Factor expr = new Token().parseExpr();
    }
}
