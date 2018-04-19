
package tag1.logic;

import static org.junit.Assert.*;
import org.junit.Test;

public class Axe_Test {
    
    @Test
    public void testUseAxe() {
        //Arrange
        Item item = new Axe("Axe");
        Player player = new Player(); 
        int expectedDamageResult = 26;
        //Act
        item.use(player);
        //Assert
        assertEquals(expectedDamageResult, player.getDamage());
    }
}