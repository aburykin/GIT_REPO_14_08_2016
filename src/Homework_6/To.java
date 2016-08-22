package Homework_6;

/**
 * Created by ABurykin on 12.08.2016.
 */
public class To {

   // приватный метод который не должен быть найден
    private void setY(int y){
        System.out.println("y = " + y);
    }

    // публичный метод, который должен быть найден и вызваться
    public void setA_int(int A){
        System.out.println("A = " + A);
    }

    // публичный метод, который должен быть найден и вызваться
    public void setB_Str(String B){
        System.out.println("B = " + B);
    }

    // публичный метод, который должен быть найден и вызваться как метод супер класса
    public void setC_diff_type(double C){
        System.out.println("C = " + C);

    }
}
