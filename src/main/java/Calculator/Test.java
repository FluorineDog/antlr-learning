package Calculator;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Test {
    CharStream input = CharStreams.fromString("{1, 2, 3, {4}, 5}");
    CalculatorLexer lexer = new CalculatorLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CalculatorParser parser = new CalculatorParser(tokens);
    ParseTree tree = parser.stmt();

}
