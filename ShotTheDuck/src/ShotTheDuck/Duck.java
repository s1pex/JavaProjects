package ShotTheDuck;

import javax.swing.*;

import static java.lang.Thread.sleep;


public class Duck extends JButton {
    int clickCount;
    int x;
    int y;
    int healthPoint;
    boolean left;
    static int[] step = {1};
    boolean isKilled = false;
    Icon yellowDuck = new ImageIcon("Images/yellowduck.png");
    Icon greenDuck = new ImageIcon("Images/greenduck.png");
    Icon purrpleDuck = new ImageIcon("Images/purrpleduck.png");
    Icon redDuck = new ImageIcon("Images/redduck.png");


    public Duck(int x, int y, boolean left){
        this.x = x;
        this.y = y;
        this.left = left;
        this.clickCount = 0;

    }

    public void move(){
        if(left == true){
            x -= step[0];
        } else {
            x += step[0];
        }

        setBounds(x,y,100,100);
    }

    public static void makeGameHarder(){
        Thread thread2 = new Thread(() -> {
            try {
                int n = 0;

                do {
                    sleep(5000);
                    step[0] += 1;
                    n++;

                }while(n< 100);
            } catch (Exception e){

            }
        });
        thread2.start();
    }

    public void setHealthPoint(){
        if(getIcon().equals(yellowDuck)){
            healthPoint = 1;
        } else if(getIcon().equals(greenDuck)){
            healthPoint = 3;
        } else if(getIcon().equals(purrpleDuck)){
            healthPoint = 5;
        } else {
            healthPoint = 10;
        }

    }








}
