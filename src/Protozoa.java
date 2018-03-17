import java.util.ArrayList;
import java.util.Random;

public class Protozoa extends Prim {
    private static final int matIter = 10;
    private static final int maxCounter = 64;
    private byte[] genom;
    private byte programmCounter;
    private int hp;
    private int lifeSize;
    private boolean isDead;

    Protozoa(int x, int y, World world){
        super(x, y, PrimType.PROTOZOA, world);
        genom = new byte[maxCounter];
        generateGenom();
        programmCounter = 0;
        hp = 50;
        lifeSize = 0;
        isDead = false;
    }
    Protozoa(Protozoa protozoa){
        super(protozoa.getChord().x, protozoa.getChord().y, PrimType.PROTOZOA, protozoa.getWorld());
        genom = protozoa.genom;
        programmCounter = 0;
        hp = 50;
        lifeSize = 0;
        isDead = false;
    }
    Protozoa(Protozoa protozoa, byte[] genom){
        super(protozoa.getChord().x, protozoa.getChord().y, PrimType.PROTOZOA, protozoa.getWorld());
        this.genom = genom;
        programmCounter = 0;
        hp = 50;
        lifeSize = 0;
        isDead = false;
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
        lifeSize++;
        if (hp <= 0){
            die();
        }
    }

    private void die(){
        isDead = true;
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

    private byte[] mutation(){
        Random rnd = new Random();
        genom[rnd.nextInt(maxCounter)] = (byte)rnd.nextInt(16);
        return genom;
    }

    public ArrayList<Protozoa> child() {
        ArrayList<Protozoa> childs = new ArrayList<Protozoa>();
        childs.add(new Protozoa(this));
        childs.add(new Protozoa(this));
        childs.add(new Protozoa(this));
        childs.add(new Protozoa(this, mutation()));
        return childs;
    }

    public int getHp() {
        return hp;
    }

    public byte[] getGenom() {
        return genom;
    }

    public int getLifeSize() {
        return lifeSize;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public World getWorld(){
        return myWorld;
    }
}
