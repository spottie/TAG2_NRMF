package tag1.logic;

import tag1.tui.Presentation;
import static tag1.tui.Presentation.EAST;
import static tag1.tui.Presentation.HELP;
import static tag1.tui.Presentation.NORTH;
import static tag1.tui.Presentation.QUIT;
import static tag1.tui.Presentation.SOUTH;
import static tag1.tui.Presentation.WEST;

public class Controller {

    private final String WINROOM = "Name21";
    
    Dungeon dungeon = new Dungeon();
    Player player = new Player();
    Presentation tui = new Presentation();

    public void play() {
        player();
        dungeon();
        information();
        start();
        game();
    }
    
    public void player(){
        tui.separator();
        String name = tui.inputCreatePlayerName();
        player.setName(name);
        tui.separator();
        String playerName = player.getName();
        tui.showPlayerInfo(playerName);
    }

    public void dungeon() {
        tui.separator();
        Room startroom = dungeon.createRoomsInDungeon();
        player.setActiveRoom(startroom);
        tui.createRoomsMessage();
        tui.separator();
        String activeRoomInfo = player.getActiveRoom().toString();
        tui.showRoomInformation(activeRoomInfo);
    }
    
    public void information(){
        tui.separator();
        tui.showGameInformation();
        tui.pressEnterToContinue();
    }
    
    public void start(){
        tui.separator();
        tui.inputStartGameMessage();
    }

    public void game() {
        while (true) {
            tui.separator();
            String inputCommand = tui.inputCommandAllowed();
            movePlayer(inputCommand);
            //player.movePlayer(tui);
            tui.separator();
            String activeRoomInfo = player.getActiveRoom().toString();
            tui.showRoomInformation(activeRoomInfo);
            winGame();
        }
    }
    
    public void movePlayer(String inputCommand){

        switch (inputCommand) {
            case NORTH:
                if(player.getActiveRoom().getNorth() == null){
                    tui.errorWrongDirection();
                }
                else {
                    player.setActiveRoom(player.getActiveRoom().getNorth());
                }
                break;
            case SOUTH:
                if(player.getActiveRoom().getSouth() == null){
                    tui.errorWrongDirection();
                }
                else {
                    player.setActiveRoom(player.getActiveRoom().getSouth());
                }
                break;
            case EAST:
                if(player.getActiveRoom().getEast() == null){
                    tui.errorWrongDirection();
                }
                else {
                    player.setActiveRoom(player.getActiveRoom().getEast());
                }
                break;
            case WEST:
                if(player.getActiveRoom().getWest() == null){
                    tui.errorWrongDirection();
                }
                else {
                    player.setActiveRoom(player.getActiveRoom().getWest());
                }
                break;
            case HELP:
                tui.showHelp();
                break;
            case QUIT:
                tui.quitGameMessage();
                System.exit(0);
                break;
            default:
                break;
        }
    }
    
    public void winGame() {
        if (player.getActiveRoom().getName().equals(WINROOM)) {
            tui.winGameMessage();
            System.exit(0);
        }
    }

}
