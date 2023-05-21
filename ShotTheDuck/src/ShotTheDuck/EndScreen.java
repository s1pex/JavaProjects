package ShotTheDuck;

import javax.swing.*;
import java.awt.*;

public class EndScreen extends JFrame{
    JFrame jFrame = new JFrame("End of the game");
    JPanel jPanel = new JPanel();


    public EndScreen(){
        jFrame.add(jPanel);
        JLabel pointsLabel = new JLabel();
        JLabel timeLabel = new JLabel();
        JLabel nameLabel = new JLabel();

        pointsLabel.setLocation(100, 20);
        pointsLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        pointsLabel.setText("Lifes : "  );

        timeLabel.setBounds(540, 20,340, 20);
        timeLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        timeLabel.setText("Lifes : " );

        nameLabel.setBounds(980, 20,340, 20);
        nameLabel.setFont(new Font("Serif", Font.ITALIC, 18));
        nameLabel.setText("Lifes : " );

        jFrame.setVisible(true);
        jPanel.setVisible(true);
        jPanel.add(nameLabel);
        jPanel.add(timeLabel);
        jPanel.add(pointsLabel);
        jFrame.setSize(1440,810);
    }

}
