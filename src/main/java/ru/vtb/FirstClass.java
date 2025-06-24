//package ru.vtb;
//
//import java.util.List;
//
//public class FirstClass {
//
//
//    public static void main(String[] args) {
//
//        // Целочисленные типы
//        byte aByte = 0; // 8b
//        short aShort = 0; // 16b
//        int aInt = 0; // 32b
//        long aLong = 0L; // 64b
//
//        // Типы с плавающей точкой
//        float aFloat = 0.0F; // 32b
//        double aDouble = 0.0; // 64b
//
//        // Символьный тип
//        char aChar = 'a';
//
//        // Логический тип
//        boolean aBoolean = true / false; // истина / лож
//
//        // Строка (и бесконечность других объектных/ссылочных)
//        String aString = "Hello, world"; // строка
//
//        // Тип данных список строк
//        List<String> teacher = List.of("Aleksey", "Dmitri");
//        List<Integer> ages = List.of(20, 30);
//
//
//        // описываем пример чашки
////        class Cup {
////            String color = "gray";
////            int capacity = 250;
////            boolean hasHandle = true;
////        }
//
//        // Операторы
//
//        // Операторы присвоейний =,
//        String name = "Aleksey";
//
//        // Арифметический оператор + - / * : ++ --
//
//        System.out.println(4.0 + 3); // 7.0
//        System.out.println(4.0 - 3); // 1.0
//        System.out.println(4.0 * 3); // 12.0
//        System.out.println(4.0 / 3); // 1.33333333
//        System.out.println(4 / 3); // 1
//        System.out.println(5 / 3); // 1
//        System.out.println(5 % 3); // 2
//
//        int result = aInt + 1;
//        System.out.println(result); // 1
//
//        int result = ++aInt; // прибавляет еденицу
//        System.out.println(result); // 1
//
//        int result = aInt - 1;
//        System.out.println(result); // -1
//
//        int result = --aInt;
//        System.out.println(result); // -1
//
//        // Операторы сравнения < > >= <= != == возвращают boolean
//        System.out.println(3 > 2); //true
//        System.out.println(3 = 2); //false
//        System.out.println(3 != 2); //true
//        System.out.println(3 > 3); //false
//        System.out.println(3 >= 3); //true
//
//        String nameFirst = "Aleksey";
//        String nameSecond = "Aleksey";
//        System.out.println(nameFirst == nameSecond); // Нельзя так сравнивать строки
//        System.out.println(nameFirst.equals(nameSecond)); // Строки можно сравнивать так
//
//        // Логические операторы & | && || !
//        String nameMy = "Aleksey";
//        int age = 30;
//        System.out.println(nameMy.equals("Aleksey") && age == 35); // Итоговый результат true
//        System.out.println(nameMy.equals("Aleksey") && age = 36); // Итоговый результат false
//        System.out.println(nameMy.equals("Aleksey") & age = 36); // Итоговый результат false
//        System.out.println(nameMy.equals("Mihail") & age = 36); // Итоговый результат false
//
//        String nameMyne = null;
//        if (nameMyne != null && nameFirst.length() == 5){ // Программа не упала, но проверка не выполнена
//            System.out.println("Удача");
//        };
//
//        String nameMyneы = null;
//        if (nameMyneы != null & nameFirst.length() == 5){ // Программа упала
//            System.out.println("Удача");
//        };
//
//        System.out.println(nameMy.equals("Aleksey") && age || 30); // если хотя бы один результат true то будет true
//        System.out.println(nameMy.equals("Aleksey") && age || 35); // если хотя бы один результат true то будет true
//        System.out.println(!(nameMy.equals("Aleksey") && age || 35)); // ! превращаем результат в ложь
//
//
//        System.out.println(!(nameMy.equals("Aleksey"))); // Если не равно Алексею
//
//        // Оперытор instenceof
//
//        System.out.println(nameFirst instanceof String); // является ли эа переменная типом String (true)
//        System.out.println(!(nameFirst instanceof String)); // неявляется ли эа переменная типом String (false)
//
//        // Оператор тернарный
//
//        char sex = 'm';
//
//        String childName = sex == 'm'
//                ? "Valentin"
//                : "Valentina";
//
//
//        // Управляющая конструкция if если не нужно возвращать результат
//        if (sex == 'm') { // если пол мужской
//            childName = "Valentin"; // присваем имя Valentin
//        } else {  // иначе
//            childName = "Valentina"; // то присваемваем Valentina
//        }
//
//        // Можем сделать еще вот так в конструции if где можем вернуть что-то
//
//        if (sex == 'm') { // если пол мужской
//            System.out.println("Мальчик!!!"); // присваем  Мальчик
//        } else {  // иначе
//            System.out.println("Девочка"); // то присываеваем Девочка
//        }
//
//        // Конструкция if если нужно вернуть только (true)
//
//        if (sex == 'm') { // если пол мужской
//            childName = "Valentin"; // присваем имя Valentin
//        }
//
//        // Бывает и такое в кострукции if
//
//        if (sex == 'm') { // если пол мужской
//            childName = "Valentin"; // присваем имя Valentin
//        } else if (sex == 'w') {  // иначе если
//            childName = "Valentina"; // то присваемваем Valentina
//        } else { // тогда
//            System.out.println("((");
//        }
//
//
//        // Ключевое слово new для создание объектов значение которое хранит данные в классе
//
//        String name = new String("Aleksey");
//        String name = "Aleksey";
//
//
//
//
//
//
//    }
//
//}
