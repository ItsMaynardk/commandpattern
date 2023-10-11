package commandPattern;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private Map<Integer, Command> commands;

    public RemoteControl() {
        commands = new HashMap<>();
    }

    public void addCommand(int commandNumber, Command command) {
        commands.put(commandNumber, command);
    }

    public Command getCommand(int commandNumber) {
        return commands.get(commandNumber);
    }
}