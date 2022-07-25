package p2;

import java.util.List;

public interface StudentActionService {
    boolean doSaveStudent(Student student);
    List<Student> getStudents(String course);
    List<Student> getStudentsBasedOnScreeningScore();
    List<Student> getStudentsBasedOnScreeningScore(int lowerRange, int upperRange);
    Student update(Student student);
}
