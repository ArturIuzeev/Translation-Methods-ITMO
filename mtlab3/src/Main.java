import lab3.MyVisitor;
import lab3.lab3Lexer;
import lab3.lab3Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;


public class Main {
    public static void main(String[] args) {

        try (var reader = new FileInputStream("/Users/arthuryuzeev/University/MTlabs/mtlab3/src/in.txt")) {

            var text = new StringBuilder();
            var symbol = reader.read();
            while (symbol != -1) {
                text.append(Character.toString(symbol));
                symbol = reader.read();
            }

            var lexer = new lab3Lexer(new ANTLRInputStream(text.toString()));
            var parser = new lab3Parser(new CommonTokenStream(lexer));

            var tree = parser.start();

            var visitor = new MyVisitor();
            visitor.visit(tree);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
