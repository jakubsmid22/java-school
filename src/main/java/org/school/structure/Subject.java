package org.school.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Subject {

    private final String name;
    private final Teacher teacher;
    private final List<Integer> grades;

    public Subject(String name, Teacher teacher, School school) {
        this.name = name;
        this.grades = new ArrayList<>();
        this.teacher = teacher;
        teacher.addSubject(this);
        school.addSubject(this);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    void addGrade(Integer grade) {
        this.grades.add(grade);
    }

    double getAvgGrade() {
        OptionalDouble avgGrade = this.grades
                .stream()
                .mapToInt(a -> a)
                .average();

        return avgGrade.isPresent() ? avgGrade.getAsDouble() : 0;
    }

    public String getName() {
        return name;
    }
}
