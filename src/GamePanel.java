import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    final int GAME_SPEED=6;
    static final int TILE_SIZE=20;
    final int SNAKE_INITIAL_SIZE=6;

    Apple apple;
    String direction="RIGHT";
    int applesEaten=0;

    Point savedLocation1=new Point();
    Point savedLocation2=new Point();

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
        for (int i=0;i<SNAKE_INITIAL_SIZE;i++) {
            snake.add(new Tile());
            add(snake.get(i));
        }
    }
    void moveHead(){
        savedLocation1=snake.get(0).getLocation();

        if (direction.equals("RIGHT"))
                snake.get(0).setLocation(snake.get(0).getX() + TILE_SIZE, snake.get(0).getY());
        if (direction.equals("LEFT"))
                snake.get(0).setLocation(snake.get(0).getX() - TILE_SIZE, snake.get(0).getY());
        if (direction.equals("UP"))
                snake.get(0).setLocation(snake.get(0).getX(), snake.get(0).getY() - TILE_SIZE);
        if (direction.equals("DOWN"))
                snake.get(0).setLocation(snake.get(0).getX(), snake.get(0).getY() + TILE_SIZE);
    }
    void moveRest(){
        for (int i=1;i<snake.size();i++) {
            savedLocation2=snake.get(i).getLocation();
            snake.get(i).setLocation(savedLocation1);
            savedLocation1=savedLocation2;
        }

    }
    void checkAppleCollision(){
        if(snake.get(0).getLocation().equals(apple.getLocation())){
            snake.add(new Tile());
            snake.get(snake.size()-1).setLocation(apple.getLocation());
            add(snake.get(snake.size()-1));

            remove(apple);
            apple=new Apple();
            add(apple);
            applesEaten++;
            SwingUtilities.updateComponentTreeUI(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        moveHead();
        moveRest();
        checkAppleCollision();

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
            if ((e.getKeyCode()==KeyEvent.VK_SPACE) && (gameClock.isRunning())){
                gameClock.stop();
            }else gameClock.start();
        }
    }
}
