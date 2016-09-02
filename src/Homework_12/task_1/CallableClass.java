package Homework_12.task_1;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by ABurykin on 02.09.2016.
 */
public class CallableClass implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("Выполняются сложные рассчеты 3 секунды.");
        Thread.sleep(3000);
        Date x = new Date();

        if(true) throw new CallableException("Кривые руки сделали ошибку ввода", new IOException());

        return x.getTime();
    }
}
