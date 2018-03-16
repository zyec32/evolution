import javax.swing.*;

public class Main {
    private static final int startW = 16;
    private static final int startH = 38;
    private static final int sizeW = 15;
    private static final int sizeH = 15;
    private static final int space = 1;
    private static final int countW = 15;
    private static final int countH = 15;

    public static void main(String[] args){
        JFrame frame = new JFrame("Evolution");
        Drawer drawer = new Drawer(sizeW, sizeH, space);
        frame.add(drawer);
        frame.setSize(startW+countW*(sizeW+ space), startH+countH*(sizeH+ space));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        World world = new World(countW, countH, drawer);
    }
}
