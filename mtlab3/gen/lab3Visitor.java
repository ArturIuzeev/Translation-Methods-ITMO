// Generated from /Users/arthuryuzeev/University/MTlabs/mtlab3/src/lab3.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link lab3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface lab3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link lab3Parser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(lab3Parser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(lab3Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(lab3Parser.EContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(lab3Parser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#q}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQ(lab3Parser.QContext ctx);
	/**
	 * Visit a parse tree produced by {@link lab3Parser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(lab3Parser.FContext ctx);
}