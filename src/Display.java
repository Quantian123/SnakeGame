import javax.swing.*;
import java.awt.*;

public class Display extends JPanel{
    JLabel counter=new JLabel();
    JLabel apple=new JLabel();
    JLabel pause=new JLabel();

    int panelX=GamePanel.GAME_WIDTH;
    static int panelY=GamePanel.GAME_HEIGHT/10;
    final ImageIcon APPLE_PNG = new ImageIcon(new ImageIcon("Apple.png")
            .getImage().getScaledInstance(panelY, panelY, Image.SCALE_SMOOTH));

    Display(){
        setLayout(null);
        setPreferredSize(new Dimension(panelX,panelY));
        setBackground(Color.lightGray);

        pause.setFont(new Font("Ink Free",Font.BOLD,25));
        pause.setBackground(Color.orange);
        pause.setOpaque(true);
        pause.setBounds(panelY*3,0,panelY*9,panelY);
        pause.setHorizontalAlignment(SwingUtilities.CENTER);
        pause.setText("PRESS SPACE TO PAUSE");
        add(pause);

        apple.setBounds(panelY*2,0,panelY,panelY);
        apple.setOpaque(true);
        apple.setBackground(Color.orange);
        apple.setIcon(APPLE_PNG);
        add(apple);

        counter.setBounds(0,0,panelY*2,panelY);
        counter.setOpaque(true);
        counter.setBackground(Color.orange);
        counter.setFont(new Font("Ink Free",Font.BOLD,35));
        counter.setForeground(Color.red);
        counter.setHorizontalAlignment(SwingUtilities.CENTER);
        counter.setText("0");
        add(counter);
    }
}
