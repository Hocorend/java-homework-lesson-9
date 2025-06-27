package org.example.homework;

import java.util.List;

public class Student {

    String name;
    String lastname;
    Integer numberSeason;
    List<Integer> marks;

    public Student(String name, String lastname, Integer numberSeason, List<Integer> marks) {
        this.name = name;
        this.lastname = lastname;
        this.numberSeason = numberSeason;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getNumberSeason() {
        return numberSeason;
    }

    public void setNumberSeason(Integer numberSeason) {
        this.numberSeason = numberSeason;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
}
