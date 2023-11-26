public class AirConditioner {
    private String brand;
    private int temperature;
    private boolean isOn;
    private int fanSpeed;
    private String mode;

    // Конструкторы
    public AirConditioner(String brand, int temperature, boolean isOn, int fanSpeed, String mode) {
        this.brand = brand;
        this.temperature = temperature;
        this.isOn = isOn;
        this.fanSpeed = fanSpeed;
        this.mode = mode;
    }

    public AirConditioner(String brand, int temperature) {
        this(brand, temperature, false, 0, "Normal");
    }

    public AirConditioner() {
        this("Unknown", 0);
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    // Переопределенные методы
    @Override
    public String toString() {
        return "AirConditioner{" +
                "brand='" + brand + '\'' +
                ", temperature=" + temperature +
                ", isOn=" + isOn +
                ", fanSpeed=" + fanSpeed +
                ", mode='" + mode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirConditioner that = (AirConditioner) o;
        return temperature == that.temperature &&
                isOn == that.isOn &&
                fanSpeed == that.fanSpeed;

    }

    // Другие методы
    public void increaseTemperature() {
        temperature++;
    }

    public void decreaseTemperature() {
        temperature--;
    }

    public void increaseFanSpeed() {
        fanSpeed++;
    }

    public void decreaseFanSpeed() {
        fanSpeed--;
    }
}

