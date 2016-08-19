package Homework_7.task_1;


import Homework_7.task_1.pluginRootDirectory.pluginName.Plugin1;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by ABurykin on 12.08.2016.
 */
public class Main {
    public static void main(String[]  args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        String dir =  "Homework_7.task_1.pluginRootDirectory.pluginName.";
        PluginManager pluginMamager = new PluginManager(dir);
        System.out.println(dir);

        Plugin p1 = (Plugin)pluginMamager.load("Game1", "Plugin1");
        p1.doUsefull();

        Plugin p2 = new Plugin1();
        p2.doUsefull();

        Plugin p3 = (Plugin)pluginMamager.load("Game2", "Plugin1");
        p3.doUsefull();
    }


}

/*
  //  Plugin p0 = new Plugin1("SystenPlugin");
        //Plugin p1 = new Plugin1();

      //  p0.doUsefull();
        p1.doUsefull();
*/
