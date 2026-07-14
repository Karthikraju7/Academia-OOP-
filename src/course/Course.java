package course;

import user.Student;
import user.Teacher;

import java.util.ArrayList;

public class Course {
    int id;
    String name;
    int capacity;
    Teacher assignedTeacher;
    ArrayList<Student> enrolledStudents = new ArrayList<>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }
    public void setAssignedTeacher(Teacher assignedTeacher) {
        this.assignedTeacher = assignedTeacher;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Course(int id, String name, Teacher assignedTeacher, int capacity){
        this.id = id;
        this.name = name;
        this.assignedTeacher = assignedTeacher;
        this.capacity = capacity;
    }

    public void addStudent(Student student){
        enrolledStudents.add(student);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Teacher: " + assignedTeacher.getName() +
                ", Capacity: " + capacity;
    }
}
