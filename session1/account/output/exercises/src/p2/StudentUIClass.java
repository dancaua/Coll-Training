package p2;

import java.util.List;

public class StudentUIClass {

    public static void main(String[] args) {
        StudentResource studentResource = new StudentResource();

        Student s1 = new Student(1, "Alex", "math");
        s1.setScreeningScore(10);

        Student s2 = new Student(2, "Ana", "math");
        s2.setScreeningScore(4);

        Student s3 = new Student(3, "Robert", "science");
        s3.setScreeningScore(8);

        studentResource.doSaveStudent(s1);
        studentResource.doSaveStudent(s2);
        studentResource.doSaveStudent(s3);

        List<Student> studentsByCourse = studentResource.getStudents("math");
        System.out.println(studentsByCourse.size());
        System.out.println(studentsByCourse);

        List<Student> studentsByScreeningScore= studentResource.getStudentsBasedOnScreeningScore();
        System.out.println(studentsByScreeningScore);


        s1.setStudentName("Changed name");
        studentResource.update(s1);

        System.out.println(studentResource.getStudents("math"));

        List<Student> studentsBasedOnScreeningScore= studentResource.getStudentsBasedOnScreeningScore(5, 10);
        System.out.println(studentsBasedOnScreeningScore);
    }

}
