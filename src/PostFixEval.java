import java.util.Stack;

/**
 * class specifically for evaluating how to calculate post fix eval
 * string expressions
 */
public class PostFixEval {

    /**
     * This method uses the stack method with floats, so I can get all roots.
     * @param expression String expression entered by the user must contain digits, spaces, or
     * addition, subtraction, division, and multiplication
     * @return result value from the user String expression
     */
    public static Float getPostFixEval(String expression){
        Stack<Float> stack = new Stack<>();

        for(int i = 0; i < expression.length(); i++)
        {
            char c = expression.charAt(i);
            if(Character.isDigit(c))
            {
                float num = 0;
                while(Character.isDigit(c))
                {
                    num = num * 10 + (c - '0');
                    i++;
                    c = expression.charAt(i);
                }
                i--;
                stack.push(num);
            }else if(c == ' ') {
                //do not want it to do anything
            } else {
                float value1 = stack.pop();
                float value2 = stack.pop();
                switch (c) {
                    case '+' -> stack.push(value2 + value1);
                    case '-' -> stack.push(value2 - value1);
                    case '/' -> stack.push(value2 / value1);
                    case '*' -> stack.push(value2 * value1);
                }
            }
        }
        return stack.pop();
    }
}
