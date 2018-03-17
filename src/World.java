import java.awt.*;
import java.util.ArrayList;

public class World {
    private static final int sleaper = 100;
    private int countW;
    private int countH;
    private Prim[][] worldMatrix;
    private ArrayList<Protozoa> population;
    private Drawer drawer;

    World(int countW, int countH, Drawer drawer) throws InterruptedException {
        this.countW = countW;
        this.countH = countH;
        this.drawer = drawer;
        // set matrix
        worldMatrix = new Prim[countW][countH];
        for(int i = 0; i < countW; i++){
            for(int j = 0; j < countH; j++){
                if(i == 0 || j == 0 || i == countW-1 || j == countH-1){
                    createPrimAt(i, j, PrimType.WALL);
                } else {
                    createPrimAt(i, j, PrimType.SPACE);
                }
            }
        }
        // set first population
        population = new ArrayList<Protozoa>();
        createProtozoaAt(6, 6);
        createProtozoaAt(10,11);
        // set food
        createPrimAt(12, 10, PrimType.FOOD);
        createPrimAt(12, 11, PrimType.FOOD);
        createPrimAt(12, 12, PrimType.FOOD);
        createPrimAt(10, 12, PrimType.FOOD);
        createPrimAt(9, 12, PrimType.FOOD);
        createPrimAt(8, 12, PrimType.FOOD);
        createPrimAt(7, 12, PrimType.FOOD);
        createPrimAt(6, 12, PrimType.FOOD);
        createPrimAt(6, 10, PrimType.FOOD);
        createPrimAt(6, 11, PrimType.FOOD);
        // set drawer
        this.drawer.setCountH(this.countH);
        this.drawer.setCountW(this.countW);
        this.drawer.setMatrix(worldMatrix);
        this.drawer.repaint();

        lifeCycle();
    }

    private void createPrimAt(int x, int y, PrimType type){
        worldMatrix[x][y] = new Prim(x, y, type, this);
    }

    public void createProtozoaAt(int x, int y){
        worldMatrix[x][y] = new Protozoa(x, y, this);
        population.add((Protozoa) worldMatrix[x][y]);
    }

    public void movePrim(int x, int y, int newX, int newY){
        if (!(x == newX && y == newY)) {
            worldMatrix[newX][newY] = worldMatrix[x][y];
            createPrimAt(x, y, PrimType.SPACE);
        }
    }

    public void deletePrimAt(int x, int y){
        createPrimAt(x, y, PrimType.SPACE);
    }

    public void movePoisonToFood(int x, int y){
        createPrimAt(x, y, PrimType.FOOD);
    }

    public void deleteProtozoa(Protozoa protozoa){
        population.remove(protozoa);
        createPrimAt(protozoa.getChord().x, protozoa.getChord().y, PrimType.SPACE);
    }

    private void lifeCycle() throws InterruptedException {
        while (true) {
            Thread.sleep(sleaper);
            for (int i = 0; i < population.size(); i++) {
                population.get(i).live();
                population.get(i).execute();
            }
            drawer.setMatrix(worldMatrix);
            drawer.repaint();
        }
    }

    public PrimType typeAt(Chord chord){
        return worldMatrix[chord.x][chord.y].getType();
    }


}
