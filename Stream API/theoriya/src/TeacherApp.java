import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/*
Вывести все имена студентов
 */
public class TeacherApp {
    public static void main(String[] args) {
        Teacher t = new Teacher();
    }


    public static class Teacher {
        long id;
        String name;
        List<Student> students;
    }

    public static class Student {
        long id;
        String name;
    }

    public static class Service {
        public Collection<String> getStudentNames(List<Teacher> teachers) {
            return null;
//            return teachers.stream()
//                    .flatMap(teacher -> teacher.students.stream())
//                    .map(student -> student.name)
//                    .collect(Collectors.toList());
        }
    }
}