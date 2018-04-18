package tag1.logic;

public abstract class Axe extends Item{
    
    private int damage;
    
    public Axe(String name, int damage) {
        super(name);
        this.damage = damage;
    }
    
    public void use(Player p, int damage) {
        p.increaseDamage(damage);
    }
    
    
}
