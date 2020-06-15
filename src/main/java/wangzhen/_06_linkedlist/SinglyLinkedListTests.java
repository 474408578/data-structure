package wangzhen._06_linkedlist;

import org.junit.jupiter.api.Test;

public class SinglyLinkedListTests {
    @Test
    public void palindromeTests() {
        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }

        System.out.println("打印原始:");
        link.printAll();
        if (link.isPalindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
    }
}
