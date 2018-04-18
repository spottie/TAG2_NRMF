package tag1.tui;

import java.io.IOException;
import java.util.Scanner;

public class Presentation {

    Scanner scan = new Scanner(System.in);

    //System
    public void separator() {
        System.out.println("****************************");
    }

    //System
    public void pressEnterToContinue() {
        System.out.println("Press 'Enter' to continue...");
        try {
            System.in.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Player
    public String inputCreatePlayerName() {
        String input = "";

        while (input.isEmpty()) {
            System.out.println("Please enter your playername: ");
            input = scan.nextLine();

            if (input.isEmpty()) {
                System.out.println("Invalid input. Must not be empty!");
            }
        }

        return input;
    }

    //Player
    public void showPlayerInfo(String playerName) {
        System.out.println("Lets begin the game " + playerName + "!");
    }

    //Game
    public void inputStartGameMessage() {
        String input = "";
        String start = "start";

        while (!input.equals(start)) {
            System.out.println("Type 'start' when you're ready to start the game! ");
            input = scan.nextLine();
            
            if (!input.equals(start)) {
                System.out.println("Invalid input. Type 'start'!");
            }
        }
    }

    //Game
    public void winGameMessage() {
        System.out.println("Congratz, you reched the end of the dungeon! ");
    }

    //Game
    public void quitGameMessage() {
        System.out.println("Quitting game!");
    }

    //Game
    public void showGameInformation() {
        System.out.println("THE DUNGEON GAME...\nIn order to win the game, you must navigate through the dungeon and reach the final boss at room (21).\nYou will need to use the console while playing.\nThe directions you can move ingame is 'north', 'south', 'east' and 'west'.\nYou start at 100 health.\nWrite 'help' for further instructions.\nGood luck fellow!");
    }

    //Game
    public void showGameCommands() {
        System.out.println("Type 'north' in order to navigate in the dungeon!");
        System.out.println("Type 'south' in order to navigate in the dungeon!");
        System.out.println("Type 'east' in order to navigate in the dungeon!");
        System.out.println("Type 'west' in order to navigate in the dungeon!");
        System.out.println("Type 'quit' if you want to stop the game!");
        System.out.println("Type 'help' for having instructions!");
        System.out.println("Type 'start' to start the game!");
    }

    //Help
    public void showHelp() {
        System.out.println("Select one of the options below: ");
        System.out.println("Type '1' for game information ");
        System.out.println("Type '2' for game commands ");
        switch (scan.nextLine()) {
            case "1":
                showGameInformation();
                pressEnterToContinue();
                break;
            case "2":
                showGameCommands();
                pressEnterToContinue();
                break;
            default:
                showGameCommands();
                pressEnterToContinue();
                break;
        }
    }

    //Dungeon
    public void createRoomsMessage() {
        System.out.println("Rooms is now created in the dungeon!");
    }

    //Room
    public void showRoomInformation(String activeRoomInfo) {
        System.out.println(activeRoomInfo);
    }

    //Command
    public String inputCommandAllowed() {
        System.out.println("Type direction in order to move in the dungeon: ");
        return scan.nextLine();
    }

    //Command
    public void errorCommandAllowed() {
        System.out.println("Invalid input. You can type 'help' for instructions!");
    }

    //Navigate
    public void errorWrongDirection() {
        System.out.println("Wrong direction! Try again!");
    }

}
