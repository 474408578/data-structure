package wangzhen._08_stack;

public class StackBaseOnArray<T> {
    private T[] items; // 数组
    private int count; // 栈中的元素个数
    private int n; // 栈的大小

    public StackBaseOnArray(int n) {
        this.n = n;
        this.items = (T[]) new Object[n];
        this.count = 0;
    }

    public void push(T item) {
        if (count == n) {
            resize(2 * n);
        }
        items[count] = item;
        ++count;
    }

    public T pop() {
        if (count == 0) return null;
        T temp = items[count - 1];
        --count;
        return temp;
    }


    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }
}
