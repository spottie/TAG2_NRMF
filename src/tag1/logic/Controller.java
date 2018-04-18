package tag1.logic;

import tag1.tui.Presentation;

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
            tui.inputCommandAllowed();
            //player.movePlayer(tui);
            tui.separator();
            String activeRoomInfo = player.getActiveRoom().toString();
            tui.showRoomInformation(activeRoomInfo);
            winGame();
        }
    }
    
    public void movePlayer(){
        
    }
    
    public void winGame() {
        if (player.getActiveRoom().getName().equals(WINROOM)) {
            tui.winGameMessage();
            System.exit(0);
        }
    }

}
