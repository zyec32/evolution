import java.awt.*;

public class Prim {
    private int x;
    private int y;
    private Color color;
    World myWorld;

    Prim(int x, int y, Color color, World world){
        this.x = x;
        this.y = y;
        this.color = color;
        myWorld = world;
    }

    public void moveTo(int newX, int newY){
        myWorld.movePrime(x, y, newX, newY);
        x = newX;
        y = newY;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
