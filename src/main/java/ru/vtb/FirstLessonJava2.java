package ru.vtb;

public class FirstLessonJava2 {

    public static void main(String[] args) {
        MathOperation();
        OverFlow();
        LogicaOperations();
        OperationWithTypes();
        DivisiblityOfNumber();


    }

    private static void MathOperation() {
        int a = 33;
        int b = 21;

        System.out.println("Математические операции:");
        System.out.println("Сложение: " + (a + b));
        System.out.println("Вычитание: " + (a - b));
        System.out.println("Умножение: " + (a * b));
        System.out.println("Деление: " + (a / b));
        System.out.println("остаток от деления: " + (a % b));
    }

    private static void OverFlow() {
        int maxInit = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;

        System.out.println("Переполненние значений: ");
        System.out.println("Переполнение int при сложении: " + (maxInit + 1));
        System.out.println("Переполнение int при вычитании: "+ (minInt - 1));

    }

    private static void LogicaOperations() {
        boolean x = true;
        boolean y = false;

        System.out.println("Логические операции");
        System.out.println("x And y: " + (x && y));
        System.out.println("x OR y: " + (x || y));
        System.out.println("Not x: " + (!x));


        int age = 19;
        boolean isAudit = age <= 17;
        boolean hasWay = true;

        System.out.println("Купить себе бутылку винишка: " + (isAudit && hasWay));
    }

    private static void OperationWithTypes() {
        int inValue = 102;
        double doubleVal = 17.31;

        System.out.println("Комбинация типов (int и double)");
        System.out.println("Сложение: " + (inValue + doubleVal));
        System.out.println("Вычитаение: " + (inValue - doubleVal));
        System.out.println("Умножение: " + (inValue * doubleVal));
        System.out.println("Деление: " + (inValue / doubleVal));
    }

    private static void DivisiblityOfNumber() {
        int number = 27;

        System.out.println("Проверка делимости на числа");
        boolean divisiblyBy3 = (number % 3 == 0);
        boolean divisiblyBy5 = (number % 5 == 0);

        System.out.println("Число: " + number);
        System.out.println("Делится на 3? " + divisiblyBy3);
        System.out.println("Делится на 5? " + divisiblyBy5);
        System.out.println("Делится одновременно на 3 и 5? " + (divisiblyBy3 && divisiblyBy5));
    }

}
