package wangzhen._05array;

/**
 * 
 */
public class Array {
    private int data[];
    private int capacity;
    private int length;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
        this.length = 0;
    }

    public int find(int index) {
        if (index < 0 || index > length) return -1;
        return data[index];
    }

    public boolean insert(int index, int value) {
        // 数组无元素
        if (length == 0 && index == 0) {
            data[index] = value;
            length++;
            return true;
        }
        // 数组空间已满
        if (length == capacity) {
            System.out.println("没有可插入的位置");
            return false;
        }

        // 位置不合法
        if (index < 0 || index > length) {
            System.out.println("插入位置不合法");
            return false;
        }
        // 位置合法

    }

}
