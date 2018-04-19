package tag1.logic;

import java.util.ArrayList;

public class Player {

    private String name;
    private int health = 100;
    private int damage = 1;
    private boolean correctRoom;
    private Room activeRoom;
    private ArrayList<Item> backpack = new ArrayList();

    public String getName() {
        return name;
    }

    public boolean isCorrectRoom() {
        return correctRoom;
    }

    public Room getActiveRoom() {
        return activeRoom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCorrectRoom(boolean correctRoom) {
        this.correctRoom = correctRoom;
    }

    public void setActiveRoom(Room activeRoom) {
        this.activeRoom = activeRoom;
    }

    public boolean movePlayer(Room room) {
        if (room == null) {
            return false;
        } else {
            activeRoom = room;
            correctRoom = true;
            return true;
        }
    }
    
    public void addItemToBackPack(Item item){
        if(item != null){
            backpack.add(item);
            activeRoom.setItemPickedUp(item);
        }
    }
    
    public void useItem(String input) {
        System.out.println(input);
        System.out.println(backpack);
        for (Item item1 : backpack) {
            
            if(item1.getName().equalsIgnoreCase(input)) {
                item1.use(this);
                if(backpack.size() == 1) {
                    backpack.clear();
                }
                    else {
                        backpack.remove(item1);
                System.out.println(health + " " +  damage);
        System.out.println(backpack); 
                }
            }
        }
    }

    public void increaseHealth(int healthPotion) {
        this.health += healthPotion;
    }

    public void increaseDamage(int damage) {
        this.damage += damage;
    }
    
    @Override
    public String toString() {
        if(backpack.isEmpty()){
            return "Player Backpack: No items";
        }
        else{
            String overview = "";
            for (int i = 0; i < backpack.size(); i++) {
                Item item = backpack.get(i);
                overview += " " + item.getName();
            }
            return "Player Backpack: " + overview;
        }
    }
}
