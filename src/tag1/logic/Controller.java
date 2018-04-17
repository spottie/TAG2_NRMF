package tag1.logic;

import tag1.tui.Presentation;

public class Controller {

    private final String WINROOM = "Name21";
    
    Dungeon dungeon = new Dungeon();
    Player player = new Player();
    Presentation tui = new Presentation();

    public void play() {
        startInit();
        player();
    }

    public void startInit() {
        player.setName(player.validatePlayerName(tui));
        tui.separator();
        tui.showPlayerInfo(player);
        tui.separator();
        tui.showGameInformation();
        tui.pressEnterToContinue();
        tui.separator();
        player.startGame(tui);
        tui.separator();
        player.setCurrentRoom(dungeon.createRoomsInDungeon());
        tui.createRoomsMessage();
        tui.separator();
        tui.showRoomInformation(player);
    }

    public void player() {
        while (true) {
            tui.separator();
            player.movePlayer(tui);
            tui.separator();
            tui.showRoomInformation(player);
            player.winGame(player, tui, WINROOM);
        }
    }

}
