import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class LexicalAnalyzer {
    private final InputStream stream;
    private int curSym;
    private int curPos;
    private Token curToken;
    public String num;

    public LexicalAnalyzer(InputStream stream) throws ParseException {
        this.stream = stream;
        curPos = 0;
        num = "";
        nextChar();
    }

    private boolean isBlank(int sym) {
        return Character.isWhitespace(sym);
    }

    private void nextChar() throws ParseException {
        ++curPos;
        try {
            curSym = stream.read();
        } catch (IOException e) {
            curToken = Token.NOTHING;
            try {
                stream.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    public void nextToken() throws ParseException {
        while (isBlank(curSym)) {
            nextChar();
        }

        switch (curSym) {
            case '(':
                curToken = Token.LBRACKET;
                nextChar();
                break;
            case ')':
                curToken = Token.RBRACKET;
                nextChar();
                break;
            case '&':
                curToken = Token.AND;
                nextChar();
                break;
            case '|':
                curToken = Token.OR;
                nextChar();
                break;
            case '!':
                curToken = Token.NOT;
                nextChar();
                break;
            case '^':
                curToken = Token.XOR;
                nextChar();
                break;
            case '=':
                nextChar();
                if (curSym != '=') {
                    throw new ParseException("Illegal character" + curSym + ". We excepted = for ==", curPos);
                }
                curToken = Token.EQUALS;
                 nextChar();
                 break;
            case -1:
                break;
            default:
                if (!Character.isLetter(curSym)) {
                    throw new ParseException("Illegal character" + curSym, curPos);
                }
                num = Character.toString(curSym);
                curToken = Token.NUM;
                nextChar();
        }
    }

    public int getCurPos() {
        return curPos;
    }

    public Token getCurToken() {
        return curToken;
    }
}
