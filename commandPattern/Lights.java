package commandPattern;

public class Lights implements Device {
    private int brightness = 50;

    public String turnOn() {
        return "Lights are on!";
    }

    public String turnOff() {
        return "Lights are off!";
    }

    public String increaseVolume() {
        return "Lights don't have volume control!";
    }

    public String decreaseVolume() {
        return "Lights don't have volume control!";
    }

    public String increaseTemperature() {
        return "Lights don't have temperature control!";
    }

    public String decreaseTemperature() {
        return "Lights don't have temperature control!";
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