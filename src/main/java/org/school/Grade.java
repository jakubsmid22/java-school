package org.school;

public enum Grade {
    A(1),
    B(2),
    C(3),
    D(4),
    F(5);

    private final int value;

    Grade(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
