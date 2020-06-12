package lovealgotithms.LinearList.LinkedList.doubleLinkedList;

import lovealgotithms.LinearList.AbstractList;

public class DoubleCircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (prev != null) {
                stringBuilder.append(prev.element);
            } else{
                stringBuilder.append("null");
            }
            stringBuilder.append("_").append(element).append("_");
            if (next != null) {
                stringBuilder.append(next.element);
            } else {
                stringBuilder.append("null");
            }
            return stringBuilder.toString();
        }
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        if (size == 1) {
            first = null;
            last = null;
        } else {
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;
            if (node == first) { // index=0
                first = next;
            }
            if (node == last) { // index=size-1
                last = prev;
            }
        }

        size--;
        return node.element;
    }

    @Override
    public E get(int index) { return node(index).element; }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == element) { return i; }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)){ return i; }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    /**
     * 链表之间存在循环引用的问题，JVM通过gc roots标记来自动回收
     * gc root对象
     * 1、被栈指针指向的对象
     * 2、被类的静态变量引用的对象
     */
    @Override
    public void clear() {
        size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if (index == size) {// 往最后添加元素
            Node<E> oldLast = last;
            last = new Node<>(element, first, oldLast);
            // index == size = 0时， oldLast为空，这是链表添加的第一个元素,first和last都指向这个元素。
            if (oldLast == null){
                first = last;
                first.next = first;
                first.prev = first;
            } else{
                oldLast.next = last;
                first.prev = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> newNode = new Node<>(element, next, prev);
            next.prev = newNode;
            prev.next = newNode;
            // index等于0
            if (next == first) {
                first = newNode;
            }
        }

        size++;
    }

    /**
     * 获取index位置对应的元素
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        if (index <= (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i=0; i<size; i++){
            if (i!=0){
                stringBuilder.append(", ");
            }
            stringBuilder.append(node);
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
