package commandPattern;

public class PowerOn implements Command{

    private Tv tv;

    public PowerOn (Tv tv){
        this.tv = tv;

    }
    @Override
    public String execute() {
        return tv.turnOn();
    }
}
