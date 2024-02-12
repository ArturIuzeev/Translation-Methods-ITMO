// Generated from /Users/arthuryuzeev/University/MTlabs/mtlab3/src/lab3.g4 by ANTLR 4.13.1
package lab3;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class lab3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, PLUS=3, MINUS=4, MULT=5, DIV=6, INT=7, ID=8, WS=9, END=10, 
		ASSIGN=11;
	public static final int
		RULE_start = 0, RULE_expression = 1, RULE_e = 2, RULE_t = 3, RULE_f = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "expression", "e", "t", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'+'", "'-'", "'*'", "'/'", null, null, null, "';'", 
			"'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "PLUS", "MINUS", "MULT", "DIV", "INT", "ID", "WS", 
			"END", "ASSIGN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "lab3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public lab3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(10);
				expression();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lab3Parser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(lab3Parser.ASSIGN, 0); }
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode END() { return getToken(lab3Parser.END, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(ID);
			setState(17);
			match(ASSIGN);
			setState(18);
			e(0);
			setState(19);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EContext extends ParserRuleContext {
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(lab3Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(lab3Parser.MINUS, 0); }
		public EContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_e; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitE(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EContext e() throws RecognitionException {
		return e(0);
	}

	private EContext e(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EContext _localctx = new EContext(_ctx, _parentState);
		EContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_e, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(22);
				t();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(30);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_e);
					setState(25);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(26);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(27);
					t();
					}
					} 
				}
				setState(32);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TContext extends ParserRuleContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public TerminalNode MULT() { return getToken(lab3Parser.MULT, 0); }
		public TerminalNode DIV() { return getToken(lab3Parser.DIV, 0); }
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitT(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitT(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_t);
		int _la;
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				f();
				setState(35);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(36);
				t();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				f();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FContext extends ParserRuleContext {
		public EContext e() {
			return getRuleContext(EContext.class,0);
		}
		public TerminalNode INT() { return getToken(lab3Parser.INT, 0); }
		public TerminalNode ID() { return getToken(lab3Parser.ID, 0); }
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lab3Listener ) ((lab3Listener)listener).exitF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lab3Visitor ) return ((lab3Visitor<? extends T>)visitor).visitF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		FContext _localctx = new FContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_f);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(T__0);
				setState(43);
				e(0);
				setState(44);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				match(INT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return e_sempred((EContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean e_sempred(EContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u000b3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0003\u0002\u0018\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u001d\b\u0002\n\u0002\f\u0002 \t\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003(\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u00041\b\u0004\u0001\u0004\u0000\u0001\u0004\u0005\u0000"+
		"\u0002\u0004\u0006\b\u0000\u0002\u0001\u0000\u0003\u0004\u0001\u0000\u0005"+
		"\u00065\u0000\r\u0001\u0000\u0000\u0000\u0002\u0010\u0001\u0000\u0000"+
		"\u0000\u0004\u0017\u0001\u0000\u0000\u0000\u0006\'\u0001\u0000\u0000\u0000"+
		"\b0\u0001\u0000\u0000\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001"+
		"\u0000\u0000\u0000\f\u000f\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000"+
		"\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\u0001\u0001\u0000\u0000"+
		"\u0000\u000f\r\u0001\u0000\u0000\u0000\u0010\u0011\u0005\b\u0000\u0000"+
		"\u0011\u0012\u0005\u000b\u0000\u0000\u0012\u0013\u0003\u0004\u0002\u0000"+
		"\u0013\u0014\u0005\n\u0000\u0000\u0014\u0003\u0001\u0000\u0000\u0000\u0015"+
		"\u0018\u0006\u0002\uffff\uffff\u0000\u0016\u0018\u0003\u0006\u0003\u0000"+
		"\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0016\u0001\u0000\u0000\u0000"+
		"\u0018\u001e\u0001\u0000\u0000\u0000\u0019\u001a\n\u0002\u0000\u0000\u001a"+
		"\u001b\u0007\u0000\u0000\u0000\u001b\u001d\u0003\u0006\u0003\u0000\u001c"+
		"\u0019\u0001\u0000\u0000\u0000\u001d \u0001\u0000\u0000\u0000\u001e\u001c"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f\u0005"+
		"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000!(\u0001\u0000"+
		"\u0000\u0000\"#\u0003\b\u0004\u0000#$\u0007\u0001\u0000\u0000$%\u0003"+
		"\u0006\u0003\u0000%(\u0001\u0000\u0000\u0000&(\u0003\b\u0004\u0000\'!"+
		"\u0001\u0000\u0000\u0000\'\"\u0001\u0000\u0000\u0000\'&\u0001\u0000\u0000"+
		"\u0000(\u0007\u0001\u0000\u0000\u0000)1\u0001\u0000\u0000\u0000*+\u0005"+
		"\u0001\u0000\u0000+,\u0003\u0004\u0002\u0000,-\u0005\u0002\u0000\u0000"+
		"-1\u0001\u0000\u0000\u0000.1\u0005\u0007\u0000\u0000/1\u0005\b\u0000\u0000"+
		"0)\u0001\u0000\u0000\u00000*\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u00000/\u0001\u0000\u0000\u00001\t\u0001\u0000\u0000\u0000\u0005\r\u0017"+
		"\u001e\'0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}