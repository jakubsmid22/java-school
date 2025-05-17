package org.school.structure;

import org.school.Grade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;

public class Student {

    private final String name;
    private final List<Subject> subjects;
    private final HashMap<Subject, ArrayList<Integer>> grades;

    public Student(String name, Clazz clazz) {
        this.name = name;
        this.subjects = new ArrayList<>();
        this.grades = new HashMap<>();
        clazz.addStudent(this);
    }

    public String getName() {
        return name;
    }


    public void addSubject(Subject subject) {
        if (this.subjects.contains(subject)) {
            throw new RuntimeException("Student " + this.name + " already has subject " + subject.getName() + "!");
        }
        else {
            this.subjects.add(subject);
            this.grades.put(subject, new ArrayList<Integer>());
        }
    }

    public void addGrade(Grade grade, Subject subject) {
        if (!this.subjects.contains(subject)) {
            throw new RuntimeException("Student " + this.name + " does not have a subject " + subject.getName() + "!");
        }
        else {
            this.grades.get(subject).add(grade.getValue());
            subject.addGrade(grade.getValue());
        }
    }

    public HashMap<Subject, ArrayList<Integer>> getGrades() {
        return grades;
    }

    double getAverageGrade() {
        OptionalDouble avgGrade = this.grades
                .values()
                .stream()
                .flatMap(grades -> grades.stream())
                .mapToInt(a -> a)
                .average();

        return avgGrade.isPresent() ? avgGrade.getAsDouble() : 0;

    }

}