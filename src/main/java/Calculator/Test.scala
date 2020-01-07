package Calculator

;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

object Test {
  def main(args: Array[String]): Unit = {
    val stmts =
      """
      192
      a = 1
      a = a + 1
      b = b + b
      b
      """
    val input = CharStreams.fromString(stmts)
    val lexer = new CalculatorLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new CalculatorParser(tokens)
    val tree = parser.init()
    println(tree.toStringTree)
  }
}
