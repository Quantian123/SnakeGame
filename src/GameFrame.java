import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener{
    public static Display display=new Display();
    private GamePanel gamePanel;
    private JButton resetButton=new JButton("RESET");

    public static void main(String[] args) {
        new GameFrame();
    }

    GameFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("SNAKE GAME!");
        setIconImage(new ImageIcon("Snake.png").getImage());

        resetButton.setBounds(Display.panelY*12,0,Display.panelY*3,Display.panelY);
        resetButton.setBackground(Color.orange);
        resetButton.setFont(new Font("Ink Free",Font.BOLD,25));
        resetButton.setFocusable(false);
        resetButton.setBorder(BorderFactory.createEmptyBorder());
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
            add(gamePanel,BorderLayout.CENTER);
            display.pause.setText("PRESS SPACE TO PAUSE");
            SwingUtilities.updateComponentTreeUI(this);
        }
    }
}
