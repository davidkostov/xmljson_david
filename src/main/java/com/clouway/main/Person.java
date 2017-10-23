package com.clouway.main;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Person {

    private Integer age;
    private String name;

    public Person() {
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
