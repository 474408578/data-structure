package LinearList.DynamicArray;

public class Person {
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    // 当对象被JVM回收时，会调用此函数，相当于C++中的析构函数
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Person - finalize");
    }

    // 判断对象是否相等的方法, 自定义比较规则
    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj);//直接比较此变量和obj是否指向同一个对象。
        // 如果所传的对象的年龄和本对象的年龄相等，就认为这两个对象是相等的。
        return this.age == ((Person) obj).age;

    }
}
