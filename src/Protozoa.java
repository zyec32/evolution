public class Protozoa extends Prim {
    private byte[] genome;

    Protozoa(int x, int y, World world){
        super(x, y, PrimType.PROTOZOA, world);
        genome = new byte[64];
    }

    private int lookAt(Direction direction){
        int lookX = super.getX();
        int lookY = super.getY();
        switch (direction){
            case UP:
                lookY--;
                break;
            case UP_RIGHT:
                lookX++;
                lookY--;
                break;
            case RIGHT:
                lookX++;
                break;
            case DOWN_RIGHT:
                lookX++;
                lookY++;
                break;
            case DOWN:
                lookY++;
                break;
            case DOWN_LEFT:
                lookX--;
                lookY++;
                break;
            case LEFT:
                lookX--;
                break;
            case UP_LEFT:
                lookX--;
                lookY--;
                break;
        }
        return myWorld.typeAt(lookX, lookY).ordinal();
    }

}
