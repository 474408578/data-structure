package lovealgotithms.LinearList.LinkedList.singleLinkedlist;

import lovealgotithms.LinearList.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    // 不需要构造函数，因为一开始可能一个节点都没有

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (next != null) {
                stringBuilder.append(element).append(" -> ");
            } else {
                stringBuilder.append(element);
            }
            return stringBuilder.toString();
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("Node - finalize");
        }
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        // 边界条件, index=0时，后续使用虚拟头结点可不用判断等于0的情况
        if (index==0){
           first = new Node<>(element, first);
        } else{
            Node<E> prev = node(index-1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    @Override
    public void clear() {
        size = 0;
        this.first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old =  node.element;
        node.element = element;
        return old;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = first;
        //无虚拟头结点，当index=0时，需要将first引用到下一个节点
        if (index==0){
            first = node.next;
        } else{
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null){
            for (int i = 0; i < size; i++){
                if (node.element == null){ return i; }
                node = node.next;
            }
        } else{
            for (int i = 0; i < size; i++){
                if (element.equals(node.element)){ return i; }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 根据index返回node，从first node开始
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node = first;
        for (int i=0; i<index; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i=0; i<size; i++){

            stringBuilder.append(node);
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
