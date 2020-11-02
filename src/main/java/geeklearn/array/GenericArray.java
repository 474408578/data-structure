package geeklearn.array;


/**
 * @author xschen
 */


public class GenericArray<T> {
    private T[] data;
    private int size;

    // 根据传入容量，构造Array
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    // 无参构造器
    public GenericArray() {
        this(10);
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取当前元素个数
    public int count() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    // 获取对应 index 位置的元素
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    // 是否包含e
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 寻找对应元素的下标，未找到，返回-1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 在index位置插入元素e, 时间复杂度o(n)
    public void add(int index, T e) {
        checkIndexForAdd(index);
        if (index == size) {
            resize(2 * data.length);
        }
        for (int i = index; i <= size; i++) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    public void addLast(T e) {
        add(size, e);
    }

    // 删除index位置的元素，并返回
    public T remove(int index) {
        checkIndex(index);
        T result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        size--;
        // 缩容
        if (size == data.length / 4 && data.length / 2 !=0) {
            resize(data.length / 2);
        }
        return result;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size-1);
    }

    // 从数组中删除指定的元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }

    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("check failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index <= size.");
        }
    }

    // 扩容方法，时间复杂度为O(n)
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("array size = %d, capacity = %d\n", size, data.length));
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {

        GenericArray<Integer> array = new GenericArray<>(5);
        array.add(0, 3);
        array.add(1, 4);
        array.add(2, 5);
        array.add(3, 9);
        array.add(4, 10);
        array.remove(3);
        System.out.println(array);
    }
}
