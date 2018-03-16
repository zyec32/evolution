import java.awt.*;

public class Prim {
    private PrimType type;
    private Chord chord;
    private Color color;
    World myWorld;

    Prim(int x, int y, PrimType type, World world){
        this.chord.x = x;
        this.chord.y = y;
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

    protected void moveTo(Chord newChord){
        myWorld.movePrim(chord.x, chord.y, newChord.x, newChord.y);
        chord = newChord;
    }

    public Color getColor() {
        return color;
    }
    public Chord getChord() {
        return chord;
    }
    public PrimType getType() {
        return type;
    }
}
