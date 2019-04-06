/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajarlistview;

/**
 *
 * @author kuupie
 */
public class Student {
    
    private static int studentIdAct = 0;
    private int studentId;
    private String name;
    private GENDER gender;

    enum GENDER {
        MALE,
        FEMALE
    }

    public Student(String name, GENDER gender) {
        studentId = studentIdAct++;
        this.name = name;
        this.gender = gender;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }
}
