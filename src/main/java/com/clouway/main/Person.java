package com.clouway.main;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class Person {

    private Integer age;
    private String firstName, lastName;

    public Person() {
    }

    public Person(Integer age, String firstName, String lastName) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
