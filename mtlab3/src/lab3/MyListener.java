//package lab3;
//
//import org.antlr.v4.runtime.ParserRuleContext;
//
//import java.util.HashMap;
//
//public class MyListener extends lab3BaseListener {
//    private HashMap<String, Integer> hashMap;
//
//    public MyListener() {
//        hashMap = new HashMap<>();
//    }
//
//    @Override
//    public void enterExpression(lab3Parser.ExpressionContext ctx) {
//        String key = ctx.getChild(0).getText();
//        hashMap.put(key, -1);
//        System.out.println(key + " = ");
//        super.enterExpression(ctx);
//    }
//
//    @Override
//    public void exitExpression(lab3Parser.ExpressionContext ctx) {
//        System.out.println(";");
//        super.exitExpression(ctx);
//    }
//
//    @Override
//    public void exitE(lab3Parser.EContext ctx) {
//        if (ctx.getChildCount() == 3) {
//        }
//        super.exitE(ctx);
//    }
//
//    @Override
//    public void exitT(lab3Parser.TContext ctx) {
//        super.exitT(ctx);
//    }
//
//    @Override
//    public void exitEveryRule(ParserRuleContext ctx) {
//        super.exitEveryRule(ctx);
//    }
//
//    @Override
//    public void exitF(lab3Parser.FContext ctx) {
//        switch (ctx.getChildCount()) {
//            case 1:
//                if (ctx.children.indexOf(0) == lab3Parser.INT) {
//
//                } else {
//
//                }
//
//                break;
//            default:
//
//                break;
//        }
//        super.exitF(ctx);
//    }
//}
