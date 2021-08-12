import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {
    final int GAME_SPEED=1;
    static final int TILE_SIZE=20;
    String direction="R";

    Timer gameClock=new Timer(1000/GAME_SPEED,this);
    Tile[][] snake=new Tile[10][10];
    GamePanel(){
        setLayout(null);
        setPreferredSize(new Dimension(600,400));
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());

        snake[0][0]=new Tile();
        add(snake[0][0]);
        snake[0][0].setOpaque(true);
        snake[0][0].setBackground(Color.black);
        snake[0][0].setBounds(100,100,TILE_SIZE,TILE_SIZE);
        add(new Apple());

        gameClock.start();

    }
    void newTile(){

    }
    void move(){
        if (direction.equals("R"))
            snake[0][0].setLocation(snake[0][0].getX()+TILE_SIZE,snake[0][0].getY());
        if (direction.equals("L"))
            snake[0][0].setLocation(snake[0][0].getX()-TILE_SIZE,snake[0][0].getY());
        if (direction.equals("UP"))
            snake[0][0].setLocation(snake[0][0].getX(),snake[0][0].getY()-TILE_SIZE);
        if (direction.equals("DOWN"))
            snake[0][0].setLocation(snake[0][0].getX(),snake[0][0].getY()+TILE_SIZE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
    }

    class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if ((e.getKeyCode()==KeyEvent.VK_UP) && (!direction.equals("DOWN"))){
                direction="UP";
            }
            if ((e.getKeyCode()==KeyEvent.VK_DOWN) && (!direction.equals("UP"))){
                direction="DOWN";
            }
            if ((e.getKeyCode()==KeyEvent.VK_LEFT) && (!direction.equals("R"))){
                direction="L";
            }
            if ((e.getKeyCode()==KeyEvent.VK_RIGHT) && (!direction.equals("L"))){
                direction="R";
            }
        }

    }
}
