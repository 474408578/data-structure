package LinearList.Stack;

public class Stack<E> {
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPATICY = 3;


    public Stack() {
        this(DEFAULT_CAPATICY);
        // elements = new int[DEFAULT_CAPATICY];
    }

    public Stack(int capacity) {
        capacity = (capacity > DEFAULT_CAPATICY) ? capacity : DEFAULT_CAPATICY;
        elements = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E element) {
        ensureCapacity(size);
        elements[size] = element;
        size++;
    }

    public E pop() {
        rangeCheck(size - 1);
        return elements[--size];
    }

    /**
     * 获取栈顶元素
     */
    public E top() {
        rangeCheck(size - 1);
        return elements[size - 1];
    }

    public void clear() {
        size = 0;
    }

    public int indexOf(E element) {
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if (i != 0 && i < size) { sb.append(", "); }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();

    }

    protected void rangeCheck(int size) {
        if (size < 0) {
            outOfBounds();
        }
    }

    protected void outOfBounds() {
        throw new IndexOutOfBoundsException("StackSize: " + size);
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("scale up to " + newCapacity);
    }
}
