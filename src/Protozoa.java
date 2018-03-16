public class Protozoa extends Prim {
    private byte[] genome;

    Protozoa(int x, int y, World world){
        super(x, y, PrimType.PROTOZOA, world);
        genome = new byte[64];
    }

    private int move(Direction direction){
        Chord moveChord = super.getChord().moveTo(direction);
        PrimType moveType = myWorld.typeAt(moveChord);
        switch (moveType){
            case POISON:
                //TODO die
                break;
            case SPACE:
                super.moveTo(moveChord);
                break;
        }
        return moveType.ordinal();
    }

    private int lookAt(Direction direction){
        Chord lookChord = super.getChord().moveTo(direction);
        return myWorld.typeAt(lookChord).ordinal();
    }

    private int eatAt(Direction direction){
        Chord eatChord = super.getChord().moveTo(direction);
        PrimType eatType = myWorld.typeAt(eatChord);
        switch (eatType){
            case FOOD:
                //TODO eat
                break;
            case POISON:
                //TODO move to food
                break;
        }
        return eatType.ordinal();
    }


}
