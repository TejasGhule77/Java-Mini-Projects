import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Task implements  Comparable<Task>
{
    private String name;
    private LocalDate duedate;
    private int priority;
    public Task(String name,LocalDate duedate,int priority){
        this.name=name;
        this.duedate=duedate;
        this.priority=priority;


    }
    public String toString(){
        return name+"Due:"+duedate+"priority"+priority;
    }

    @Override
    public int compareTo(Task t) {
        return this.duedate.compareTo(t.duedate);
    }

}
class Taskmanager{
    private List<Task> tasks= new ArrayList<>();
    public void  addTask(Task t){ tasks.add(t);

    }
    public void showtasks(){
        Collections.sort(tasks);
        for(Task t: tasks){
            System.out.println(t);
        }
    }

}
public class ToDoManager {
    public static void main(String[] args) {
        Taskmanager tm = new Taskmanager();
        tm.addTask(new Task("Task1",LocalDate.of(2025,8,5),2));
        tm.addTask(new Task("Task2",LocalDate.of(2025,9,12),1));
        System.out.println("\nTasks:");
        tm.showtasks();

    }
}
