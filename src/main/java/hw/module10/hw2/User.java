package hw.module10.hw2;

import java.io.File;

public class User {
    private String name;
    private int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
            }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
