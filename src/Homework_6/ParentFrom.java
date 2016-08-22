package Homework_6;

/**
 * Created by ABurykin on 12.08.2016.
 */
public class ParentFrom {

     // приватный метод который не должен быть найден
    private int getX(){
        return 30;
    }

    // публичный метод , который должен быть найден в наследнике
    public int getA_int(){
        return 1;
    }

    // публичный метод , который должен быть найден в наследнике
    public String getB_Str(){
        return "ParentFrom getB_Str";
    }

    // публичный метод , который должен быть найден как метод супер класса
    public double getC_double(){
        return 3.0;
    }

}
