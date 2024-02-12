// Generated from /Users/arthuryuzeev/University/MTlabs/mtlab3/src/lab3.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link lab3Parser}.
 */
public interface lab3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link lab3Parser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(lab3Parser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(lab3Parser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(lab3Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(lab3Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(lab3Parser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(lab3Parser.EContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#t}.
	 * @param ctx the parse tree
	 */
	void enterT(lab3Parser.TContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#t}.
	 * @param ctx the parse tree
	 */
	void exitT(lab3Parser.TContext ctx);
	/**
	 * Enter a parse tree produced by {@link lab3Parser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(lab3Parser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link lab3Parser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(lab3Parser.FContext ctx);
}