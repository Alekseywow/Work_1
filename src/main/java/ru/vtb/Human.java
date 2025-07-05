package ru.vtb;

import java.util.List;

public class Human {


    // Константы

    private static final String startName = "Human";

    private final String name;

    private final int age;

    private final boolean isCute;


    public Human(String name, boolean isCute, int age) { // Специальный вид конструктора(Повторяет название класса)
        this.name = name; // this обращение к этому объекту
        this.isCute = isCute;
        this.age = age;
    }

    static void syaHello() {
        System.out.println("Hello, " + startName + "!!!!");
    }

    void syaHelloNonStatic() {
        System.out.println("Hello, " + this.name + "!!!!");
    }

    public Human iccrementAge(){
        return new Human(
                this.name,
                this.isCute,
                (this.age + 1)
        );
    }

    public boolean isCute() {
        return isCute;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    void doSeth(int i, String str, List<String> list) {

        i = 100;

        System.out.println("int: " + i + " " + str + " " + list);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isCute=" + isCute +
                '}';
    }
}
