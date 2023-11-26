public class Main {
    public static void main(String[] args) {
        // Создание объектов и использование методов
        Television television = new Television("Samsung", 55, true, 50, 5);
        AirConditioner airConditioner = new AirConditioner("LG", 24, true, 3, "Cool");
        WashingMachine washingMachine = new WashingMachine("Whirlpool", 10, true, 0, "Normal");

        // Вывод информации о созданных объектах
        System.out.println(television);
        System.out.println(airConditioner);
        System.out.println(washingMachine);
    }
}
