import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener{
    static Display display=new Display();
    GamePanel gamePanel;
    JButton resetButton=new JButton("RESET");
    public static void main(String[] args) {
        new GameFrame();
    }
    GameFrame(){
        setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("SNAKE GAME!");
        setIconImage(new ImageIcon("Snake.png").getImage());

        resetButton.setBounds(Display.panelY*4,0,Display.panelY*2,Display.panelY);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        display.add(resetButton);

        add(gamePanel=new GamePanel(), BorderLayout.CENTER);
        add(display,BorderLayout.NORTH);
        setVisible(true);
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton) {
            remove(gamePanel);
            gamePanel = new GamePanel();
            add(gamePanel);
            SwingUtilities.updateComponentTreeUI(this);
        }
    }
}
