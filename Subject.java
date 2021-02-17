package com.mypackage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Subject {

    protected String subjectName;
    protected ArrayList<Integer> students;
    private static final AtomicInteger count = new AtomicInteger(0);
    protected final int subjectId;

    public Subject(String subjectName){
        this.subjectId = count.incrementAndGet();
        this.subjectName = subjectName;
        students = new ArrayList<>();
    }

    public String toString(){
        return subjectId + " | " + subjectName;
    }
}
