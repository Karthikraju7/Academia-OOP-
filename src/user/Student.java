package user;

import course.Course;

import java.util.ArrayList;

public class Student extends User{

    ArrayList<Course> enrolledCourses = new ArrayList<>();

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public Student(String id, String name, String email, String password, int age){
        super(id, name, email, password, age, Role.STUDENT);
    }

    public void addCourse(Course course){
        enrolledCourses.add(course);
    }
}