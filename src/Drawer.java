import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {
    private int sizeW;
    private int sizeH;
    private int space;

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
    }
}
