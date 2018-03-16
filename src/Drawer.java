import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {
    private int sizeW;
    private int sizeH;
    private int space;
    private int countW = 0;
    private int countH = 0;
    private Prim[][] matrix;

    Drawer(int sizeW, int sizeH, int space){
        super();
        this.sizeW = sizeW;
        this.sizeH = sizeH;
        this.space = space;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.black);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        for (int i = 0; i < countW; i++) {
            for (int j = 0; j < countH; j++) {
                g2d.setPaint(matrix[i][j].getColor());
                g2d.fillRect(i*(sizeW+space), j*(sizeH+space), sizeW, sizeH);
            }
        }
    }

    public void setCountW(int countW) {
        this.countW = countW;
    }

    public void setCountH(int countH) {
        this.countH = countH;
    }

    public void setMatrix(Prim[][] matrix) {
        this.matrix = matrix;
    }
}
