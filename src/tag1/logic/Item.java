package tag1.logic;

public abstract class Item {

    private String name;

    public Item(String name) {
        this.name = name;
    }
    
    public abstract void use();
 
}
