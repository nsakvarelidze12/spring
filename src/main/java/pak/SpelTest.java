package pak;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import pak.config.ConfigSpel;
import pak.spel.SpelBean;

public class SpelTest {

    public static void main(String[] args) {

        ExpressionParser expressionParser = new SpelExpressionParser();

        // 1. Literal expression
        Expression expression = expressionParser.parseExpression("'Hello SpEL'");
        String strVal = expression.getValue(String.class);
        System.out.println("1. " + strVal);

        // 2. Method invocation
        expression = expressionParser.parseExpression("new String('Hello SpEL').toUpperCase().concat('!')");
        strVal = expression.getValue(String.class);
        System.out.println("2. " + strVal);

        // 3. Mathematical operator
        expression = expressionParser.parseExpression("16 * 5");
        Integer intVal = expression.getValue(Integer.class);
        System.out.println("3. " + intVal);

        // 4. Relational operator
        expression = expressionParser.parseExpression("5 < 9");
        boolean boolVal = expression.getValue(Boolean.class);
        System.out.println("4. " + boolVal);

        // 5. Logical operator
        expression = expressionParser.parseExpression("400 > 200 && 200 < 500");
        boolVal = expression.getValue(Boolean.class);
        System.out.println("5. " + boolVal);

        // 6. Ternary operator
        expression = expressionParser.parseExpression("'some value' != null ? 'some value' : 'default'");
        strVal = expression.getValue(String.class);
        System.out.println("6. " + strVal);

        // 7. Elvis operator
        expression = expressionParser.parseExpression("'some value' ?: 'default'");
        strVal = expression.getValue(String.class);
        System.out.println("7. " + strVal);

        // 8. Regex/matches operator
        expression = expressionParser.parseExpression("'UPPERCASE STRING' matches '[A-Z\\s]+'");
        boolVal = expression.getValue(Boolean.class);
        System.out.println("8. " + boolVal);

        //

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigSpel.class);
        SpelBean spelBean = ctx.getBean(SpelBean.class);
        StandardEvaluationContext testContext = new StandardEvaluationContext(spelBean);

        // 9. Property value
        expression = expressionParser.parseExpression("property");
        expression.setValue(testContext, "new value");
        strVal = expression.getValue(testContext, String.class);
        System.out.println("9. " + strVal);

        // 10. Compare property
        expression = expressionParser.parseExpression("property == 'new value'");
        boolVal = expression.getValue(testContext, Boolean.class);
        System.out.println("10. " + boolVal);

    }

}
