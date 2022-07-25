package p2;

import java.util.List;

public class StudentResource {
    private StudentAction studentAction;

    public StudentResource() {
        studentAction = new StudentAction();
    }

    public boolean doSaveStudent(Student student) {
        return studentAction.doSaveStudent(student);
    }

    public List<Student> getStudents(String course) {
        return studentAction.getStudents(course);
    }

    public List<Student> getStudentsBasedOnScreeningScore() {
        return studentAction.getStudentsBasedOnScreeningScore();
    }

    public Student update(Student student){
        return studentAction.update(student);
    }

    List<Student> getStudentsBasedOnScreeningScore(int lower, int upper){
        return studentAction.getStudentsBasedOnScreeningScore(lower, upper);
    }
}
