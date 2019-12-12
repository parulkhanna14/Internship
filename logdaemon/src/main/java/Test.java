// Java program to demonstrate
// working of TimerTask class
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Timer;
import java.util.TimerTask;

class Helper extends TimerTask
{
    public static int i = 0;
    public void run()
    {
        System.out.println("Timer ran" + ++i);
        if(i == 4)
        {
            synchronized(Test.obj)
            {
                Test.obj.notify();
            }
        }
    }

}


public class Test
{
    static Logger log = Logger.getLogger(Test.class);
    public static Test obj;
    public static void main(String[] args) throws InterruptedException
    {
        String log4jConfPath = "/home/sciera/gitprojects/Internship/logdaemon/src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        obj = new Test();

        // creating an instance of timer class
        Timer timer = new Timer();

        // creating an instance of task to be scheduled
        TimerTask task = new Helper();

        // scheduling the timer instance
        timer.schedule(task, 500, 5000);

        // fetching the scheduled execution time of
        // the most recent actual execution of the task
        System.out.println(task.scheduledExecutionTime());

        synchronized(obj)
        {
            //this thread waits until i reaches 4
            obj.wait();
        }

        //canceling the task assigned
        System.out.println("Cancel the timer task: " + task.cancel());

        // at this point timer is still running
        // without any task assigned to it

        log.info("This is an info msg!");
        // canceling the timer instance created
        timer.cancel();
    }
}
