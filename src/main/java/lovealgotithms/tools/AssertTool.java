package lovealgotithms.tools;

public class AssertTool {
    public static void test(boolean value){
        if (!value){
            try {
                throw new Exception("测试不通过");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
