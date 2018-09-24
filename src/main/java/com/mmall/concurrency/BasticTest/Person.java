package com.mmall.concurrency.BasticTest;

import java.util.Objects;

public class Person {

    private String name;
    private String password;
    private int age;

    //构造方法

    public Person(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getPassword(), person.getPassword());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getPassword(), getAge());
    }
}
