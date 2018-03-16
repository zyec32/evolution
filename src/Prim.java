import java.awt.*;

public class Prim {
    private Color color;
    World myWorld;

    Prim(Color color, World world){
        this.color = color;
        myWorld = world;
    }

    public Color getColor() {
        return color;
    }
}
