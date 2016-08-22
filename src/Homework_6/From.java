package Homework_6;

/**
 * Created by ABurykin on 12.08.2016.
 */
public class From extends ParentFrom{

    // приватный метод который не должен быть найден
    private int getY(){
        return 31;
    }

    // публичный метод , который должен быть найден
    @Override
    public int getA_int() {
        return 101;
    }
    // публичный метод , который должен быть найден
    @Override
    public String getB_Str() {
        return "From getB_Str";
    }

}


