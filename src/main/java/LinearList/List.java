package LinearList;

public interface List<E> {

    /**
     * 接口中定义常变量可以省略 public static final
     * 且必须进行赋值
     */
    int ELEMENT_NOT_FOUND = -1;

    /**
     * 元素的数量
     * @return
     */
    int size();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含元素
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * 添加元素元素到尾部
     * @param element
     */
    void add(E element);

    /**
     * 在index位置添加元素
     * @param index
     * @param element
     */
    void add(int index, E element);

    /**
     * 清空所有元素
     */
    void clear();

    /**
     * 获取index位置的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置index位置的元素的值
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * 移除index位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 返回元素的位置
     * @param element
     * @return
     */
    int indexOf(E element);
}
