package tag1.logic;

public abstract class Health_Potion extends Item {
    
    private int healthPotion;
    
    public Health_Potion(String name, int healtPotion) {
        super(name);
        this.healthPotion = healtPotion;
    }

    public void use(Player p) {
        
    }
    
}
