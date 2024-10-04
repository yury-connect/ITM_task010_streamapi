import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Task {

    private final Integer id;

    private final String title;

    private final  TaskType type;

    private final LocalDate createdOn;

    private boolean done = false;

    private Set<String> tags = new HashSet<>();

    private LocalDate dueOn;



    public Task(Integer id, String title, TaskType type, LocalDate createdOn) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.createdOn = createdOn;
    }

    public Task addTag(String tag){
        this.tags.add(tag);
        return this;
    }



    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskType getType() {
        return type;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public LocalDate getDueOn() {
        return dueOn;
    }

    public void setDueOn(LocalDate dueOn) {
        this.dueOn = dueOn;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", createdOn=" + createdOn +
                '}';
    }


    // Я взял на себя смелость переопределить equals, т.к. объекты должны сравниваться по полям, а не по ссылкам.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Быстрая проверка на ссылку
        if (o == null || getClass() != o.getClass()) return false; // Проверка на тип объекта
        Task task = (Task) o;
        return
                // Поле id НЕ сравниваем, т.к. это динамически назначаемое значение
                Objects.equals(title, task.title) && // Сравниваем поле title
                type == task.type && // Сравниваем поле type (перечисление)
                Objects.equals(createdOn, task.createdOn) && // Сравниваем поле createdOn
                Objects.equals(tags, task.tags); // Сравниваем множества tags // Метод Objects.equals() корректно сравнивает множества, так как он вызывает метод equals() у самого множества, который, в свою очередь, проверяет равенство элементов независимо от их порядка.
    }

    @Override
    public int hashCode() {
        // Поле id НЕ участвует в hashCode, т.к. оно не участвует и в equals
        return Objects.hash(title, type, createdOn, tags); // Учитываем все поля, включая tags
    }
}
