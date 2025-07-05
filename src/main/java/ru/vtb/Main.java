package ru.vtb;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Human aleksey = new Human(
                "Aleksey",
                true,
                30
        );

        List<String> lectuers = new ArrayList<>();
        lectuers.add("git");
        lectuers.add("java");
        lectuers.add("files");
        lectuers.add("junit");

        int varInt = 12;

        String hello = "Hello";

        aleksey.doSeth(
                varInt,
                hello,
                lectuers
        );

        System.out.println("After method: " + varInt);
    }



}
