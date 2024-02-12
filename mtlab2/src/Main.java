import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Parser parser = new Parser();
        var in = new FileInputStream("in.txt");
        var out = new FileOutputStream("out.txt");

        try {
            out.write("digraph {\n".getBytes());
            var tree = parser.parse(in);

            dfs(tree.num, new ArrayList<>(Collections.nCopies(parser.count + 1, false)), tree, out);

            out.write("\n }".getBytes());
            out.close();
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(int i, ArrayList<Boolean> visited, Tree tree, FileOutputStream out) throws IOException {
        visited.set(i, true);
        out.write(("n" + i + " [label=\"" + tree.node + "\"];\n").getBytes());
        for (Tree child : tree.children) {
            if (!visited.get(child.num)) {
                out.write(("n" + i + " -> n" + (child.num) + ";\n").getBytes());
                dfs(child.num, visited, child, out);
            }
        }
    }
}
