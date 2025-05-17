package org.school.structure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class School {

    private final String name;
    private final List<Clazz> classes;
    private final List<Subject> subjects;
    private final List<Student> students;

    public School(String name) {
        this.name = name;
        this.classes = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    void addStudent(Student student) {
        this.students.add(student);
    }

    void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    void addClass(Clazz clazz) {
        this.classes.add(clazz);
    }

    public void checkIfAllStudentsHaveGradeInEachSubject() {
        List<Student> studentsWithoutGrade = students
                .stream()
                .filter(student -> student
                        .getGrades()
                        .entrySet()
                        .stream()
                        .anyMatch(grades -> grades.getValue().isEmpty())
                )
                .toList();

        if (!studentsWithoutGrade.isEmpty()) {
            throw new RuntimeException("These students don't have a grade in each subject: " +
                    studentsWithoutGrade.stream().map(Student::getName).collect(Collectors.joining(", "))
            );
        }

    }

    public void sortStudentsByAvgGrade() {
        System.out.println("Sorted students by their average grades:");
        this.students
                .stream()
                .sorted(Comparator.comparingDouble(Student::getAverageGrade))
                .forEach(student -> System.out.println(student.getName() + " - " + student.getAverageGrade()));
        System.out.println();
    }

    public void sortSubjectsByAvgGrade() {
        System.out.println("Sorted subjects by average of grades given to students:");
        this.subjects
                .stream()
                .sorted(Comparator.comparingDouble(Subject::getAvgGrade))
                .forEach(subject -> System.out.println(subject.getName() + " - " + subject.getAvgGrade()));
        System.out.println();
    }

    public void sortClassesWithBestStudent() {
        System.out.println("Sorted classes with the best students:");
        this.classes
                .stream()
                .sorted(Comparator.comparingDouble(Clazz::getBestStudentAvgGrade))
                .forEach(clazz -> System.out.println(clazz.getName() + " - " + clazz.getBestStudentAvgGrade()));
        System.out.println();
    }

    public void printInfo() {
        System.out.println("SCHOOL " + this.name + "\n");

        System.out.println("CLASSES:");
        this.classes.forEach(Clazz::printInfo);

        this.sortStudentsByAvgGrade();
        this.sortSubjectsByAvgGrade();
        this.sortClassesWithBestStudent();
    }

}
