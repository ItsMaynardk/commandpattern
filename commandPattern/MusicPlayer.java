package commandPattern;

public class MusicPlayer implements Device, PlaylistControlDevice {
    private int volume = 50;
    private boolean playlistPlaying = false;

    public String turnOn() {
        return "Music Player is on!";
    }

    public String turnOff() {
        stopPlaylist();
        return "Music Player is off.";
    }

    public String increaseVolume() {
        if (volume < 100) {
            volume++;
        }
        return "Volume increased to " + volume + "%";
    }

    public String decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
        return "Volume decreased to " + volume + "%";
    }

    public String increaseTemperature() {
        return "Music Player doesn't have temperature control!";
    }

    public String decreaseTemperature() {
        return "Music Player doesn't have temperature control!";
    }

    public String decreaseBrightness() {
        return "Music Player doesn't have brightness control!";
    }

    public String increaseBrightness() {
        return "Music Player doesn't have brightness control!";
    }

    public String playPlaylist() {
        if (!playlistPlaying) {
            playlistPlaying = true;
            return "Playlist is now playing.";
        } else {
            return "Playlist is already playing.";
        }
    }

    public String stopPlaylist() {
        if (playlistPlaying) {
            playlistPlaying = false;
            return "Playlist stopped.";
        } else {
            return "No playlist is currently playing.";
        }
    }
}