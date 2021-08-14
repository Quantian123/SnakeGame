import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Apple extends JLabel {
    Random random =new Random();
    final int APPLE_SIZE=GamePanel.TILE_SIZE;
    final ImageIcon APPLE_PNG = new ImageIcon(new ImageIcon("Apple.png")
            .getImage().getScaledInstance(APPLE_SIZE, APPLE_SIZE, Image.SCALE_SMOOTH));

    int appleX=random.nextInt(GamePanel.GAME_WIDTH/APPLE_SIZE)*APPLE_SIZE;
    int appleY=random.nextInt(GamePanel.GAME_HEIGHT/APPLE_SIZE)*APPLE_SIZE;
    Apple(){
        setBounds(appleX,appleY,APPLE_SIZE,APPLE_SIZE);
        setIcon(APPLE_PNG);
    }
}
