package org.school.structure;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    private final String name;
    private final List<Subject> subjects;

    public Teacher(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

}
