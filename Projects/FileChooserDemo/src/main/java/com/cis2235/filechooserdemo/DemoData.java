package com.cis2235.filechooserdemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class DemoData {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public DemoData() {
        name = "Adam";
        age = 42;
    }

    @Override
    public String toString() {
        String strSummary = "Hello " + name + "\nYour age is " + age;
        return strSummary;
    }

    public void writeFile(File file) {
        try {
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(this.toString());
            out.close();
        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
        }
    }
}
