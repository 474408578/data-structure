package LinearList.DynamicArray;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(1);
        }

        for (int i = 0; i < 90; i++) {
            arrayList.remove(0);
        }

        /*
        System.out.println(arrayList);
        arrayList.set(4, 88);
        Assert.test(arrayList.get(4)==56);
        System.out.println(arrayList);



        ArrayList<Object> objects = new ArrayList<>();

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(18, "Jack"));
        persons.add(new Person(22, "James"));
        persons.add(new Person(21, "Marry"));
        Person xiangsong = new Person(22, "xiangsong");
        System.out.println(persons.indexOf(xiangsong));
        System.out.println(persons);

        persons.clear();
        // 提醒JVM进行垃圾回收, 此时会调用finalize()函数
        System.gc();
*/

    }
}
