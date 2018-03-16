public class Chord {
    public int x, y;

    Chord(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Chord moveTo(Direction direction){
        switch (direction){
            case UP:
                y--;
                break;
            case UP_RIGHT:
                x++;
                y--;
                break;
            case RIGHT:
                x++;
                break;
            case DOWN_RIGHT:
                x++;
                y++;
                break;
            case DOWN:
                y++;
                break;
            case DOWN_LEFT:
                x--;
                y++;
                break;
            case LEFT:
                x--;
                break;
            case UP_LEFT:
                x--;
                y--;
                break;
        }
        return this;
    }
}
