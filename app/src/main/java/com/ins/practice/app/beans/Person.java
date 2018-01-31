package com.ins.practice.app.beans;

/**
 * Created by Administrator on 2018/1/27.
 */
public class Person {
    private int type;
    private String name;
    private int grade;

    public Person() {
    }

    public Person(int type, String name, int grade) {
        this.type = type;
        this.name = name;
        this.grade = grade;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
