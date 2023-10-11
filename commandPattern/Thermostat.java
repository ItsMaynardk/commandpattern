package commandPattern;

public class Thermostat implements Device {
    private int temperature = 22;
    private int brightness = 50;

    public String turnOn() {
        return "Thermostat is activated!";
    }

    public String turnOff() {
        return "Thermostat is deactivated!";
    }

    public String increaseVolume() {
        return "Thermostat doesn't have volume control!";
    }

    public String decreaseVolume() {
        return "Thermostat doesn't have volume control!";
    }

    public String increaseTemperature() {
        temperature++;
        return "Temperature increased to " + temperature + "°C";
    }

    public String decreaseTemperature() {
        temperature--;
        return "Temperature decreased to " + temperature + "°C";
    }

    public int getCurrentTemperature() {
        return temperature;
    }

    public String decreaseBrightness() {
        if (brightness > 0) {
            brightness--;
        }
        return "Brightness decreased to " + brightness + "%";
    }

    public String increaseBrightness() {
        if (brightness < 100) {
            brightness++;
        }
        return "Brightness increased to " + brightness + "%";
    }
}