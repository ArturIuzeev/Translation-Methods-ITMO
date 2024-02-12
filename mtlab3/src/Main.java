import lab3.MyVisitor;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import lab3.lab3Parser;
import lab3.lab3Lexer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        try {
            var reader = new FileInputStream("/Users/arthuryuzeev/University/MTlabs/mtlab3/src/in.txt");
            StringBuilder text = new StringBuilder();
            var symbol = reader.read();
            while (symbol != -1) {
                text.append(Character.toString(symbol));
                symbol = reader.read();
            }
            var lexer = new lab3Lexer(new ANTLRInputStream(text.toString()));
            lab3Parser parser = new lab3Parser(new CommonTokenStream(lexer));
            var tree = parser.start();
            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
