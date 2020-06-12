package lovealgotithms.LinearList.LinkedList.singleLinkedlist;

import lovealgotithms.LinearList.AbstractList;

/**
 * 为了让代码更加精简，统一所有节点的处理逻辑，可以在最前面增加一个虚拟的头结点(不存储数据)
 * 可以了解一下
 * @param <E>
 */
public class SingleLinkedListAddVirtualHeadNode<E> extends AbstractList<E> {
    private Node<E> first;

    // 第一个节点first（虚拟节点）不存储数据
    public SingleLinkedListAddVirtualHeadNode() {
        this.first = new Node<>(null, null);
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
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

        Node<E> prev = (index == 0)? first : node(index-1);
        prev.next = new Node<>(element, prev.next);
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
        Node<E> prev = (index == 0) ? first : node(index - 1);
        Node<E> node = prev.next;
        prev.next = prev.next.next;
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null){
            for (int i=0; i<size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else{
            for (int i = 0; i < size; i++){
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 根据index返回node，由于使用了虚拟节点，first节点不存储数据，
     * 所以需要从first节点的下一个节点开始
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node = first.next;
        for (int i=0; i<index; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(", [");
        Node<E> node = first.next;
        for (int i=0; i<size; i++){
            if (i!=0){
                stringBuilder.append(",");
            }
            stringBuilder.append(node.element);
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
