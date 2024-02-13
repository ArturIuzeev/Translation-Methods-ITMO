import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class Parser {
    private LexicalAnalyzer analyzer;
    private Follow follow;
    Integer count = 0;

    public Tree parse(InputStream inputStream) throws ParseException, IOException {
        analyzer = new LexicalAnalyzer(inputStream);
        follow = new Follow(analyzer);
        analyzer.nextToken();
        return M();
    }

    private Tree M() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case  NUM, LBRACKET, NOT -> {
                var child = E();
                follow.CheckEAndEPrime();
                var child2 = new Tree(++count,
                        "MPrime",
                        new Tree(+count, "eps"));

                if (analyzer.getCurToken() == Token.NOTHING ||
                        analyzer.getCurToken() == Token.EQUALS) {
                    child2 = MPrime();
                }

                return new Tree(++count,
                        "M",
                        child,
                        child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree MPrime() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NOTHING -> {
                return new Tree(++count,
                        "EPrime",
                        new Tree(++count, "eps"));
            }
            case EQUALS -> {
                analyzer.nextToken();
                Tree child = E();

                follow.CheckEAndEPrime();

                var child2 = new Tree(++count,
                        "MPrime",
                        new Tree(++count, "eps"));

                if (analyzer.getCurToken() == Token.NOTHING ||
                        analyzer.getCurToken() == Token.EQUALS) {
                    child2 = MPrime();
                }

                return new Tree(++count,
                        "MPrime",
                        new Tree(++count, "=="),
                        child,
                        child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree E() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NUM, LBRACKET, NOT -> {
                var child = T();

                follow.CheckTAndTPrime();

                var child2 = new Tree(++count,
                        "EPrime",
                        new Tree(++count, "eps"));

                if (analyzer.getCurToken() == Token.NOTHING ||
                        analyzer.getCurToken() == Token.OR) {
                    child2 = EPrime();
                }

                follow.CheckTAndTPrime();

                return new Tree(++count,
                        "E",
                        child,
                        child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree EPrime() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NOTHING -> {
                return new Tree(++count,
                        "EPrime",
                        new Tree(++count, "eps"));
            }
            case OR -> {
                analyzer.nextToken();
                Tree child = T();

                follow.CheckTAndTPrime();

                var child2 = new Tree(++count,
                        "EPrime",
                        new Tree(++count, "eps"));

                if (analyzer.getCurToken() == Token.NOTHING ||
                        analyzer.getCurToken() == Token.OR) {
                    child2 = EPrime();
                }

                follow.CheckTAndTPrime();

                return new Tree(++count,
                        "EPrime",
                        new Tree(++count, "|"),
                        child,
                        child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree T() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NUM, LBRACKET, NOT -> {
                var child = F();

                follow.CheckFAndFPrime();

                var child2 = new Tree(++count,
                        "TPrime",
                        new Tree(++count, "eps"));

                if (analyzer.getCurToken() == Token.NOTHING ||
                        analyzer.getCurToken() == Token.XOR) {
                    child2 = TPrime();
                }

                follow.CheckTAndTPrime();

                return new Tree(++count,
                        "T",
                        child,
                        child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree TPrime() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NOTHING -> {
                return new Tree(++count,
                        "TPrime",
                        new Tree(++count, "eps"));
            }
            case XOR -> {
                analyzer.nextToken();
                var child = F();

                follow.CheckFAndFPrime();

                var child2 = new Tree(++count,
                        "TPrime",
                        new Tree(++count, "eps"));

                if (analyzer.getCurToken() == Token.NOTHING ||
                        analyzer.getCurToken() == Token.XOR) {
                    child2 = TPrime();
                }

                follow.CheckTAndTPrime();

                return new Tree(++count,
                        "TPrime",
                        new Tree(++count, "^"),
                        child,
                        child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree F() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NUM, LBRACKET, NOT -> {
                var child = L();

                follow.CheckL();

                var child2 = new Tree(++count,
                        "FPrime",
                        new Tree(++count, "eps"));

                if (analyzer.getCurToken() == Token.NOTHING ||
                        analyzer.getCurToken() == Token.AND) {
                    child2 = FPrime();
                }

                follow.CheckFAndFPrime();

                return new Tree(++count,
                        "F",
                        child,
                        child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree FPrime() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NOTHING -> {
                return new Tree(++count,
                        "FPrime",
                        new Tree(++count, "eps"));
            }
            case AND -> {
                analyzer.nextToken();
                var child = L();

                follow.CheckL();

                var child2 = new Tree(++count,
                        "FPrime",
                        new Tree(++count, "eps"));

                if (analyzer.getCurToken() == Token.NOTHING ||
                        analyzer.getCurToken() == Token.AND) {
                    child2 = FPrime();
                }

                follow.CheckFAndFPrime();
                return new Tree(++count,
                        "FPrime",
                        new Tree(++count, "&"),
                        child,
                        child2);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree L() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NOT -> {
                analyzer.nextToken();
                var child = L();
                follow.CheckL();
                return new Tree(++count,
                        "L",
                        new Tree(++count, "!"),
                        child);
            }

            case LBRACKET, NUM -> {
                var child = Q();
                follow.CheckL();
                return new Tree(++count, "L", child);
            }
            default -> throw new AssertionError();
        }
    }

    private Tree Q() throws ParseException, IOException {
        switch (analyzer.getCurToken()) {
            case NUM -> {
                analyzer.nextToken();
                return new Tree(++count,
                        "Q",
                        new Tree(++count, analyzer.num));
            }
            case LBRACKET -> {
                analyzer.nextToken();

                var child = M();

                follow.CheckTAndTPrime();
                analyzer.nextToken();

                return new Tree(++count, "Q",
                        new Tree(++count, "("),
                        child,
                        new Tree(++count, ")"));
            }
            default -> throw new AssertionError();
        }
    }
}
