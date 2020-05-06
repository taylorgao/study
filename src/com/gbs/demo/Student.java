package com.gbs.demo;

public class Student {
    private int no;
    private String name;
    private int age;


    public Student(){};

    public Student(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{no:" + no + "; name:" + name + " age:" + age + "}";
    }

    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Student)
        {
            Student student = (Student)obj;
            if(student.no == this.no
                    && student.age == this.age
                    && student.name.equals(this.name))
                return true;
        }
        return false;
    }

//    @Override
//    public int hashCode() {
//        return 1234;
//    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
