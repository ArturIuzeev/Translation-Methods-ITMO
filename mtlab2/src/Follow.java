import java.text.ParseException;

public class Follow {
    private final LexicalAnalyzer analyzer;

    public Follow(LexicalAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    void CheckEAndEPrime() throws ParseException {
        if (analyzer.getCurToken() != Token.AND &&
                analyzer.getCurToken() != Token.XOR &&
                analyzer.getCurToken() != Token.OR &&
                analyzer.getCurToken() != Token.RBRACKET &&
                analyzer.getCurToken() != Token.EQUALS &&
                analyzer.getCurToken() != Token.NUM
        ) {
            throw new ParseException("Expected ==/&/^/|/)/! at position", analyzer.getCurPos());
        }
    }

    void CheckTAndTPrime() throws ParseException {
        if (analyzer.getCurToken() != Token.OR &&
                analyzer.getCurToken() != Token.RBRACKET &&
                analyzer.getCurToken() != Token.EQUALS &&
                analyzer.getCurToken() != Token.NUM) {
            throw new ParseException("Expected ==/|/) at position", analyzer.getCurPos());
        }
    }

    void CheckFAndFPrime() throws ParseException {
        if (analyzer.getCurToken() != Token.XOR &&
                analyzer.getCurToken() != Token.OR &&
                analyzer.getCurToken() != Token.RBRACKET &&
                analyzer.getCurToken() != Token.EQUALS &&
                analyzer.getCurToken() != Token.NUM) {
            throw new ParseException("Expected ==/^/|/) at position", analyzer.getCurPos());
        }
    }

    void CheckL() throws ParseException {
        if (analyzer.getCurToken() != Token.AND &&
                analyzer.getCurToken() != Token.XOR &&
                analyzer.getCurToken() != Token.OR &&
                analyzer.getCurToken() != Token.RBRACKET &&
                analyzer.getCurToken() != Token.EQUALS &&
                analyzer.getCurToken() != Token.NUM
        ) {
            throw new ParseException("Expected ==/&/^/|/) at position", analyzer.getCurPos());
        }
    }

}
