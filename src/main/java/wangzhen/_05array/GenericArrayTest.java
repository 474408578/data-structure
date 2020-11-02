package wangzhen._05array;

import org.junit.jupiter.api.Test;

public class GenericArrayTest {
    @Test
    public void insertTests() {
        GenericArray<Integer> array = new GenericArray<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
        array.add(3, 99);
        System.out.println(array.find(99));
        System.out.println(array.get(3));
        array.set(2, 5);

        System.out.println(array);
        array.removeElement(99);
    }
}
