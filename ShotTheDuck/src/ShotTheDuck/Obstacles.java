package ShotTheDuck;

import javax.swing.*;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Obstacles extends JButton {

     int x;
     int y;
     boolean left;

    public Obstacles(int x, int y, boolean left){
          this.x = x;
          this.y = y;
          this.left = left;
    }

    public void move(){
        if(left == true){
            x -= 2;
        } else {
            x += 2;
        }
    setBounds(x,y,225,100);
    }

}

