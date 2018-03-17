public class Chord {
    public int x, y;

    Chord(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Chord moveTo(Direction direction, Chord chord){
        switch (direction){
            case UP:
                chord.y--;
                break;
            case UP_RIGHT:
                chord.x++;
                chord.y--;
                break;
            case RIGHT:
                chord.x++;
                break;
            case DOWN_RIGHT:
                chord.x++;
                chord.y++;
                break;
            case DOWN:
                chord.y++;
                break;
            case DOWN_LEFT:
                chord.x--;
                chord.y++;
                break;
            case LEFT:
                chord.x--;
                break;
            case UP_LEFT:
                chord.x--;
                chord.y--;
                break;
        }
        return chord;
    }
}
