import java.awt.*;

public class World {
    private static final int sleaper = 1000;
    private int countW;
    private int countH;
    private Prim[][] worldMatrix;
    private Prim[] population;
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
                    createPrimAt(i, j, Color.blue);
                } else {
                    createPrimAt(i, j, Color.gray);
                }
            }
        }
        // set first population
        population = new Prim[1];
        createPrimAt(6, 6, Color.magenta);
        population[0] = worldMatrix[6][6];
        // set drawer
        this.drawer.setCountH(this.countH);
        this.drawer.setCountW(this.countW);
        this.drawer.setMatrix(worldMatrix);
        this.drawer.repaint();

        lifeCycle();
    }

    private void createPrimAt(int x, int y, Color color){
        worldMatrix[x][y] = new Prim(x, y, color, this);
    }

    void movePrime(int x, int y, int newX, int newY){
        if (x != newX && y != newY) {
            worldMatrix[newX][newY] = worldMatrix[x][y];
            createPrimAt(x, y, Color.gray);
        }
    }

    private void lifeCycle() throws InterruptedException {
        while (true) {
            Thread.sleep(sleaper);
            for (int i = 0; i < population.length; i++) {
                population[i].moveTo(10, 10);
            }
            drawer.repaint();
        }
    }


}
