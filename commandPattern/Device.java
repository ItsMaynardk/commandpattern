package commandPattern;

public interface Device {
    String turnOn();
    String turnOff();
    String increaseVolume();
    String decreaseVolume();
    String increaseTemperature();
    String decreaseTemperature();
    String increaseBrightness();
    String decreaseBrightness();
}