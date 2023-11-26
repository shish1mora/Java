package com.example.lab1;

public class Main {
    public static void main(String[] args) {
        int x = Input.getNumber();
        int y = Input.getNumber();
        while(x == 0 || y < 0){
            System.out.println("Неверный ввод данных");
            x = Input.getNumber();
            y = Input.getNumber();
        }
        double a = Calculate.calcA(x,y);
        System.out.printf("Значение a = %f при x = %d & y = %d",a,x,y);
        System.out.println();
        System.out.printf("Значение b = %f при x = %d & a = %f",
                Calculate.calcB(x, a), x, a);
    }
}
