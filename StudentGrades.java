package com.mypackage;

import java.util.ArrayList;

public class StudentGrades {
    protected String gradesId;
    protected ArrayList<Integer> grades;
    public StudentGrades( int subjectId,int studentId){
        this.gradesId = subjectId + "|" + studentId;
        grades = new ArrayList<>();
    }

    public String toString(){
        return gradesId;
    }


}
