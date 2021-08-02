package com.bjpowernode.ba02;

public class Student {
    private String name;
    private int age;

    //声明一个引用类型
    private School school;

    public Student(){
        System.out.println("spring会调用类的无参构造方法创建对象");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
