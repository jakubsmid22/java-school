package org.school;


import org.school.structure.*;

public class Main {
    public static void main(String[] args) {

        School school = new School("High School");

        Teacher teacher1 = new Teacher("Mr. Smith");
        Teacher teacher2 = new Teacher("Mrs. Black");

        Clazz clazz1 = new Clazz("3.A", teacher1, school);
        Clazz clazz2 = new Clazz("1.B", teacher2, school);

        Subject math = new Subject("Math", teacher1, school);
        Subject physics = new Subject("Physics", teacher1, school);
        Subject it = new Subject("IT", teacher2, school);
        Subject literature = new Subject("Literature", teacher2, school);

        Student student1 = new Student("Mark", clazz1);
        Student student2 = new Student("Ema", clazz1);
        Student student3 = new Student("Pete", clazz2);
        Student student4 = new Student("Anna", clazz2);

        student1.addSubject(math);
        student1.addSubject(it);
        student2.addSubject(physics);
        student2.addSubject(literature);
        student3.addSubject(it);
        student3.addSubject(math);
        student4.addSubject(it);
        student4.addSubject(physics);

        student1.addGrade(Grade.F, math);
        student1.addGrade(Grade.F, it);
        student2.addGrade(Grade.B, physics);
        student2.addGrade(Grade.D, literature);
        student3.addGrade(Grade.F, it);
        student3.addGrade(Grade.B, math);
        student4.addGrade(Grade.A, it);
        student4.addGrade(Grade.C, physics);

        school.checkIfAllStudentsHaveGradeInEachSubject();
        school.printInfo();

    }

}