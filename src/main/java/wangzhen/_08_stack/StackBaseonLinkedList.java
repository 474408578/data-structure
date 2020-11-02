package wangzhen._08_stack;

public class StackBaseonLinkedList<T> {

    private Node<T> top = null;

    public void push(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public T pop() {
        if (top == null) return null;
        T temp = top.data;
        top = top.next;
        return temp;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.println(p.data + "  ");
            p = p.next;
        }
        System.out.println();
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        StackBaseonLinkedList<Integer> stack = new StackBaseonLinkedList<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        stack.printAll();
    }

}
