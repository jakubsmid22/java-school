package org.school.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Clazz {

    private final String name;
    private final Teacher primaryTeacher;
    private final School school;
    private final List<Student> students;

    public Clazz(String name, Teacher primaryTeacher, School school) {
        this.name = name;
        this.primaryTeacher = primaryTeacher;
        this.school = school;
        school.addClass(this);
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    void addStudent(Student student) {
        this.students.add(student);
        this.school.addStudent(student);
    }

    double getBestStudentAvgGrade() {
        return this.students
                .stream()
                .mapToDouble(Student::getAverageGrade)
                .min().getAsDouble();
    }


    public void printInfo() {
        System.out.println("Class " + this.name);
        System.out.println("Teacher: " + this.primaryTeacher.getName());
        System.out.println("Students: " + this.students.size() + "\n");
    }

}
