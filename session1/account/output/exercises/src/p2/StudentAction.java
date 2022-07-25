package p2;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class StudentAction implements StudentActionService {

    private StudentDAO studentDAO;

    public StudentAction() {
        this.studentDAO = new StudentDAO();
    }

    public boolean doSaveStudent(Student student) {
        if (!isAnyNull(isNull(student.getCourse()),
                isNull(student.getStudentName()))) {
            return false;
        }
        return studentDAO.save(student);
    }

    public List<Student> getStudents(String course) {
        return studentDAO.getStudentsByCourse(course);
    }

    public List<Student> getStudentsBasedOnScreeningScore() {
        List<Student> students = studentDAO.findAll();
        students.sort(comparing(Student::getScreeningScore));
        return students;
    }

    @Override
    public List<Student> getStudentsBasedOnScreeningScore(int lowerRange, int upperRange) {
        Predicate<Student> p = student -> student.getScreeningScore() >= lowerRange
                && student.getScreeningScore() <= upperRange;
        return studentDAO.findAll().stream().filter(p).collect(Collectors.toList());
    }

    public Student update(Student student) {
        Optional<Student> dbStudent = studentDAO.getById(student.getEnrollmentNumber());
        if (dbStudent.isPresent()) {
            Student foundStudent = dbStudent.get();
            if (nonNull(student.getStudentName())) {
                foundStudent.setStudentName(student.getStudentName());
            }
            if (nonNull(student.getCourse())) {
                foundStudent.setCourse(student.getCourse());
            }
            if (nonNull(student.getCourse())) {
                foundStudent.setScreeningScore(student.getScreeningScore());
            }
            return foundStudent;
        } else {
            throw new NoSuchElementException("Student with enrollment id " + student.getEnrollmentNumber() + " does not exist.");
        }
    }

    private static boolean isAnyNull(Object... objects) {
        for (Object o : objects) {
            if (isNull(o)) {
                return true;
            }
        }
        return false;
    }
}