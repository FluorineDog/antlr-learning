package ArrayInit;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TestArrayInit {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromString("{1, 2, 3, {4}, 5}");
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArrayInitParser parser = new ArrayInitParser(tokens);
        ParseTree tree = parser.init();
        System.out.println(tree.toStringTree(parser));

        System.out.println("here is the walker result");
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new PrinterListener(), tree);
    }
}
