package ShotTheDuck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyFrame {

    public DifficultyFrame(){
        JFrame jFrame = new JFrame("Shot The Duck");
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("EASY");
        JButton jButton1 = new JButton("MEDIUM");
        JButton jButton2 = new JButton("HARD");
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new FrameWithGameEasy();
            }
        });
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new FrameWithGameMedium();
            }
        });
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                new FrameWithGameHard();
            }
        });
        jFrame.setVisible(true);
        jButton.setPreferredSize(new Dimension(100,30));
        jButton1.setPreferredSize(new Dimension(100,30));
        jButton2.setPreferredSize(new Dimension(100,30));
        jFrame.add(jPanel);
        jPanel.add(jButton);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jFrame.pack();


    }
}
