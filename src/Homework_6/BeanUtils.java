package Homework_6;

/**
 * Created by ABurykin on 12.08.2016.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


/**

    Scans object "from" for all getters.
    If object "to" contains correspondent setter,
    it will invoke it set property value for "to" which equals to the property of "from".

 The type in setter should be compatible to the value returned by getter (if not, no invocation performed).


 Compatible means that parameter type in setter should be the same or be superclass of the return type of the getter.

 The method takes care only about public methods.

 param to   Object which properties will be set.
 param from Object which properties will be used to get values.

 ------------ перевод на русский

 сканирует Объект from на наличие геттеров.
 Если объект to содержит соответственный setter,
 устанавливается значение для объекта to которое равно свойству from.

 Тип сеттера должен быть совместим с возвращаемым значением геттера (Если не совместим, не выполнять вызов )

 Совеместимость означаетс, что тип сеттера должен быть таким же или совпадать с типов геттера в супер классе.

 Метод работает только с публичными методами.

param to   Объект который используется для вызова сеттеров.
param from Objec используется для геттеров.
 */

public class BeanUtils {

    public static void assign(Object to, Object from) {

        Method[] to_methods = to.getClass().getMethods(); // получаем все публичные методы объекта
        Method[] from_methods = from.getClass().getMethods(); // получаем все публичные методы объекта

        // получаю все геттеры с возвращаемыми типами
        for (Method from_m: from_methods) {
            if (from_m.getName().substring(0,3).equals("get")){

                // далее для каждого геттера ищу совместимый сеттер и вызываю его
                for (Method to_m: to_methods) {
                    if (to_m.getName().substring(0,3).equals("set") && to_m.getParameterCount() == 1){ // только с 1 параметром, т.к. геттер возвращает только 1 значение
                        Parameter[] to_params = to_m.getParameters();
                        if ( from_m.getReturnType() == to_params[0].getType()){
                            try {
                                to_m.invoke(to,from_m.invoke(from));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }


            }
        }
    }
}