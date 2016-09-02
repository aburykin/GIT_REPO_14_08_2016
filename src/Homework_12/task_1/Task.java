package Homework_12.task_1;

import java.util.concurrent.Callable;

/**
 * Created by ABurykin on 31.08.2016.
 */
public class Task<T> {
    private final Callable callable;
    private volatile T result;
    private volatile boolean exception = false;
    private volatile String exceptionText = "";


    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }


    public  T get() {
        try {
            System.out.println(Thread.currentThread().getName() + "  In try");
            if (result == null){
                synchronized(this.callable){ // поток ожидающий synchronized не нагружает процессор
                    if (exception) throw new Exception();

                    System.out.println(Thread.currentThread().getName() + "  In synchronized");
                    if (result == null){
                        System.out.println(Thread.currentThread().getName() + "  получает результат");
                        result =  (T)callable.call();
                    }
                }
            }
        } catch (Exception e) {
            if (exception){
                throw new RuntimeException(exceptionText);
            } else {
                exception = true;
                if ("".equals(exceptionText)) exceptionText = "Исключение появилось по причине: " + e.getLocalizedMessage();
                throw new RuntimeException(exceptionText);
            }
        }
        return result;
    }
}
