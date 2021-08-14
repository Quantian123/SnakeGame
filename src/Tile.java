import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel {
    final int SIZE=GamePanel.TILE_SIZE;
    final ImageIcon TILE_PNG = new ImageIcon(new ImageIcon("Tile.png")
            .getImage().getScaledInstance(SIZE,SIZE, Image.SCALE_SMOOTH));
    Tile(){
        setSize(SIZE,SIZE);
        setIcon(TILE_PNG);
    }
}
