package com.example.lab1;
import java.util.Scanner;

public class Input {
    public static int getNumber(){
        System.out.println("Введите число");
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt())
            number = scanner.nextInt();
        else{
            System.out.println("Введите корректное число");
            getNumber();
        }
        return number;
    }
}
