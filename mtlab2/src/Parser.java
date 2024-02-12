import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

public class Parser {
    LexicalAnalyzer analyzer;
    OutputStream outputStream;
    Integer count = 0;

    private Tree E() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NUM, LBRACKET, NOT -> {
                var child = T();
                var child2 = new Tree(++count, "EPrime", new Tree(++count, "eps"));

                if (analyzer.getCurToken() == Token.NOTHING || analyzer.getCurToken() == Token.OR) {
                    child2 = EPrime();
                }

                return new Tree(++count, "E", child, child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree EPrime() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NOTHING -> {
                return new Tree(++count, "EPrime", new Tree(++count, "eps"));
            }
            case OR -> {
                analyzer.nextToken();
                Tree child = T();

                var child2 = new Tree(++count, "EPrime", new Tree(++count, "eps"));
                if (analyzer.getCurToken() == Token.NOTHING || analyzer.getCurToken() == Token.OR) {
                    child2 = EPrime();
                }

                return new Tree(++count, "EPrime", new Tree(++count, "|"), child, child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree T() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NUM, LBRACKET, NOT -> {
                var child = F();

                var child2 = new Tree(++count, "TPrime", new Tree(++count, "eps"));
                if (analyzer.getCurToken() == Token.NOTHING || analyzer.getCurToken() == Token.XOR) {
                    child2 = TPrime();
                }


                return new Tree(++count, "T", child, child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree TPrime() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NOTHING -> {
                return new Tree(++count, "TPrime", new Tree(++count, "eps"));
            }
            case XOR -> {

                analyzer.nextToken();
                var child = F();
                var child2 = new Tree(++count, "TPrime", new Tree(++count, "eps"));
                if (analyzer.getCurToken() == Token.NOTHING || analyzer.getCurToken() == Token.XOR) {
                    child2 = TPrime();
                }

                return new Tree(++count, "TPrime", new Tree(++count, "^"), child, child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree F() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NUM, LBRACKET, NOT -> {
                var child = L();

                var child2 = new Tree(++count, "FPrime", new Tree(++count, "eps"));
                if (analyzer.getCurToken() == Token.NOTHING || analyzer.getCurToken() == Token.AND) {
                    child2 = FPrime();
                }

                return new Tree(++count, "F", child, child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree FPrime() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NOTHING -> {
                return new Tree(++count, "FPrime", new Tree(++count, "eps"));
            }
            case AND -> {

                analyzer.nextToken();
                var child = L();

                var child2 = new Tree(++count, "FPrime", new Tree(++count, "eps"));
                if (analyzer.getCurToken() == Token.NOTHING || analyzer.getCurToken() == Token.AND) {
                    child2 = FPrime();
                }
                if (analyzer.getCurToken() == Token.LBRACKET) {
                    throw new ParseException("Not Expected ( at position", analyzer.getCurPos());
                }


                return new Tree(++count, "FPrime", new Tree(++count, "&"), child, child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree L() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NOT -> {

                analyzer.nextToken();
                var child = L();
                return new Tree(++count, "L", new Tree(++count, "!"), child);
            }
            case LBRACKET, NUM -> {

                var child = Q();
                return new Tree(++count, "L", child);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree Q() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NUM -> {
                analyzer.nextToken();
                return new Tree(++count, "Q", new Tree(++count, analyzer.num));
            }
            case LBRACKET -> {
                analyzer.nextToken();
                var child = E();
                if (analyzer.getCurToken() != Token.RBRACKET) {
                    throw new ParseException("Expected ) at position", analyzer.getCurPos());
                }
                analyzer.nextToken();
                return new Tree(++count, "Q", new Tree(++count, "("), child, new Tree(++count, ")"));
            }
            default -> throw new AssertionError();
        }
    }

    public Tree parse(InputStream inputStream, OutputStream out) throws ParseException, IOException {
        analyzer = new LexicalAnalyzer(inputStream);
        analyzer.nextToken();
        outputStream = out;
        var r = E();
        return r;
    }
}
