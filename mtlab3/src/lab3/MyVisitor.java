package lab3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class MyVisitor extends lab3BaseVisitor<Integer> {
    private final HashMap<String, Integer> map;

    public MyVisitor() {
        map = new HashMap<>();
    }

    @Override
    public Integer visitStart(lab3Parser.StartContext ctx) {
        return super.visitStart(ctx);
    }

    @Override
    public Integer visitExpression(lab3Parser.ExpressionContext ctx) {
        String key = ctx.getChild(0).getText();
        Integer value = visit(ctx.getChild(2));
        map.put(key, value);
        System.out.println(key + " = " + value + ";");
        return super.visitExpression(ctx);
    }

    @Override
    public Integer visitE(lab3Parser.EContext ctx) {
        if (ctx.getChildCount() == 3) {
            switch (ctx.getChild(1).getText()) {
                case "-":
                    return visit(ctx.e()) - visit(ctx.t());
                case "+":
                    return visit(ctx.e()) + visit(ctx.t());
            }
        }
        return visit(ctx.t());
    }

    @Override
    public Integer visitT(lab3Parser.TContext ctx) {
        if (ctx.getChildCount() == 3) {
            switch (ctx.getChild(1).getText()) {
                case "*":
                    return visit(ctx.f()) * visit(ctx.t());
                case "/":
                    return visit(ctx.f()) / visit(ctx.t());
            }
        }
        return visit(ctx.f());
    }


    @Override
    public Integer visitF(lab3Parser.FContext ctx) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.e());
        }
        if (Character.isDigit(ctx.getText().charAt(0))) {
            return Integer.parseInt(ctx.getText());
        }
        return map.get(ctx.getText());
    }
}
