package dynamicArray;

import java.util.Arrays;

/**
 * 动态数组的设计
 * 1、size
 * 2、elements
 *
 */
public class ArrayList {
    // 元素的数量, int类型自动初始化为0， 对象类型自动初始化为null
    private int size;

    // 所有的元素
    private int[] elements;

    private static final int DEFAULT_CAPATICY = 3;

    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(){
        this(DEFAULT_CAPATICY);
        //elements = new int[DEFAULT_CAPATICY];
    }

    public ArrayList(int capaticy){
        capaticy = (capaticy > DEFAULT_CAPATICY)? capaticy: DEFAULT_CAPATICY;
        elements = new int[capaticy];

    }

    // 返回元素的数量
    public int size(){
        return size;
    }

    // 是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //是否包含某个元素
    public boolean contains(int element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    // 添加元素到最后面
    public void add(int element){
        add(size, element);
    }

    // 返回index位置对应的元素
    public int get(int index){
        rangeCheck(index);
        return elements[index];
    }

    // 设置index位置的元素
    public int set(int index, int element){
        rangeCheck(index);
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    // 往index位置添加元素
    public void add(int index, int element){
        // 越界检测
        rangeCheckForAdd(index);
        // 动态扩容
        ensureCapacity(size + 1);
        for(int i=size; i>index; i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    // 删除index位置对应的元素
    public int remove(int index){
        rangeCheck(index);
        int old = elements[index];
        for (int i=index; i<size-1; i++){
            elements[i] = elements[++i];
        }
        size--;
        return old;
    }

    // 查看元素的位置
    public int indexOf(int element){
        for (int i=0; i<size; i++){
            if (elements[i] == element){
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // 清除所有元素
    public void clear(){
        // 清空数组，重新申请内存空间会消耗性能
        size = 0;
    }

    private void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBounds(index);
        }
    }

    private void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }

    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("index: " + index + ", Size: " + size);
    }

    /**
     * 保证有capacity的容量
     * @param capacity
     */
    private void ensureCapacity(int capacity){
        // 当前的容量
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        // 新容量为旧容量的1.5倍，使用右移运算
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        int[] newElements = new int[newCapacity];
        for (int i=0; i<size; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    @Override
    public String toString() {
        // 拼接字符串建议使用StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size);
        stringBuilder.append(", [");
        for (int i=0; i<size; i++){
            if (i !=0 ){
                stringBuilder.append(", ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}