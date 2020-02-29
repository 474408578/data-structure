package LinearList.LinkedList;

import LinearList.AbstractList;

public class LinkedList<E> extends AbstractList<E> {
    private Node<E> first;

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
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void add(int index, E element) {
        System.out.println("开始检查");
        rangeCheckForAdd(index);
        if (index==0){
           first = new Node<>(element, first);
        } else{
            Node<E> prev = node(index-1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
        System.out.println(element);
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
        Node<E> node = node(index);
        if (index==0){
            first = node.next;
        } else{
            node(index - 1).next = node.next;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null){
            for (int i=0; i<size; i++){
                if (node.element==null){
                    return i;
                }
                node = node.next;
            }
        } else{
            for (int i=0; i<size; i++){
                if (element.equals(node.element)){
                    return i;
                }
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
