package Calculator

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

object TestCalculator {
  def main(args: Array[String]): Unit = {
    val stmts =
      """
      192
      a = 1
      b = a * 3 + 1 / a
      b = b + b
      b
      """
    val input = CharStreams.fromString(stmts)
    val lexer = new CalculatorLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new CalculatorParser(tokens)
    val tree = parser.init
    println(tree.toStringTree)

    println("visiting in progress")
    tree.accept(new InterpretVisitor)
  }
}
