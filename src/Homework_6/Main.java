package Homework_6;

/**
 * Created by ABurykin on 12.08.2016.
 */
public class Main {
    public static void main(String[] args){

       From f = new From();
        To t = new To();

        BeanUtils.assign(t, f);

    }
}
