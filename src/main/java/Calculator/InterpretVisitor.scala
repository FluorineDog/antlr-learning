package Calculator

import scala.collection.mutable
import scala.collection.mutable.HashMap

class InterpretVisitor extends CalculatorBaseVisitor[Double] {

  private val records = new mutable.HashMap[String, Double]

  override def visitAddSub(ctx: CalculatorParser.AddSubContext): Double = {
    val left = visit(ctx.left)
    val right = visit(ctx.right)
    ctx.op.getText match {
      case "+" => left + right
      case "-" => left - right
    }
  }

  override def visitAssign(ctx: CalculatorParser.AssignContext): Double = {
    val res = visit(ctx.expr)
    val id: String = ctx.ID.getText
    records.put(id, res)
    println(s"assign ${res} to ${id}")
    res
  }

  override def visitBlank(ctx: CalculatorParser.BlankContext): Double = {
    println("skip")
    Double.NaN
  }

  override def visitId(ctx: CalculatorParser.IdContext): Double = {
    records(ctx.ID.getText)
  }

  override def visitInit(ctx: CalculatorParser.InitContext): Double = {
    records.clear()
    visitChildren(ctx)
  }

  override def visitMulDiv(ctx: CalculatorParser.MulDivContext): Double = {
    val left = visit(ctx.left)
    val right = visit(ctx.right)
    ctx.op.getText match {
      case "*" => left * right
      case "/" => left / right
    }
  }

  override def visitNum(ctx: CalculatorParser.NumContext): Double = {
    ctx.NUM.getText.toDouble
  }

  override def visitParen(ctx: CalculatorParser.ParenContext): Double = {
    visit(ctx.expr)
  }

  override def visitShow(ctx: CalculatorParser.ShowContext): Double = {
    val res = visit(ctx.expr)
    println(s"showing ${res}")
    res
  }
}

