package lab3;

import java.util.HashMap;

public class MyVisitor extends lab3BaseVisitor<Integer> {
    private final HashMap<String, Integer> map;

    public MyVisitor() {
        map = new HashMap<>();
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
            return switch (ctx.getChild(1).getText()) {
                case "-" -> visit(ctx.e()) - visit(ctx.t());
                case "+" -> visit(ctx.e()) + visit(ctx.t());
                default -> throw new IllegalStateException("Unexpected value: " + ctx.getChild(1).getText());
            };
        }
        return visit(ctx.t());
    }

    @Override
    public Integer visitT(lab3Parser.TContext ctx) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.q()) * visit(ctx.t());
        }
        return visit(ctx.q());
    }

    @Override
    public Integer visitQ(lab3Parser.QContext ctx) {
        if (ctx.getChildCount() == 3) {
            return visit(ctx.f()) / visit(ctx.q());
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
