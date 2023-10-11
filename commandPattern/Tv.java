package commandPattern;

public class Tv implements Device {

    private boolean isOn = false;
    private int volume = 0;
    private int brightness = 50; // Initial brightness level

    public String turnOn() {
        if (!isOn) {
            isOn = true;
            return "TV is turned on.";
        } else {
            return "TV is already on.";
        }
    }

    public String turnOff() {
        if (isOn) {
            isOn = false;
            return "TV is turned off.";
        } else {
            return "TV is already off.";
        }
    }

    public String increaseVolume() {
        if (isOn && volume < 100) {
            volume++;
            return "Volume increased to " + volume;
        } else {
            return "Volume cannot be increased.";
        }
    }

    public String decreaseVolume() {
        if (isOn && volume > 0) {
            volume--;
            return "Volume decreased to " + volume;
        } else {
            return "Volume cannot be decreased.";
        }
    }

    public int getCurrentVolume() {
        return volume;
    }

    public String increaseBrightness() {
        if (isOn && brightness < 100) {
            brightness++;
            return "Brightness increased to " + brightness + "%";
        } else {
            return "Brightness cannot be increased.";
        }
    }

    public String decreaseBrightness() {
        if (isOn && brightness > 0) {
            brightness--;
            return "Brightness decreased to " + brightness + "%";
        } else {
            return "Brightness cannot be decreased.";
        }
    }

    @Override
    public String increaseTemperature() {
        return "TV does not have temperature control.";
    }

    @Override
    public String decreaseTemperature() {
        return "TV does not have temperature control.";
    }
}