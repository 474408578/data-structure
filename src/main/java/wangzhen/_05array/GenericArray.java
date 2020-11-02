package wangzhen._05array;


import java.util.Arrays;

/**
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    // 根据容量构造Array
    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    // 无参构造方法，默认数组容量为10
    public GenericArray() {
        this(10);
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取当前元素个数
    public int count() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 修改index位置的元素
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    // 获取index位置对应的元素
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取元素对应的下标，未找到，返回-1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    
    // 在index位置插入元素e
    public void add(int index, T e) {
        checkIndexForAdd(index);

        //
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = index; i < size; i++) {
            data[index + 1] = data[index];
        }
        data[index] = e;
        size++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void  addLast(T e) {
        add(size, e);
    }

    // 删除index位置的元素，并返回
    public T remove(int index) {
        checkIndex(index);

        T ret = get(index);
        for (int i = index; i < size - 1; i++) {
            data[index] = data[index + 1];
        }

        size--;
        data[size] = null;

        // 缩容
        if (size == data.length / 4 && data.length != 0) {
            resize(data.length /2);
        }

        return ret;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定的元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // 扩容方法，时间复杂度o(n)
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Require index >=0 and index <= size.");
        }
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Require index >=0 and index < size.");
        }
    }
}
