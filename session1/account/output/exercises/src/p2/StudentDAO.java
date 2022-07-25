package p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentDAO {
    private List<Student> students = new ArrayList<>();

    public boolean save(Student student) {
        return students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public List<Student> getStudentsByCourse(String course) {
        return students.stream().filter(s -> s.getCourse()
                .equalsIgnoreCase(course)).collect(Collectors.toList());
    }

    Optional<Student> getById(int id) {
        return students.stream().filter(s -> s.getEnrollmentNumber() == id).findFirst();
    }
}
