package commandPattern;

public interface VolumeControlDevice {
    String increaseVolume();
    String decreaseVolume();
    int getCurrentVolume();
}
