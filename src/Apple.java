import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Apple extends JLabel {
    Random random =new Random();

    final int APPLE_SIZE=GamePanel.TILE_SIZE;
    int appleX=random.nextInt(600/APPLE_SIZE)*APPLE_SIZE;
    int appleY=random.nextInt(400/APPLE_SIZE)*APPLE_SIZE;
    Apple(){
        setBounds(appleX,appleY,APPLE_SIZE,APPLE_SIZE);
        setBackground(Color.red);
        setOpaque(true);
    }
}
