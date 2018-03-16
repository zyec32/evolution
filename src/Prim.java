import java.awt.*;

public class Prim {
    private PrimType type;
    private int x;
    private int y;
    private Color color;
    World myWorld;

    Prim(int x, int y, PrimType type, World world){
        this.x = x;
        this.y = y;
        this.type = type;
        switch (this.type){
            case SPACE:
                color = Color.gray;
                break;
            case WALL:
                color = Color.blue;
                break;
            case PROTOZOA:
                color = Color.magenta;
                break;
            case FOOD:
                color = Color.green;
                break;
            case POISON:
                color = Color.RED;
                break;
                default:
                    color = Color.white;
                    break;
        }
        myWorld = world;
    }

    protected void moveTo(int newX, int newY){
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
    public PrimType getType() {
        return type;
    }
}
