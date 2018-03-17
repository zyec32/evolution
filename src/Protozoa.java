import java.util.Random;

public class Protozoa extends Prim {
    private static final int matIter = 10;
    private static final int maxCounter = 64;
    private byte[] genom;
    private byte programmCounter;
    private int hp;

    Protozoa(int x, int y, World world){
        super(x, y, PrimType.PROTOZOA, world);
        genom = new byte[maxCounter];
        generateGenom();
        programmCounter = 0;
        hp = 50;
    }
    Protozoa(Protozoa protozoa, World world){
        super(protozoa.getChord().x, protozoa.getChord().y, PrimType.PROTOZOA, world);

    }

    public void live(){
        for (int i = 0; i < matIter; i++){
            switch (genom[programmCounter]){
                case 0:
                    addToCounter(1);
                    addToCounter(move(Direction.values()[genom[programmCounter]%Direction.values().length]) + 1);
                    return;
                case 1:
                    addToCounter(1);
                    addToCounter(lookAt(Direction.values()[genom[programmCounter]%Direction.values().length]) + 1);
                    break;
                case 2:
                    addToCounter(1);
                    addToCounter(eatAt(Direction.values()[genom[programmCounter]%Direction.values().length]) + 1);
                    return;
                default:
                    addToCounter(genom[programmCounter]);
                    break;
            }
        }
    }

    public void execute(){
        hp--;
        if (hp <= 0){
            die();
        }
    }

    private void die(){
        myWorld.deleteProtozoa(this);
        myWorld.createProtozoaAt(super.getChord().x, super.getChord().y);
    }

    private void addToCounter(int add){
        programmCounter += add;
        while (programmCounter >= maxCounter) {
            programmCounter -= maxCounter;
        }
    }

    private int move(Direction direction){
        Chord moveChord = super.getChord();
        moveChord = Chord.moveTo(direction, moveChord);
        PrimType moveType = myWorld.typeAt(moveChord);
        switch (moveType){
            case POISON:
                die();
                break;
            case SPACE:
                super.moveTo(moveChord);
                break;
        }
        return moveType.ordinal();
    }

    private int lookAt(Direction direction){
        Chord lookChord = super.getChord();
        lookChord = Chord.moveTo(direction, lookChord);
        return myWorld.typeAt(lookChord).ordinal();
    }

    private int eatAt(Direction direction){
        Chord eatChord = super.getChord();
        eatChord = Chord.moveTo(direction, eatChord);
        PrimType eatType = myWorld.typeAt(eatChord);
        switch (eatType){
            case FOOD:
                eat(eatChord);
                break;
            case POISON:
                movePoisonToFood(eatChord);
                break;
        }
        return eatType.ordinal();
    }

    private void eat(Chord chord){
        hp += 10;
        myWorld.deletePrimAt(chord.x, chord.y);
    }

    private void movePoisonToFood(Chord chord){
        myWorld.movePoisonToFood(chord.x, chord.y);
    }

    private void generateGenom(){
        Random rnd = new Random();
        for (int i = 0; i < maxCounter; i++){
            genom[i] = (byte)rnd.nextInt(16);
        }
    }

    public int getHp() {
        return hp;
    }

}
