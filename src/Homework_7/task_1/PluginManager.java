package Homework_7.task_1;

import Homework_7.task_1.pluginRootDirectory.pluginName.Plugin1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
        try {
            URL url = new URL("file://"+System.getProperty("user.dir")+"/out/production/GIT_REPO_14_08_2016/");
            //System.out.println("url:" +url);

             URLClassLoader MyClassLoader = new URLClassLoader(new URL[]{url}, null); // связан с иерархией
             Class<?> clazz =  MyClassLoader.loadClass(pluginRootDirectory+pluginClassName);

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