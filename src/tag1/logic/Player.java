package tag1.logic;

import tag1.tui.Presentation;

public class Player {

    private String name;
    private int health = 100;
    private Room activeRoom;
    private boolean wrongDirection;
    private final String NORTH = "north";
    private final String SOUTH = "south";
    private final String EAST = "east";
    private final String WEST = "west";
    private final String START = "start";
    private final String HELP = "help";
    private final String QUIT = "quit";

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return activeRoom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentRoom(Room activeRoom) {
        this.activeRoom = activeRoom;
    }
    
    public void movePlayer(Presentation tui) {
        wrongDirection = true;

        while (wrongDirection) {

            String input = tui.inputCommandAllowed();

            switch (input) {
                case NORTH:
                    movePlayerCheckDirection(tui, activeRoom.getNorth());
                    break;
                case SOUTH:
                    movePlayerCheckDirection(tui, activeRoom.getSouth());
                    break;
                case EAST:
                    movePlayerCheckDirection(tui, activeRoom.getEast());
                    break;
                case WEST:
                    movePlayerCheckDirection(tui, activeRoom.getWest());
                    break;
                case HELP:
                    tui.showHelp();
                    break;
                case QUIT:
                    tui.quitGameMessage();
                    System.exit(0);
                    break;
                default:
                    tui.errorCommandAllowed();
                    break;
            }
        }
    }

    public void movePlayerCheckDirection(Presentation tui, Room room) {
        if (room == null) {
            wrongDirection = true;
            tui.errorWrongDirection();
        } else {
            activeRoom = room;
            wrongDirection = false;
        }
    }

    public String validatePlayerName(Presentation tui) {
        String input = tui.inputCreatePlayerName();

        while (input.isEmpty()) {
            tui.errorCreatePlayerName();
            input = tui.inputCreatePlayerName();
        }

        return input;
    }

    public void startGame(Presentation tui) {
        String input = tui.inputStartGameMessage();

        while (!input.equals(START)) {
            tui.errorStartGameMessage();
            input = tui.inputStartGameMessage();
        }
    }

    public void winGame(Player player, Presentation tui, String winRoom) {
        if (player.getCurrentRoom().getName().equals(winRoom)) {
            tui.winGameMessage();
            System.exit(0);
        }
    }

}