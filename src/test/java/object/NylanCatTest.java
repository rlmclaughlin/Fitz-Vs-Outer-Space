package object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NylanCatTest {

    NylanCat nylanCat = new NylanCat();

    @Test
    public void sanityCheck(){
        NylanCat nylanCat = new NylanCat();
    }

    @Test
    public void jumpUpdatesSetYToNegativeFour(){
        nylanCat.jump();
        float expected = -4;
        float actual = nylanCat.getSpeedY();
        assertEquals(expected, actual);
    }

    @Test
    public void leaveOrbitUpdatesSetYToNegativeTen(){
        nylanCat.leaveOrbit();
        float expected = -10;
        float actual = nylanCat.getSpeedY();
        assertEquals(expected, actual);
    }

    @Test
    public void bounceUpdatesSetYToNegativeTwo(){
        nylanCat.bounce();
        float expected = -2;
        float actual = nylanCat.getSpeedY();
        assertEquals(expected, actual);
    }

}