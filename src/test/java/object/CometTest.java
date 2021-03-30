package object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CometTest {

    NylanCat nylanCat = new NylanCat();
    Comet comet = new Comet(nylanCat);

    @Test
    public void sanityCheck(){
    }

    @Test
    public void setPointsUpdatesToTrue(){
        comet.setPointsEarned(true);
        boolean actual = comet.isPointsEarned();
        assertTrue(actual);
    }

    @Test
    public void isOverObstacleFalse(){
        boolean actual = comet.isOverObstacle();
        assertFalse(actual);
    }

    @Test
    public void isOverObstacleTrue(){
        comet.setX(-20);
        boolean actual = comet.isOverObstacle();
        assertTrue(actual);
    }

}