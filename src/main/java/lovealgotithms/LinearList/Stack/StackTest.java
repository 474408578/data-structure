package lovealgotithms.LinearList.Stack;

import java.util.Random;

public class StackTest {
    public static void main(String[] args) {
        Random random = new Random();
        StackCombineArrayList<Integer> stack = new StackCombineArrayList<>();
//        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(random.nextInt());
        }
        System.out.println(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
