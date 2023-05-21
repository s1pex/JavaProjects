package ShotTheDuck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Frame extends JFrame{
    public Frame(){

        JFrame jFrame = new JFrame("Shot The Duck");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel(new BorderLayout());

        Icon icon1 = new ImageIcon("Images/srart.jpeg");
        JButton jButton1 = new JButton(icon1);
        jPanel.add(jButton1, BorderLayout.NORTH);
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    new DifficultyFrame();
                    jFrame.dispose();
            }
        });


        Icon icon2 = new ImageIcon("Images/score.jpeg");
        JButton jButton2 = new JButton(icon2);
        jPanel.add(jButton2, BorderLayout.CENTER);


        Icon icon3 = new ImageIcon("Images/exit.jpeg");
        JButton jButton3 = new JButton(icon3);
        jPanel.add(jButton3, BorderLayout.SOUTH);
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jFrame.setSize(600,530);
        jFrame.add(jPanel);
        jFrame.setVisible(true);





    }



}
