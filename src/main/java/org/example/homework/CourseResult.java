package org.example.homework;

import java.util.List;

public class CourseResult {

    double resultByCourse;

    List<StudentsResult> studentsResultList;

    public CourseResult(double resultByCourse) {
        this.resultByCourse = resultByCourse;
    }

    public CourseResult(double resultByCourse, List<StudentsResult> studentsResultList) {
        this.resultByCourse = resultByCourse;
        this.studentsResultList = studentsResultList;
    }

    public List<StudentsResult> getStudentsResultList() {
        return studentsResultList;
    }

    public void setStudentsResultList(List<StudentsResult> studentsResultList) {
        this.studentsResultList = studentsResultList;
    }

    public double getResultByCourse() {
        return resultByCourse;
    }

    public void setResultByCourse(double resultByCourse) {
        this.resultByCourse = resultByCourse;
    }

    public static class StudentsResult {

        String name;
        String lastname;

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

        public StudentsResult(String name, String lastname) {
            this.name = name;
            this.lastname = lastname;
        }
    }
}
