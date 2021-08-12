import javax.swing.*;

public class GameFrame extends JFrame {
    public static void main(String[] args) {
        new GameFrame();
    }
    GameFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new GamePanel());
        setVisible(true);
        pack();
    }
}
