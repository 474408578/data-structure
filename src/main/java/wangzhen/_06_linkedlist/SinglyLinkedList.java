package wangzhen._06_linkedlist;

/**
 * 1) 单链表的插入、删除、查找操作
 * 2) 链表中村出的是int类型的数据
 */
public class SinglyLinkedList {

    private Node head = null;

    // 根据值查找node
    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    // 根据索引查找node
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while(p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    // 节点在头结点插入
    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // 根据值来插入
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    // 链表尾部插入
    public void insertTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }

    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        insertTail(newNode);
    }

    // 插入到某个节点之后
    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void  insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    // 插入到某个节点之前
    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (p == head) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    // 删除节点
    public void deleteByNode(Node p) {
        if (p == null || head == null) return;

        // 头节点（第一个节点）
        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        // 说明p为头结点
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    // 打印链表
    public void printAll() {
        Node p = head;
        while(p != null) {
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    // 判断是否是回文
    public boolean isPalindrome() {
        if (head == null) {
            return false;
        } else {
            System.out.println("开始执行找到中间节点");
            // 基于快慢指针
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }

            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }

            System.out.println("中间节点" + p.data);
            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink= null;
            Node rightLink = null;
            if (q.next == null) {
                // p一定为整个链表的中点，且节点数目为奇数
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个节点"+leftLink.data);
                System.out.println("右边第一个节点"+rightLink.data);
            } else{
                //p q　均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return TFResult(leftLink, rightLink);
        }
    }

    // 判断true or false
    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;

        boolean flag=true;
        System.out.println("left_:"+l.data);
        System.out.println("right_:"+r.data);
        while(l != null && r != null){
            if (l.data == r.data){
                l = l.next;
                r = r.next;
                continue;
            }else{
                flag=false;
                break;
            }

        }

        System.out.println("什么结果");
        return flag;
       /* if (l==null && r==null){
           System.out.println("什么结果");
           return true;
        }else{
           return false;
        }*/
    }

    // 带节点的链表翻转
    public Node inverseLinkList_head(Node p) {
        // Head为新建的一个头结点
        Node Head = new Node(9999, null);
        Head.next = p;

        /**
         * 带头结点的链表翻转等价于从第二个元素开始重新头插法建立链表
         */
        Node Cur= p.next;
        p.next = null;
        Node next = null;

        while (Cur != null) {
            next = Cur.next;Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first " + Head.data);

            Cur = next;
        }

        return Head;

    }

    // 无头结点的链表翻转
    private Node inverseLinkList(Node p) {
        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.data);
        Node next = null;
        while (r != p) {
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;
        // 返回左半部分的中电之前的哪个节点
        return r;

    }


    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
