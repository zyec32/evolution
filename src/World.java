import java.awt.*;

public class World {
    private int countW;
    private int countH;
    private Prim[][] worldMatrix;
    private Drawer drawer;

    World(int countW, int countH, Drawer drawer){
        this.countW = countW;
        this.countH = countH;
        this.drawer = drawer;
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
        this.drawer.setCountH(this.countH);
        this.drawer.setCountW(this.countW);
        this.drawer.setMatrix(worldMatrix);
        this.drawer.repaint();
    }

    void createPrimAt(int x, int y, Color color){
        worldMatrix[x][y] = new Prim(color, this);
    }


}
