package object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UFOTest {
    NylanCat nylanCat = new NylanCat();
    UFO ufo = new UFO(nylanCat);

    @Test
    public void sanityCheck(){
         UFO ufo = new UFO(nylanCat);
    }

    @Test
    public void isPointsEarnedFalse(){
        boolean actual = ufo.isPointsEarned();
        assertFalse(actual);
    }

    @Test
    public void isUfoOutOfTheScreenTrue(){
        boolean actual = ufo.isOutOfScreen();
        assertTrue(actual);
    }

    @Test
    public void isNyanCatNotOverTheUfoObstacle(){
        boolean actual = ufo.isOverObstacle();
        assertFalse(actual);
    }
}