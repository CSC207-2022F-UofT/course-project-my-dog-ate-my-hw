package entities;
import java.util.List;
import java.util.ArrayList;
public abstract class Checklist {
        /**
         * An abstract class containing a list of tasks that and can be manipulated. Tasks can be added or removed from
         * the checklist. Tasks can also be searched from the checklist. The checklist can be converted to a list of
         * strings for viewing purposes.
         */

        private List<Task> checklist;

        public Checklist() {
            this.checklist = new ArrayList() <>;
        }


        /**
         * Add the given task to checklist. Do not sort the checklist.
         * @param task
         */
        public void addTask(Task task) {
            this.checklist.add(task);
        }

        /**
         * Remove the given task from the checklist.
         * @param task
         */
        public void removeTask(Task task) {
            this.checklist.remove(task);
        }

        /**
         * Return the task in the checklist that has the given name. The names of tasks are unique.
         * @param taskName : the name of the task being searched for.
         * @return : a task with the given name or throw an AbsentTaskNameException if there is no task with
         * the given name.
         */

        public Task searchFor(String taskName) throws AbsentTaskNameException {
                for (Task task : checklist) {
                    if (task.getName() == taskName) {
                        return task;
                    }
                }
                throw new AbsentTaskNameException();
            }

        /**
         * Return a clone of the checklist.
         * @return : A clone of the list the checklist attribute.
         */
        public abstract List<String> toList() {

            }
}
