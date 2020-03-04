package LinearList;

/**
 * 此类用作抽取公共代码，不给外界使用
 */

public abstract class AbstractList<E> implements List<E> {
    protected int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public void add(E element){
        add(size, element);
    }

    protected void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }

    protected void outOfBounds(int index){
        throw new IndexOutOfBoundsException("index: " + index + ", Size: " + size);
    }
}
