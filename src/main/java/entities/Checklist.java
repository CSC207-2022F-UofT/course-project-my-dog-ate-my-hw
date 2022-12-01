package entities;
import java.util.List;
import java.util.ArrayList;
public abstract class Checklist {
        /**
         * An abstract class containing a list of tasks that and can be manipulated. Tasks can be added or removed from
         * the task list. Tasks can also be searched from the tasklist. The task list can be returned for
         * viewing purposes.
         */

        private List<Task> taskList;

        public Checklist() {
            this.taskList = new ArrayList();
        }


        /**
         * Add the given task to taskList. Do not sort the taskList.
         * @param task
         */
        public boolean addTask(Task task) {
            this.taskList.add(task);
            return true;
        }

        /**
         * Remove the given task from the taskList.
         * @param task
         */
        public void removeTask(Task task) {
            this.taskList.remove(task);
        }

        /**
         * Return the task in the taskList that has the given name. The names of tasks are unique.
         * @param taskName : the name of the task being searched for.
         * @return : a task with the given name or throw an AbsentTaskNameException if there is no task with
         * the given name.
         */

        public Task searchFor(String taskName) throws AbsentTaskNameException {
                for (Task task : taskList) {
                    if (task.getName() == taskName) {
                        return task;
                    }
                }
                throw new AbsentTaskNameException();
            }

        /**
         * Return the taskList.
         * @return : The taskList attribute.
         */
        public List<Task> getTaskList() {
            return this.taskList;
            }
}
