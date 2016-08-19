package Homework_7.task_1.pluginRootDirectory.pluginName;

import Homework_7.task_1.Plugin;

/**
 * Created by ABurykin on 20.08.2016.
 */
public class Plugin1  implements Plugin{

    @Override
    public void doUsefull() {
        System.out.println("Это Plugin где getClassLoader ="+ this.getClass().getClassLoader());
    }
}
