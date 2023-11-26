public class Television {
    private String brand;
    private int screenSize;
    private boolean isSmartTV;
    private int volumeLevel;
    private int channel;

    // Конструкторы
    public Television(String brand, int screenSize, boolean isSmartTV, int volumeLevel, int channel) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.isSmartTV = isSmartTV;
        this.volumeLevel = volumeLevel;
        this.channel = channel;
    }

    public Television(String brand, int screenSize) {
        this(brand, screenSize, false, 0, 1);
    }

    public Television() {
        this("Unknown", 0);
    }

    // Геттеры и сеттеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public boolean isSmartTV() {
        return isSmartTV;
    }

    public void setSmartTV(boolean smartTV) {
        isSmartTV = smartTV;
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public void setVolumeLevel(int volumeLevel) {
        this.volumeLevel = volumeLevel;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    // Переопределенные методы
    @Override
    public String toString() {
        return "Television{" +
                "brand='" + brand + '\'' +
                ", screenSize=" + screenSize +
                ", isSmartTV=" + isSmartTV +
                ", volumeLevel=" + volumeLevel +
                ", channel=" + channel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Television that = (Television) o;
        return screenSize == that.screenSize &&
                isSmartTV == that.isSmartTV &&
                volumeLevel == that.volumeLevel &&
                channel == that.channel;

    }

    // Другие методы
    public void increaseVolume() {
        volumeLevel++;
    }

    public void decreaseVolume() {
        volumeLevel--;
    }

    public void changeChannel(int channel) {
        this.channel = channel;
    }
}
