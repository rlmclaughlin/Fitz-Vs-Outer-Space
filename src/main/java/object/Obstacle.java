package object;

import java.awt.*;

public abstract class Obstacle {
    public abstract Rectangle getBound();
    public abstract void draw(Graphics graphics);
    public abstract void update();
    public abstract boolean isOutOfScreen();
    public abstract boolean isOverObstacle();
    public abstract boolean isPointsEarned();
    public abstract void setPointsEarned(boolean isPointsEarned);
}
