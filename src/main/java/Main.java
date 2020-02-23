import tools.Timetool;

/***
 * 斐波那契数列
 * 0 1 2 3 4 5 6 7
 * 0 1 1 2 3 5 8 13
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        Timetool.check("fibonacci", () -> {
                System.out.println(fibonacci(42));
        });

        Timetool.check("fibonacci", () -> {
                System.out.println(fibonacci2(42));
        });
    }

    // 使用递归
    public static int fibonacci(int n){
        // O(2^n)
        if (n<=1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // 不使用递归
    public static int fibonacci2(int n){
        // 复杂度 O(n)
        if (n<=1){
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i=0; i<n-1;i++){
            int sum = first + second;
            first = second;
            second = sum;
        }
        return second;
    }
}
