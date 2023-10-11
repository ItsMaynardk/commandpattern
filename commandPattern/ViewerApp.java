package commandPattern;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ViewerApp {

    public static void main(String[] args) {
        Map<Integer, Device> devices = new HashMap<>();
        devices.put(1, new Tv());
        devices.put(2, new Lights());
        devices.put(3, new Thermostat());
        devices.put(4, new MusicPlayer());

        RemoteControl rc = new RemoteControl();
        rc.addCommand(1, new PowerOn((Tv) devices.get(1)));
        rc.addCommand(2, new PowerOff((Tv) devices.get(1)));
        rc.addCommand(3, () -> devices.get(3).increaseTemperature());
        rc.addCommand(4, () -> devices.get(3).decreaseTemperature());
        rc.addCommand(5, () -> devices.get(1).increaseVolume());
        rc.addCommand(6, () -> devices.get(1).decreaseVolume());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Smart Home Automation!\n");

        while (true) {
            System.out.println("Available Devices:");
            devices.forEach((key, value) -> System.out.println(key + ". " + value.getClass().getSimpleName()));
            System.out.println("Exit");

            System.out.print("Enter the number of the device you want to control (or 'exit' to quit): ");

            String deviceInput = scanner.nextLine();

            if (deviceInput.equals("exit")) {
                System.out.println("\nShutting down..");
                break;
            }

            int selectedDeviceNumber;
            try {
                selectedDeviceNumber = Integer.parseInt(deviceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid command number. Please enter a valid command number.");
                continue;
            }

            Device selectedDevice = devices.get(selectedDeviceNumber);

            if (selectedDevice == null) {
                System.out.println("Invalid command number. Please enter a valid command number.");
                continue;
            }

            System.out.println("\nYou've selected " + selectedDevice.getClass().getSimpleName() + ".\n");

            while (true) {
                displayAvailableCommands(selectedDevice);

                System.out.println("Exit");
                System.out.println();
                System.out.print("Enter a command: ");

                String commandInput = scanner.nextLine();

                if (commandInput.equals("Exit")) {
                    System.out.println("\nReturning to device selection..");
                    break;
                }

                int selectedCommandNumber;
                try {
                    selectedCommandNumber = Integer.parseInt(commandInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid command number. Please enter a valid command number.");
                    continue;
                }

                if (selectedCommandNumber < 1 || selectedCommandNumber > 11) {
                    System.out.println("Invalid command number. Please enter a valid command number.");
                    continue;
                }

                Command selectedCommand = rc.getCommand(selectedCommandNumber);

                if (selectedCommand == null) {
                    System.out.println("Invalid command number. Please enter a valid command number.");
                    continue;
                }

                String result = selectedDevice.getClass().getSimpleName() + ": " + selectedCommand.execute();

                if (selectedDevice instanceof Thermostat) {
                    result += " Current Temperature: " + ((Thermostat) selectedDevice).getCurrentTemperature() + "°C";
                }

                System.out.println(result);

                if (selectedCommandNumber == 2) {
                    System.out.println("\nReturning to device selection..");
                    break;
                }
            }
        }
    }

    private static void displayAvailableCommands(Device selectedDevice) {
        System.out.println();
        System.out.println("Available Commands:");
        System.out.println("1. Turn On");
        System.out.println("2. Turn Off");
        System.out.println("3. Increase Temperature");
        System.out.println("4. Decrease Temperature");
        System.out.println("5. Increase Volume");
        System.out.println("6. Decrease Volume");

        if (selectedDevice instanceof Lights) {
            System.out.println("7. Increase Brightness");
            System.out.println("8. Decrease Brightness");
        }

        if (selectedDevice instanceof MusicPlayer) {
            System.out.println("9. Play Playlist");
            System.out.println("10. Stop Playlist");
        }
    }
}