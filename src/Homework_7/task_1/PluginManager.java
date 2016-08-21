package Homework_7.task_1;

import Homework_7.task_1.pluginRootDirectory.Plugin;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by ABurykin on 12.08.2016.
 */


// загрузчик плагинов
public class PluginManager {
    private final String pluginRootDirectory;
    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) {
        // папка класса - pluginName
        // pluginClassName - имя класса

        try {
            URL url = new URL("file://"+System.getProperty("user.dir")+"/out/production/GIT_REPO_14_08_2016/");
            //System.out.println("url:" +url);

            URLClassLoader MyClassLoader = new URLClassLoader(new URL[]{url}); //модель делегирования подключена
            Class<?> clazz =  MyClassLoader.loadClass(pluginRootDirectory+pluginName+"."+pluginClassName);

            System.out.println(pluginName+"."+pluginClassName +":getClassLoader = " +  clazz.getClassLoader());
            System.out.println(clazz.getClass().getName());
            System.out.println(clazz.getClass().getClassLoader());

             Object x  = clazz.newInstance();
             return (Plugin)x;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}