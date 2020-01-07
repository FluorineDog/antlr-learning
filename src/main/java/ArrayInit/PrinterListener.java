package ArrayInit;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import ArrayInit.*;
public class PrinterListener extends ArrayInitBaseListener{
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInit(ArrayInitParser.InitContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInit(ArrayInitParser.InitContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterValue(ArrayInitParser.ValueContext ctx) {
		System.out.print(ctx.INT().getText()+ " ");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitValue(ArrayInitParser.ValueContext ctx) {

	}
}