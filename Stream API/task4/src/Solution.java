import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {

    /*
    * Проверьте, все ли задачи чтения имеют тег books.
    * Решить необходимо в 1 stream.
    */

    public static void main(String[] args) {
//        Task task1 = new Task(1, "Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");
//        Task task2 = new Task(2, "Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");
//        Task task3 = new Task(3, "Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");
//        Task task4 = new Task(4, "Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");
//        Task task5 = new Task(5, "Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");
//        List<Task> tasks = Arrays.asList(task1, task2, task3, task4, task5);

        /*
        Модифицирую условие для удобства тестирования.
         */
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1, "Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books"));
        tasks.add(new Task(2, "Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books"));
        tasks.add(new Task(3, "Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile"));
        tasks.add(new Task(4, "Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams"));
        tasks.add(new Task(5, "Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading"));
//        tasks.add(new Task(6, "Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books2").addTag("reading")); // С этой строкой результат будет противоположный

        System.out.println(allReadingTasks(tasks));
    }

    private static Boolean allReadingTasks(List<Task> tasks) {
        final String targetTag = "books"; // будем искать у каждой задачи тэг "books"

        return tasks.stream()
                .filter(task -> task.getType() == TaskType.READING) // фильтруем только задачи чтения
                .peek(task -> System.out.println("Checking task: " + task)) // наблюдаем за промежуточными результатами
                .allMatch(task -> task.getTags().contains(targetTag)); // проверяем, содержит ли задача тег "books"
    }
}