package Assignment6;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {

    //using backtracking to solve this
    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        List<String> res = new ArrayList<>();
        bt(builder, res, 0, 0, n);
        return res;
    }

    public void bt(StringBuilder builder, List<String> res, int open, int close, int n) {

        if (builder.length() == 2 * n) {
            res.add(builder.toString());
            return;
        }
        if (open < n) {
            builder.append("(");
            bt(builder, res, open + 1, close, n);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (close < open) {
            builder.append(")");
            bt(builder, res, open, close + 1, n);
            builder.deleteCharAt(builder.length() - 1);
        }

    }
}
