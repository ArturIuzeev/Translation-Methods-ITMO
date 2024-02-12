import java.util.Arrays;
import java.util.List;

public class Tree {
    String node;
    List<Tree> children;
    Integer num;

    public Tree(Integer num, String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
        this.num = num;
    }

    public Tree(String node) {
        this.node = node;
    }
}
