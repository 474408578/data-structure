package binarytree.binarysearchtree;

import binarytree.binarysearchtree.cmp.Comparable;

// 需要Person实现Comparable的接口，才可以使用二叉搜索树
public class Person implements Comparable<Person> {
    int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.age;
    }
}
