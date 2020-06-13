package leetcode.linkedList;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode.com/problems/valid-parentheses/
 * {}[]()
 * 遍历这个字符串，如果是左括号，将其入栈，如果是右括号，则弹出栈顶元素与右括号做比较。
 *
 * 参考：https://www.runoob.com/java/java-character.html
 */
public class _20_validParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> matchingParentheses = new HashMap<>();
        matchingParentheses.put(')', '(');
        matchingParentheses.put('}', '{');
        matchingParentheses.put(']', '[');

        Stack<Character> container = new Stack<>();

        if (s.length() == 0) return true;

        if (s.length() % 2 != 0) return false;

        for (Character c : s.toCharArray()) {
            if (isOneOfOpeningParentheses(c)) container.push(c);

            if (isOneClosingParentheses(c)) {
                if (container.isEmpty()) return false;

                Character expectedOpeningParentheses = matchingParentheses.get(c);
                Character openingParentheses = container.pop();
                if (!expectedOpeningParentheses.equals(openingParentheses)) return false;
            }
        }
        return container.isEmpty();
    }

    private boolean isOneOfOpeningParentheses(Character c) {
        return c.equals('(') || c.equals('[') || c.equals('{');
    }

    private boolean isOneClosingParentheses(Character c) {
        return c.equals(')') || c.equals(']') || c.equals('}');
    }


    public static void main(String[] args) {
        _20_validParentheses instance = new _20_validParentheses();
        System.out.println(instance.isValid("(((((((()"));
    }
}
