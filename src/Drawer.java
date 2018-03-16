import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {

    Drawer(){
        super();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setPaint(Color.gray);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
