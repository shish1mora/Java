public class WashingMachine {
    private String brand;
    private int capacity;
    private boolean isOn;
    private int waterLevel;
    private String currentProgram;

    // Конструкторы
    public WashingMachine(String brand, int capacity, boolean isOn, int waterLevel, String currentProgram) {
        this.brand = brand;
        this.capacity = capacity;
        this.isOn = isOn;
        this.waterLevel = waterLevel;
        this.currentProgram = currentProgram;
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public String getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(String currentProgram) {
        this.currentProgram = currentProgram;
    }

    // Переопределенные методы
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WashingMachine that = (WashingMachine) o;
        return capacity == that.capacity &&
                isOn == that.isOn &&
                waterLevel == that.waterLevel &&
                brand.equals(that.brand) &&
                currentProgram.equals(that.currentProgram);
    }



    @Override
    public String toString() {
        return "WashingMachine{" +
                "brand='" + brand + '\'' +
                ", capacity=" + capacity +
                ", isOn=" + isOn +
                ", waterLevel=" + waterLevel +
                ", currentProgram='" + currentProgram + '\'' +
                '}';
    }

    // Другие методы
    public void start() {
        isOn = true;
        System.out.println("Washing machine started.");
    }

    public void stop() {
        isOn = false;
        System.out.println("Washing machine stopped.");
    }

    public void increaseWaterLevel() {
        waterLevel++;
        System.out.println("Water level increased to " + waterLevel);
    }

    public void decreaseWaterLevel() {
        if (waterLevel > 0) {
            waterLevel--;
            System.out.println("Water level decreased to " + waterLevel);
        } else {
            System.out.println("Water level is already at minimum.");
        }
    }
}

