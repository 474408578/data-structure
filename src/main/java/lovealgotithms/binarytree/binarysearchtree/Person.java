package lovealgotithms.binarytree.binarysearchtree;

//import binarytree.binarysearchtree.cmp.Comparable;

// 需要Person实现Comparable的接口，才可以使用二叉搜索树
public class Person implements Comparable<Person> {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person e) {
//		if (age > e.age) return 1;
//		if (age < e.age) return -1;
//		return 0;
        return age - e.age;
    }

    @Override
    public String toString() {
        return age + "_" + name;
    }
}
