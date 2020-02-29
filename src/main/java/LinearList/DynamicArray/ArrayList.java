package LinearList.DynamicArray;

import LinearList.AbstractList;

/**
 * 动态数组的设计
 * 1、size
 * 2、elements
 *
 */
public class ArrayList<E> extends AbstractList<E> {
    // 所有的元素
    private E[] elements;

    private static final int DEFAULT_CAPATICY = 3;

    public ArrayList(){
        this(DEFAULT_CAPATICY);
        //elements = new int[DEFAULT_CAPATICY];
    }

    public ArrayList(int capaticy){
        capaticy = (capaticy > DEFAULT_CAPATICY)? capaticy: DEFAULT_CAPATICY;
        elements = (E[]) new Object[capaticy];

    }

    //是否包含某个元素
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    // 添加元素到最后面
    public void add(E element){
        add(size, element);
    }

    // 返回index位置对应的元素
    public E get(int index){
        rangeCheck(index);
        return elements[index];
    }

    // 设置index位置的元素
    public E set(int index, E element){
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    // 往index位置添加元素, 可以存储null
    public void add(int index, E element){
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
    public E remove(int index){
        rangeCheck(index);
        E old = elements[index];
        for (int i=index; i<size-1; i++){
            elements[i] = elements[i+1];
        }
        elements[--size] = null;
        return old;
    }

    // 查看元素的位置，对象类型不能直接使用等号，使用等号的话，是比较内存地址，而应该使用equals方法
    // 由于可以存储空数据，调用这个方法时，使用空对象去调用equals方法，会导致空指针异常。
    // 具体的比较细节可以在对象的equals()中指定。
    public int indexOf(E element){
        if (element == null){
            for (int i=0; i<size; i++){
                // 避免空指针调用equals方法异常
                if (elements[i] == null)
                    return i;
            }
        } else{
            for (int i=0; i<size; i++){
                // 防止空指针异常
                if (element.equals(elements[i])){
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    // 清除所有元素(将对象数组存储的地址的指向对象清空)
    public void clear(){
        // 泛型（对象数组引出了内存管理的细节）
        // 清空数组，重新申请内存空间会消耗性能
        for (int i=0; i<size; i++){
            elements[i] = null;
        }
        size = 0;
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
        E[] newElements = (E[]) new Object[newCapacity];
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