package Homework_7.task_1.pluginRootDirectory.Game2;

import Homework_7.task_1.pluginRootDirectory.Plugin;

/**
 * Created by ABurykin on 20.08.2016.
 */
public class Plugin1 implements Plugin{

    @Override
    public void doUsefull() {
        System.out.println("Это Game2.Plugin: getClassLoader ="+ this.getClass().getClassLoader());
    }
}
