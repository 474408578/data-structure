package dynamicArray;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(13);
        arrayList.add(22);
        arrayList.add(65);
        arrayList.add(72);

        System.out.println(arrayList);
        arrayList.set(4, 88);
        Assert.test(arrayList.get(4)==56);
        System.out.println(arrayList);
    }
}
