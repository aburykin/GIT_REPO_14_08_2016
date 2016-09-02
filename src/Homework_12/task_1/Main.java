package Homework_12.task_1;

/**
 * Created by ABurykin on 31.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Task task = new Task(new CallableClass());
        for (int i = 0; i < 10; i++) {
            Thread th = new Thread(() -> System.out.println(Thread.currentThread().getName() +" вернул: " + task.get()));
            th.setName("thread "+i);
            th.start();
        }
    }
}
