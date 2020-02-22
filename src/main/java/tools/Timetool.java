package tools;

import java.time.LocalTime;

public class Timetool {
    public interface Task{
        void execute();
    }

    public static void check(String title, Task task){
        if (task == null) return;
        title = (title == null)? "" : ("【" + title + "】");
        System.out.println(title);
        System.out.println("开始：" + LocalTime.now());
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束：" + LocalTime.now());
        System.out.println("耗时：" + (end - begin)/1000.0 + "秒");
        System.out.println("------------------------------------");
    }
}
