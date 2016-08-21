package Homework_7.task_1;


import Homework_7.task_1.pluginRootDirectory.Game1.Plugin1;
import Homework_7.task_1.pluginRootDirectory.Plugin;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by ABurykin on 12.08.2016.


1)
Ваша задача написать загрузчик плагинов в вашу систему.
Допустим вы пишите свой браузер и хотите чтобы люди имели имели возможность
писать плагины для него. Соответственно, разные разработчики могут назвать
свои классы одинаковым именем, ваш загрузчик должен корректно это обрабатывать.
 */
public class Main {
    public static void main(String[]  args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        // сначала загружаю интерфейс c с помощью System classLoader
        URL url = new URL("file://"+System.getProperty("user.dir")+"/out/production/GIT_REPO_14_08_2016/");
        URLClassLoader interfaceClassLoader = new URLClassLoader(new URL[]{url}); // сначала попытается загрузить системный
        Class intrfacePlugin = interfaceClassLoader.loadClass("Homework_7.task_1.pluginRootDirectory.Plugin");
        System.out.println("intrfacePlugin.getClassLoader = " +  intrfacePlugin.getClassLoader());
        //sun.misc.Launcher$AppClassLoader - это значит системный


        String dir =  "Homework_7.task_1.pluginRootDirectory.";
        PluginManager pluginMamager = new PluginManager(dir);

        Plugin p1 = pluginMamager.load("Game1", "Plugin1");
        p1.doUsefull();

        Plugin p2 = pluginMamager.load("Game2", "Plugin1");
        p2.doUsefull();


    }


}
