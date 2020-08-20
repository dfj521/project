package com.dfj.entity;

public class ClassGrade {
    private Integer id;
    private String grade;
    private String classroom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "ClassGrade{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
