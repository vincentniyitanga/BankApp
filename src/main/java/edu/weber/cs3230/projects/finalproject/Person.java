package edu.weber.cs3230.projects.finalproject;

public abstract class Person {
    public abstract String getDescription();
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastName = lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
