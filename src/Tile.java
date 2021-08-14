import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel {
    final int SIZE=GamePanel.TILE_SIZE;
    Tile(){
        setSize(SIZE,SIZE);
        setBackground(Color.black);
        setOpaque(true);

    }
}
