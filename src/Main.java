import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Evolution");
        Drawer drawer = new Drawer();
        frame.add(drawer);
        frame.setSize(100, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
