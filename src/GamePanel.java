import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    final int GAME_SPEED=6;
    static final int TILE_SIZE=20;
    Apple apple;
    String direction="RIGHT";
    int lastX;
    int lastY;

    Timer gameClock=new Timer(1000/GAME_SPEED,this);
    ArrayList<Tile> snake= new ArrayList<>();
    
    GamePanel(){
        setLayout(null);
        setPreferredSize(new Dimension(600,400));
        setFocusable(true);
        addKeyListener(new MyKeyAdapter());

        addSnake();
        apple=new Apple();
        add(apple);

        gameClock.start();


    }
    void addSnake(){
        snake.add(new Tile());
        snake.get(0).setBounds(160,100,TILE_SIZE,TILE_SIZE);
        add(snake.get(0));
    }
    void newTile(){
        snake.add(new Tile());
        snake.get(snake.size()-1).setBounds(lastX,lastY,TILE_SIZE,TILE_SIZE);
        snake.get(snake.size()-1).direction=snake.get(snake.size()-2).direction;
        add(snake.get(snake.size()-1));


    }
    void move(){
        snake.get(0).direction=direction;

            if (snake.get(0).direction.equals("RIGHT"))
                snake.get(0).setLocation(snake.get(0).getX() + TILE_SIZE, snake.get(0).getY());
            if (direction.equals("LEFT"))
                snake.get(0).setLocation(snake.get(0).getX() - TILE_SIZE, snake.get(0).getY());
            if (direction.equals("UP"))
                snake.get(0).setLocation(snake.get(0).getX(), snake.get(0).getY() - TILE_SIZE);
            if (direction.equals("DOWN"))
                snake.get(0).setLocation(snake.get(0).getX(), snake.get(0).getY() + TILE_SIZE);
        for (int i=1;i<snake.size()-1;i++) {
            snake.get(i).setLocation(snake.get(i-1).getLocation());
        }
    }
    void checkAppleEaten(){
        if(snake.get(0).getLocation().equals(apple.getLocation())){
            newTile();
            remove(apple);
            apple=new Apple();
            add(apple);
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lastX=snake.get(snake.size()-1).getX();
        lastY=snake.get(snake.size()-1).getY();
        move();
        checkAppleEaten();
        System.out.println(lastX+"  "+lastY);
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
            if ((e.getKeyCode()==KeyEvent.VK_LEFT) && (!direction.equals("RIGHT"))){
                direction="LEFT";
            }
            if ((e.getKeyCode()==KeyEvent.VK_RIGHT) && (!direction.equals("LEFT"))){
                direction="RIGHT";
            }
        }

    }
}
